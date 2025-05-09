package pe.colegiodeabogados.puno.Icap.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.colegiodeabogados.puno.Icap.dtos.AgremiadoDTO;
import pe.colegiodeabogados.puno.Icap.mappers.AgremiadoMapper;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;
import pe.colegiodeabogados.puno.Icap.model.EstadoColegiado;
import pe.colegiodeabogados.puno.Icap.model.TipoColegiado;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;
import pe.colegiodeabogados.puno.Icap.repository.*;
import pe.colegiodeabogados.puno.Icap.service.IAgremiadoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.service.ITipoColegiadoService;

import javax.sql.DataSource;

@Transactional
@Service
@RequiredArgsConstructor
public class AgremiadoServiceImpl extends CrudGenericoServiceImp<Agremiado,Long>implements IAgremiadoService {

    @Autowired
    private DataSource dataSource;
    private  final IAgremiadoRepository agremiadoRepository;
    private final AgremiadoMapper agremiadoMapper;
    private final ITipoColegiadoRepository tipoColegiadoRepository;
    private final IEstadoColegiadoRepository estadoColegiadoRepository;
    private final ITrabajadorRepository trabajadorRepository;
    @Override
    protected ICrudGenericRepository<Agremiado, Long> getRepo() {
        return agremiadoRepository;
    }

    @Override
    public AgremiadoDTO saveD(AgremiadoDTO.AgremiadoCADto dto) {
        Agremiado agremiado = agremiadoMapper.toEntityFromCADTO(dto);
        TipoColegiado tipoColegiado =tipoColegiadoRepository.findById(dto.tipoColegiado())
                        .orElseThrow(() -> new EntityNotFoundException("Categoriano encontrada"));
        EstadoColegiado estadoColegiado = estadoColegiadoRepository.findById(dto.estadoColegiado())
                                .orElseThrow(() -> new EntityNotFoundException("Marca noencontrada"));
        Trabajador trabajador =trabajadorRepository.findById(dto.trabajador())
                .orElseThrow(() -> new EntityNotFoundException("Unidad de medida no encontrada"));
        agremiado.setTrabajador(trabajador);
        agremiado.setEstadoColegiado(estadoColegiado);
        agremiado.setTipoColegiado(tipoColegiado);
        Agremiado agremiadoGuardado = agremiadoRepository.save(agremiado);
        return agremiadoMapper.toDTO(agremiadoGuardado);


}

    @Override
    public AgremiadoDTO updateD(AgremiadoDTO.AgremiadoCADto dto, Long id) {

        Agremiado agremiado = agremiadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        Agremiado agremiadox = agremiadoMapper.toEntityFromCADTO(dto);
        agremiadox.setIdAgremiado(agremiado.getIdAgremiado());
        TipoColegiado tipoColegiado = tipoColegiadoRepository.findById(dto.tipoColegiado())
                        .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
        EstadoColegiado estadoColegiado = estadoColegiadoRepository.findById(dto.estadoColegiado())
                                .orElseThrow(() -> new EntityNotFoundException("Marca no  encontrada"));
        Trabajador trabajador =trabajadorRepository.findById(dto.trabajador())
                                                .orElseThrow(() -> new EntityNotFoundException("Unidad de medida no encontrada"));
        agremiadox.setEstadoColegiado(estadoColegiado);
        agremiadox.setTipoColegiado(tipoColegiado);
        agremiadox.setTrabajador(trabajador);
        Agremiado agremiadoActualizado = agremiadoRepository.save(agremiadox);
        return agremiadoMapper.toDTO(agremiadoActualizado);

    }


}

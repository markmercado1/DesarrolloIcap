package pe.colegiodeabogados.puno.Icap.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import pe.colegiodeabogados.puno.Icap.dtos.AgremiadoDTO;
import pe.colegiodeabogados.puno.Icap.dtos.DetallePagoDTO;
import pe.colegiodeabogados.puno.Icap.mappers.DetallePagoMapper;
import pe.colegiodeabogados.puno.Icap.model.*;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IDetallePagoRepository;
import pe.colegiodeabogados.puno.Icap.repository.IPagoRepository;
import pe.colegiodeabogados.puno.Icap.repository.ITrabajadorRepository;
import pe.colegiodeabogados.puno.Icap.service.IDetallePagoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Transactional
@Service
@RequiredArgsConstructor
public class DetallePagoServiceImpl extends CrudGenericoServiceImp<DetallePago,Long>
        implements IDetallePagoService {

    @Autowired
    private DataSource dataSource;
    private  final IDetallePagoRepository detallePagoRepository;
    private final DetallePagoMapper detallePagoMapper;
    private final IPagoRepository pagoRepository;

    @Override
    protected ICrudGenericRepository<DetallePago, Long> getRepo() {
        return detallePagoRepository;
    }


    @Override
    public DetallePagoDTO saveD(DetallePagoDTO.DetallePagoCADTo dto) {
        DetallePago detallePago = detallePagoMapper.toEntityFromCADTO(dto);
        Pago pago =pagoRepository.findById(dto.pago())
                .orElseThrow(() -> new EntityNotFoundException("Pago  no encontrado"));
        detallePago.setPago(pago);

        DetallePago detallePagoGuardado = detallePagoRepository.save(detallePago);
        return detallePagoMapper.toDTO(detallePagoGuardado);


    }

    @Override
    public DetallePagoDTO updateD(DetallePagoDTO.DetallePagoCADTo dto, Long id) {

        DetallePago detallePago = detallePagoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Detalle pago  no encontrado"));
        DetallePago detallePagox = detallePagoMapper.toEntityFromCADTO(dto);
        detallePagox.setIdDetallePago(detallePago.getIdDetallePago());
        Pago pago = pagoRepository.findById(dto.pago())
                .orElseThrow(() -> new EntityNotFoundException("pago  no encontrada"));

        detallePagox.setPago(pago);
        DetallePago detallePagoActualizado = detallePagoRepository.save(detallePagox);
        return detallePagoMapper.toDTO(detallePagoActualizado);

    }

}
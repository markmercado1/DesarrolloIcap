package pe.colegiodeabogados.puno.Icap.service.impl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.dtos.DetallePagoDTO;
import pe.colegiodeabogados.puno.Icap.dtos.PagoConDetallesDTO;
import pe.colegiodeabogados.puno.Icap.dtos.PagoDTO;
import pe.colegiodeabogados.puno.Icap.mappers.PagoMapper;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;
import pe.colegiodeabogados.puno.Icap.model.Pago;
import pe.colegiodeabogados.puno.Icap.repository.IAgremiadoRepository;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IDetallePagoRepository;
import pe.colegiodeabogados.puno.Icap.repository.IPagoRepository;
import pe.colegiodeabogados.puno.Icap.service.IPagoService;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class PagoServiceImpl extends CrudGenericoServiceImp<Pago,Long>
        implements IPagoService {
   private final IPagoRepository pagoRepository;
   private final IDetallePagoRepository detallePagoRepository;
   private final PagoMapper pagoMapper;
   private final IAgremiadoRepository agremiadoRepository;

    @Override
    protected ICrudGenericRepository<Pago, Long> getRepo() {
        return pagoRepository;
    }
    @Override
    public Pago savePagoConDetalles(PagoConDetallesDTO dto) {
        Pago pago = dto.getPago();
        List<DetallePago> detalles = dto.getDetalles();

        Pago pagoGuardado = pagoRepository.save(pago);

        for (DetallePago detalle : detalles) {
            detalle.setPago(pagoGuardado);
            detallePagoRepository.save(detalle);
        }
        return pagoGuardado;
    }

    @Override
    public PagoDTO saveD(PagoDTO.PagoCADto dto) {
        Pago pago = pagoMapper.toEntityFromCADTO(dto);
        Agremiado agremiado =agremiadoRepository.findById(dto.agremiado())
                .orElseThrow(() -> new EntityNotFoundException("Agremiado no encontrado"));
        pago.setAgremiado(agremiado);

        Pago pagoGuaradado = pagoRepository.save(pago);
        return pagoMapper.toDTO(pagoGuaradado);


    }

    @Override
    public PagoDTO updateD(PagoDTO.PagoCADto dto, Long id) {

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pago  no encontrado"));
        Pago pagox = pagoMapper.toEntityFromCADTO(dto);
        pagox.setIdPago(pago.getIdPago());
        Agremiado agremiado = agremiadoRepository.findById(dto.agremiado())
                .orElseThrow(() -> new EntityNotFoundException("agremiado no encontrada"));

        pagox.setAgremiado(agremiado);
        Pago pagoActualizado = pagoRepository.save(pagox);
        return pagoMapper.toDTO(pagoActualizado);

    }
}

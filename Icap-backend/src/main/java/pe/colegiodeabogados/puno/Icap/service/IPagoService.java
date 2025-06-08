package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.dtos.PagoConDetallesDTO;
import pe.colegiodeabogados.puno.Icap.dtos.PagoDTO;
import pe.colegiodeabogados.puno.Icap.model.Pago;

public interface IPagoService extends ICrudGenericService<Pago,Long>{
    Pago savePagoConDetalles(PagoConDetallesDTO pagoConDetallesDTO);
    PagoDTO saveD(PagoDTO.PagoCADto dto);
    PagoDTO updateD(PagoDTO.PagoCADto dto, Long id);
}

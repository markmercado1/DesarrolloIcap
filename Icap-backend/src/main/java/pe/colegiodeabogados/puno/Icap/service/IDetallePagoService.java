package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.dtos.AgremiadoDTO;
import pe.colegiodeabogados.puno.Icap.dtos.DetallePagoDTO;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;

public interface IDetallePagoService  extends ICrudGenericService<DetallePago,Long>{
    DetallePagoDTO saveD(DetallePagoDTO.DetallePagoCADTo dto);
    DetallePagoDTO updateD(DetallePagoDTO.DetallePagoCADTo dto, Long id);
}

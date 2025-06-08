package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.colegiodeabogados.puno.Icap.dtos.AgremiadoDTO;
import pe.colegiodeabogados.puno.Icap.dtos.DetallePagoDTO;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;
@Mapper(componentModel = "spring", uses = {
        PagoMapper.class,

})
public interface DetallePagoMapper extends GenericMapper<DetallePagoDTO, DetallePago>{

    @Mapping(target = "pago", ignore = true)
    DetallePago toEntityFromCADTO(DetallePagoDTO.DetallePagoCADTo detallePagoCrearDTO);
}

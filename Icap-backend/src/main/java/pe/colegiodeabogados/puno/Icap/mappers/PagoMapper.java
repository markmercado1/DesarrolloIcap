package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.colegiodeabogados.puno.Icap.dtos.PagoDTO;
import pe.colegiodeabogados.puno.Icap.model.Pago;

@Mapper(componentModel = "spring", uses = {
        AgremiadoMapper.class,

})

public interface PagoMapper extends GenericMapper<PagoDTO, Pago>{


    @Mapping(target = "agremiado", ignore = true)
    Pago toEntityFromCADTO(PagoDTO.PagoCADto pagoCrearDTO);


}

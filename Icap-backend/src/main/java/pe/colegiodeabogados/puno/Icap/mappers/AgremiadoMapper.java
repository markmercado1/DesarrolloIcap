package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.colegiodeabogados.puno.Icap.dtos.AgremiadoDTO;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;
@Mapper(componentModel = "spring", uses = {
        TipoColegiadoMapper.class,
        EstadoColegiadoMapper.class,
        TrabajadorMapper.class
})
public interface AgremiadoMapper extends GenericMapper<AgremiadoDTO, Agremiado> {

    @Mapping(target = "tipoColegiado", ignore = true)
    @Mapping(target = "estadoColegiado", ignore = true)
    @Mapping(target = "trabajador", ignore = true)
    Agremiado toEntityFromCADTO(AgremiadoDTO.AgremiadoCADto agremiadoCrearDTO);
}

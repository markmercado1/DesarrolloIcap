package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.colegiodeabogados.puno.Icap.dtos.TrabajadorDTO;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper extends GenericMapper<TrabajadorDTO, Trabajador> {
    @Mapping(target = "tPassword", ignore = true) // lo ignoramos porque no está en el DTO
    Trabajador toEntity(TrabajadorDTO dto);

    TrabajadorDTO toDTO(Trabajador entity);
}

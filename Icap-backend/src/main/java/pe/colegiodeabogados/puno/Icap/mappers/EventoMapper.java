package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.colegiodeabogados.puno.Icap.dtos.EventoDTO;
import pe.colegiodeabogados.puno.Icap.model.Evento;

@Mapper(componentModel = "spring")
public interface EventoMapper extends GenericMapper<EventoDTO, Evento>{

    @Mapping(target = "trabajador", ignore = true)
    Evento toEntityFromCADTO(EventoDTO.EventoCADTo eventoCrearDTo);
}

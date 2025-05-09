package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import pe.colegiodeabogados.puno.Icap.dtos.TrabajadorDTO;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper extends GenericMapper<TrabajadorDTO, Trabajador> {
}

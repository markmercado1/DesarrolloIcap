package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import pe.colegiodeabogados.puno.Icap.dtos.AccesoDTO;
import pe.colegiodeabogados.puno.Icap.model.Acceso;


@Mapper(componentModel = "spring")
public interface AccesoMapper extends GenericMapper<AccesoDTO, Acceso> {
}
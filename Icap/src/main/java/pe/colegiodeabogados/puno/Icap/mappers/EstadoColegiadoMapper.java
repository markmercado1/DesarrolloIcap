package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import pe.colegiodeabogados.puno.Icap.dtos.EstadoColegiadoDTO;
import pe.colegiodeabogados.puno.Icap.model.EstadoColegiado;

@Mapper(componentModel = "spring")
public interface EstadoColegiadoMapper extends GenericMapper<EstadoColegiadoDTO, EstadoColegiado> {
}

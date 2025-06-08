package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import pe.colegiodeabogados.puno.Icap.dtos.TipoColegiadoDTO;
import pe.colegiodeabogados.puno.Icap.model.TipoColegiado;

@Mapper(componentModel = "spring")

public interface TipoColegiadoMapper extends GenericMapper<TipoColegiadoDTO,
        TipoColegiado>{
}

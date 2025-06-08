package pe.colegiodeabogados.puno.Icap.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.colegiodeabogados.puno.Icap.dtos.UsuarioDTO;

import pe.colegiodeabogados.puno.Icap.model.Usuario;

@Mapper(componentModel = "spring", uses = {
        AgremiadoMapper.class,
        TrabajadorMapper.class
})
public interface UserAgremiadoMapper extends GenericMapper<UsuarioDTO, Usuario>{


    @Mapping(target = "clave", ignore = true)
    Usuario toEntityFromCADTO(UsuarioDTO.UsuarioCrearDto usuarioCrearDto);
}

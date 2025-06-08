package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.dtos.UsuarioDTO;

import pe.colegiodeabogados.puno.Icap.model.Usuario;

public interface IUsuarioService extends ICrudGenericService<Usuario,Long>{
    public UsuarioDTO login(UsuarioDTO.CredencialesDto credentialsDto);
    public UsuarioDTO register(UsuarioDTO.UsuarioCrearDto userDto);
}

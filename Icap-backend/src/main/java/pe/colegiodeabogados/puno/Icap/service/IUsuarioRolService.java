package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.model.UsuarioRol;

import java.util.List;

public interface IUsuarioRolService {
    List<UsuarioRol> findOneByUsuarioUser(String user);
    UsuarioRol save(UsuarioRol ur);
    //Usuario login(String usuario, String password);

}
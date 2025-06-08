package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.model.Rol;

import java.util.Optional;

public interface IRolService extends ICrudGenericService<Rol, Long>{
    public Optional<Rol> getByNombre(Rol.RolNombre rolNombre);
}
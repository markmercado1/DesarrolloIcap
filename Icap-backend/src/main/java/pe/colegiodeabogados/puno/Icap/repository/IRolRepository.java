package pe.colegiodeabogados.puno.Icap.repository;

import pe.colegiodeabogados.puno.Icap.model.Rol;


import java.util.Optional;

public interface IRolRepository extends ICrudGenericRepository<Rol, Long>{
    Optional<Rol> findByNombre(Rol.RolNombre rolNombre);

    Optional<Rol> findByDescripcion(String nombre);

}
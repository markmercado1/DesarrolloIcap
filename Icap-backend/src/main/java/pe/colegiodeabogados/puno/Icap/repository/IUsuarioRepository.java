package pe.colegiodeabogados.puno.Icap.repository;


import pe.colegiodeabogados.puno.Icap.model.Usuario;

import java.util.Optional;

public interface IUsuarioRepository extends ICrudGenericRepository<Usuario,Long>{

    Optional<Usuario> findOneByUser(String user);


}

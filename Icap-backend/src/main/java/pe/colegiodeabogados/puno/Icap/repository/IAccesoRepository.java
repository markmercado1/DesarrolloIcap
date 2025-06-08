package pe.colegiodeabogados.puno.Icap.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.colegiodeabogados.puno.Icap.model.Acceso;

import java.util.List;

public interface IAccesoRepository extends ICrudGenericRepository<Acceso, Long> {
    @Query(value = """
     SELECT a.* FROM icap_acceso_rol ar
     INNER JOIN icap_usuario_rol ur ON (ur.rol_id=ar.rol_id)
     INNER JOIN icap_accesos a ON (a.id_acceso=ar.acceso_id)
     INNER JOIN icap_usuario u ON (u.id_usuario=ur.usuario_id)
     WHERE u.user=:username
 """, nativeQuery = true)
    List<Acceso> getAccesoByUser(@Param("username") String username);
}
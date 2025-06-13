package pe.colegiodeabogados.puno.Icap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.colegiodeabogados.puno.Icap.model.VistaAgremiado;


public interface VistaAgremiadoRepository extends JpaRepository<VistaAgremiado, Long> {

    @Query("SELECT v FROM VistaAgremiado v WHERE " +
            "LOWER(v.dni) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(v.aNombres) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(v.aApellidoPaterno) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(v.aApellidoMaterno) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    Page<VistaAgremiado> buscarPorFiltroGlobal(@Param("filtro") String filtro, Pageable pageable);

}
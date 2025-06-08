package pe.colegiodeabogados.puno.Icap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICrudGenericRepository<T,ID> extends JpaRepository<T,ID> {
}

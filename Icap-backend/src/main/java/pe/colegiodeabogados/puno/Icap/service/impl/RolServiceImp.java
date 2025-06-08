package pe.colegiodeabogados.puno.Icap.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.Rol;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IRolRepository;
import pe.colegiodeabogados.puno.Icap.service.IRolService;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RolServiceImp extends CrudGenericoServiceImp<Rol, Long> implements IRolService {
    private final IRolRepository repo;
    @Override
    protected ICrudGenericRepository<Rol, Long> getRepo() {
        return repo;
    }
    @Override
    public Optional<Rol> getByNombre(Rol.RolNombre rolNombre) {
        return repo.findByNombre(rolNombre);
    }

}
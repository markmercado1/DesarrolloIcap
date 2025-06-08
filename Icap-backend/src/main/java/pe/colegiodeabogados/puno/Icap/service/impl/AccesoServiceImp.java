package pe.colegiodeabogados.puno.Icap.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.Acceso;
import pe.colegiodeabogados.puno.Icap.repository.IAccesoRepository;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.service.IAccesoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccesoServiceImp extends CrudGenericoServiceImp<Acceso, Long> implements IAccesoService {
    private final IAccesoRepository repo;
    @Override
    protected ICrudGenericRepository<Acceso, Long> getRepo() {
        return repo;
    }
    @Override
    public List<Acceso> getAccesoByUser(String username) {
        return repo.getAccesoByUser(username);
    }
}
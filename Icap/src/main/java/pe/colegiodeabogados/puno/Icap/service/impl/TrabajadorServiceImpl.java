package pe.colegiodeabogados.puno.Icap.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.ITrabajadorRepository;
import pe.colegiodeabogados.puno.Icap.service.ITrabajadorService;

@Transactional
@Service
@RequiredArgsConstructor
public class TrabajadorServiceImpl extends CrudGenericoServiceImp<Trabajador,Long>
        implements ITrabajadorService {
    private final ITrabajadorRepository trabajadorRepository;
    @Override
    protected ICrudGenericRepository<Trabajador, Long> getRepo() {
        return trabajadorRepository;
    }
}

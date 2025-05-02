package pe.colegiodeabogados.puno.Icap.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.TipoColegiado;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.ITipoColegiadoRepository;
import pe.colegiodeabogados.puno.Icap.service.ITipoColegiadoService;

@Transactional
@Service
@RequiredArgsConstructor
public class TipoColegiadoServiceImpl extends CrudGenericoServiceImp<TipoColegiado,Long>
        implements ITipoColegiadoService {
    private final ITipoColegiadoRepository tipoColegiadoRepository;
    @Override
    protected ICrudGenericRepository<TipoColegiado, Long> getRepo() {
        return tipoColegiadoRepository;
    }
}

package pe.colegiodeabogados.puno.Icap.service.impl;

import pe.colegiodeabogados.puno.Icap.model.EstadoColegiado;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IEstadoColegiadoRepository;
import pe.colegiodeabogados.puno.Icap.service.IEstadoColegiadoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Transactional
@Service
@RequiredArgsConstructor
public class EstadoColegioadoServiceImpl extends CrudGenericoServiceImp<EstadoColegiado,Long>
        implements IEstadoColegiadoService {

    private final IEstadoColegiadoRepository estadoColegiadoRepository;
    @Override
    protected ICrudGenericRepository<EstadoColegiado, Long> getRepo() {
        return estadoColegiadoRepository;
    }
}

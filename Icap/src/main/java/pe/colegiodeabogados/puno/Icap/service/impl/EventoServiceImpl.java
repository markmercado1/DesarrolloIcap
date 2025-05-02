package pe.colegiodeabogados.puno.Icap.service.impl;

import pe.colegiodeabogados.puno.Icap.model.Evento;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IEventoRepository;
import pe.colegiodeabogados.puno.Icap.service.IEventoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Transactional
@Service
@RequiredArgsConstructor
public class EventoServiceImpl extends CrudGenericoServiceImp<Evento,Long>
        implements IEventoService {
    private final IEventoRepository eventoRepository;
    @Override
    protected ICrudGenericRepository<Evento, Long> getRepo() {
        return eventoRepository;
    }
}

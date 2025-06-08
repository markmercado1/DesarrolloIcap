package pe.colegiodeabogados.puno.Icap.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import pe.colegiodeabogados.puno.Icap.dtos.DetallePagoDTO;
import pe.colegiodeabogados.puno.Icap.dtos.EventoDTO;
import pe.colegiodeabogados.puno.Icap.mappers.EventoMapper;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;
import pe.colegiodeabogados.puno.Icap.model.Evento;
import pe.colegiodeabogados.puno.Icap.model.Pago;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IEventoRepository;
import pe.colegiodeabogados.puno.Icap.repository.ITrabajadorRepository;
import pe.colegiodeabogados.puno.Icap.service.IEventoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Transactional
@Service
@RequiredArgsConstructor
public class EventoServiceImpl extends CrudGenericoServiceImp<Evento,Long>
        implements IEventoService {
    @Autowired
    private final DataSource dataSource;
    private final IEventoRepository eventoRepository;
    private final EventoMapper eventoMapper;
    private final ITrabajadorRepository trabajadorRepository;
    @Override
    protected ICrudGenericRepository<Evento, Long> getRepo() {
        return eventoRepository;
    }

    @Override
    public EventoDTO saveD(EventoDTO.EventoCADTo dto) {
        Evento evento = eventoMapper.toEntityFromCADTO(dto);
        Trabajador trabajador =trabajadorRepository.findById(dto.trabajador())
                .orElseThrow(() -> new EntityNotFoundException("Trabajador no encontrado"));
        evento.setTrabajador(trabajador);

        Evento eventoGuardado = eventoRepository.save(evento);
        return eventoMapper.toDTO(eventoGuardado);


    }

    @Override
    public EventoDTO updateD(EventoDTO.EventoCADTo dto, Long id) {

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento  no encontrado"));
        Evento eventox = eventoMapper.toEntityFromCADTO(dto);
        eventox.setIdEvento(evento.getIdEvento());
        Trabajador trabajador = trabajadorRepository.findById(dto.trabajador())
                .orElseThrow(() -> new EntityNotFoundException("trabajador no encontrado"));

        eventox.setTrabajador(trabajador);
        Evento eventoActualizado = eventoRepository.save(eventox);
        return eventoMapper.toDTO(eventoActualizado);

    }
}

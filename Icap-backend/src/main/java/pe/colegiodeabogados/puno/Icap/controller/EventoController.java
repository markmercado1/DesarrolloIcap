package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.EventoDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.EventoMapper;
import pe.colegiodeabogados.puno.Icap.model.Evento;
import pe.colegiodeabogados.puno.Icap.service.IEventoService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final IEventoService eventoService;
    private final EventoMapper eventoMapper;
    @GetMapping
    public ResponseEntity<List<EventoDTO>> findAll() {
        List<EventoDTO> list = eventoMapper.toDTOs(eventoService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> findById(@PathVariable("id") Long
                                                      id) {
        Evento obj = eventoService.findById(id);
        return ResponseEntity.ok(eventoMapper.toDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CustomErrorResponse   > save(@Valid @RequestBody EventoDTO dto) {
        Evento obj = eventoService.save(eventoMapper.toEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdEvento())
                .toUri();

        CustomErrorResponse response = new CustomErrorResponse(
                201,
                LocalDateTime.now(),
                "true",
                "Registrado correctamente con ID: " + obj.getIdEvento()
        );
        return ResponseEntity.created(location).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> update(@Valid @PathVariable("id") Long  id, @RequestBody
                                            EventoDTO dto) {
        dto.setIdEvento(id);
        Evento obj = eventoService.update(id, eventoMapper.toEntity(dto));
        return ResponseEntity.ok(eventoMapper.toDTO(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse response = eventoService.delete(id);
        return ResponseEntity.ok(response);
    }

}
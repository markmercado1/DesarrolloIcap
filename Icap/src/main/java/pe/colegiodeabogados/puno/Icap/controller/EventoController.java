package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.model.Evento;
import pe.colegiodeabogados.puno.Icap.service.IEventoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final IEventoService eventoService;
    @GetMapping
    public ResponseEntity<List<Evento>> findAll() {
        List<Evento> list = eventoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Evento> findById(@PathVariable("id") Long
                                                      id) {
        Evento obj = eventoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Evento dto) {
        Evento obj = eventoService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdEvento()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            Evento dto) {
        dto.setIdEvento(id);
        Evento obj = eventoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.model.EstadoColegiado;
import pe.colegiodeabogados.puno.Icap.service.IEstadoColegiadoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estadoColegiado")
public class EstadoColegiadoController {
    private final IEstadoColegiadoService estadoColegiadoService;
    @GetMapping
    public ResponseEntity<List<EstadoColegiado>> findAll() {
        List<EstadoColegiado> list = estadoColegiadoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstadoColegiado> findById(@PathVariable("id") Long
                                                      id) {
        EstadoColegiado obj = estadoColegiadoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EstadoColegiado dto) {
        EstadoColegiado obj = estadoColegiadoService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdEstadoColegiado()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstadoColegiado> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            EstadoColegiado dto) {
        dto.setIdEstadoColegiado(id);
        EstadoColegiado obj = estadoColegiadoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        estadoColegiadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
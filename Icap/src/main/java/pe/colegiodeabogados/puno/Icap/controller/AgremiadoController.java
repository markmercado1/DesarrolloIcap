package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;
import pe.colegiodeabogados.puno.Icap.service.IAgremiadoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/agremiados")
public class AgremiadoController {
    private final IAgremiadoService agremiadoService;
    @GetMapping
    public ResponseEntity<List<Agremiado>> findAll() {
        List<Agremiado> list = agremiadoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Agremiado> findById(@PathVariable("id") Long
                                                      id) {
        Agremiado obj = agremiadoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Agremiado dto) {
        Agremiado obj = agremiadoService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getIdAgremiado()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Agremiado> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            Agremiado dto) {
        dto.setIdAgremiado(id);
        Agremiado obj = agremiadoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        agremiadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
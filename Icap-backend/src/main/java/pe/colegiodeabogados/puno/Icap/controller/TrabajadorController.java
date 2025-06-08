package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;
import pe.colegiodeabogados.puno.Icap.service.ITrabajadorService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {
    private final ITrabajadorService trabajadorService;
    @GetMapping
    public ResponseEntity<List<Trabajador>> findAll() {
        List<Trabajador> list = trabajadorService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> findById(@PathVariable("id") Long
                                                      id) {
        Trabajador obj = trabajadorService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Trabajador dto) {
        Trabajador obj = trabajadorService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdTrabajador()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            Trabajador dto) {
        dto.setIdTrabajador(id);
        Trabajador obj = trabajadorService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        trabajadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;
import pe.colegiodeabogados.puno.Icap.service.IDetallePagoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/detallePago")
public class DetallePagoController {
    private final IDetallePagoService detallePagoService;
    @GetMapping
    public ResponseEntity<List<DetallePago>> findAll() {
        List<DetallePago> list = detallePagoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetallePago> findById(@PathVariable("id") Long
                                                      id) {
        DetallePago obj = detallePagoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DetallePago dto) {
        DetallePago obj = detallePagoService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdDetallePago()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetallePago> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            DetallePago dto) {
        dto.setIdDetallePago(id);
        DetallePago obj = detallePagoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        detallePagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
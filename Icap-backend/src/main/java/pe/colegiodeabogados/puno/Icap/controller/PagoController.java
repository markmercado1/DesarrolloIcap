package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.model.Pago;
import pe.colegiodeabogados.puno.Icap.service.IPagoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final IPagoService pagoService;
    @GetMapping
    public ResponseEntity<List<Pago>> findAll() {
        List<Pago> list = pagoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pago> findById(@PathVariable("id") Long
                                                      id) {
        Pago obj = pagoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Pago dto) {
        Pago obj = pagoService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdPago()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            Pago dto) {
        dto.setIdPago(id);
        Pago obj = pagoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
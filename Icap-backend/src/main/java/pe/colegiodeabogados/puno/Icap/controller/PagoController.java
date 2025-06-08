package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.PagoConDetallesDTO;
import pe.colegiodeabogados.puno.Icap.dtos.PagoDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.PagoMapper;
import pe.colegiodeabogados.puno.Icap.model.Pago;
import pe.colegiodeabogados.puno.Icap.service.IPagoService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final IPagoService pagoService;
    private final PagoMapper pagoMapper;
    @GetMapping
    public ResponseEntity<List<PagoDTO>> findAll() {
        List<PagoDTO> list = pagoMapper.toDTOs(pagoService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> findById(@PathVariable("id") Long
                                                      id) {
        Pago obj = pagoService.findById(id);
        return ResponseEntity.ok(pagoMapper.toDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CustomErrorResponse> save(@Valid @RequestBody PagoDTO dto) {
        Pago obj = pagoService.save(pagoMapper.toEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdPago())
                .toUri();

        CustomErrorResponse response = new CustomErrorResponse(
                201,
                LocalDateTime.now(),
                "true",
                "Registrado correctamente con ID: " + obj.getIdPago()
        );
        return ResponseEntity.created(location).body(response);

    }
    @PostMapping("/con-detalles")
    public ResponseEntity<Void> saveConDetalles(@Valid @RequestBody PagoConDetallesDTO dto) {
        Pago obj = pagoService.savePagoConDetalles(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdPago()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@Valid @PathVariable("id") Long
                                                    id, @RequestBody
                                            PagoDTO dto) {
        dto.setIdPago(id);
        Pago obj = pagoService.update(id, pagoMapper.toEntity(dto));
        return ResponseEntity.ok(pagoMapper.toDTO(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse response = pagoService.delete(id);
        return ResponseEntity.ok(response);
    }

}
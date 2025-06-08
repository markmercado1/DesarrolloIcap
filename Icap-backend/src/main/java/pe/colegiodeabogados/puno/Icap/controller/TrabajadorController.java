package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.TrabajadorDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.TrabajadorMapper;
import pe.colegiodeabogados.puno.Icap.model.Trabajador;
import pe.colegiodeabogados.puno.Icap.service.ITrabajadorService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {
    private final ITrabajadorService trabajadorService;
    private final TrabajadorMapper trabajadorMapper;
    @GetMapping
    public ResponseEntity<List<TrabajadorDTO>> findAll() {
        List<TrabajadorDTO> list = trabajadorMapper.toDTOs(trabajadorService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> findById(@PathVariable("id") Long
                                                      id) {
        Trabajador obj = trabajadorService.findById(id);
        return ResponseEntity.ok(trabajadorMapper.toDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CustomErrorResponse> save(@Valid @RequestBody TrabajadorDTO dto) {
        Trabajador obj = trabajadorService.save(trabajadorMapper.toEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdTrabajador())
                .toUri();

        CustomErrorResponse response = new CustomErrorResponse(
                201,
                LocalDateTime.now(),
                "true",
                "Registrado correctamente con ID: " + obj.getIdTrabajador()
        );
        return ResponseEntity.created(location).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> update(@Valid @PathVariable("id") Long
                                                    id, @RequestBody
                                            TrabajadorDTO dto) {
        dto.setIdTrabajador(id);
        Trabajador obj = trabajadorService.update(id, trabajadorMapper.toEntity(dto));
        return ResponseEntity.ok(trabajadorMapper.toDTO(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse response = trabajadorService.delete(id);
        return ResponseEntity.ok(response);
    }

}
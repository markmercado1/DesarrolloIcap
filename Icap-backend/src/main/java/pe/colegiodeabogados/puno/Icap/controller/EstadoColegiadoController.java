package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.EstadoColegiadoDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.EstadoColegiadoMapper;
import pe.colegiodeabogados.puno.Icap.model.EstadoColegiado;
import pe.colegiodeabogados.puno.Icap.service.IEstadoColegiadoService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estadoColegiado")
public class EstadoColegiadoController {
    private final IEstadoColegiadoService estadoColegiadoService;
    private final EstadoColegiadoMapper estadoColegiadoMapper;
    @GetMapping
    public ResponseEntity<List<EstadoColegiadoDTO>> findAll() {
        List<EstadoColegiadoDTO> list = estadoColegiadoMapper.toDTOs(estadoColegiadoService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstadoColegiadoDTO> findById(@PathVariable("id") Long
                                                      id) {
        EstadoColegiado obj = estadoColegiadoService.findById(id);
        return ResponseEntity.ok(estadoColegiadoMapper.toDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CustomErrorResponse> save(@Valid @RequestBody EstadoColegiadoDTO dto) {
        EstadoColegiado obj = estadoColegiadoService.save(estadoColegiadoMapper.toEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdEstadoColegiado())
                .toUri();

        CustomErrorResponse response = new CustomErrorResponse(
                201,
                LocalDateTime.now(),
                "true",
                "Registrado correctamente con ID: " + obj.getIdEstadoColegiado()
        );
        return ResponseEntity.created(location).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstadoColegiadoDTO> update(@Valid @PathVariable("id") Long id, @RequestBody EstadoColegiadoDTO dto) {
        dto.setIdEstadoColegiado(id);
        EstadoColegiado obj = estadoColegiadoService.update(id, estadoColegiadoMapper.toEntity(dto));
        return ResponseEntity.ok(estadoColegiadoMapper.toDTO(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse response = estadoColegiadoService.delete(id);
        return ResponseEntity.ok(response);
    }

}
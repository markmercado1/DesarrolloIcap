package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.TipoColegiadoDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.TipoColegiadoMapper;
import pe.colegiodeabogados.puno.Icap.model.TipoColegiado;
import pe.colegiodeabogados.puno.Icap.service.ITipoColegiadoService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoColegiados")
public class    TipoColegiadoController {
    private final ITipoColegiadoService tipoColegiadoService;
    private final TipoColegiadoMapper tipoColegiadoMapper;
    @GetMapping
    public ResponseEntity<List<TipoColegiado>> findAll() {
        List<TipoColegiado> list = tipoColegiadoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoColegiadoDTO> findById(@PathVariable("id") Long id) {
        TipoColegiado obj = tipoColegiadoService.findById(id);
        return ResponseEntity.ok(tipoColegiadoMapper.toDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CustomErrorResponse> save(@Valid @RequestBody TipoColegiadoDTO dto) {
        TipoColegiado obj = tipoColegiadoService.save(tipoColegiadoMapper.toEntity(dto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdTipoColegiado())
                .toUri();

        CustomErrorResponse response = new CustomErrorResponse(
                201,
                LocalDateTime.now(),
                "true",
                "Registrado correctamente con ID: " + obj.getIdTipoColegiado()
        );

        return ResponseEntity.created(location).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoColegiadoDTO> update(@Valid @PathVariable("id") Long id, @RequestBody
                                            TipoColegiadoDTO dto) {
        dto.setIdTipoColegiado(id);
        TipoColegiado obj = tipoColegiadoService.update(id, tipoColegiadoMapper.toEntity(dto));
        return ResponseEntity.ok(tipoColegiadoMapper.toDTO(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse operacion=tipoColegiadoService.delete(id);
        return ResponseEntity.ok(operacion);
    }
}
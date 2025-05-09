package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.TipoColegiadoDTO;
import pe.colegiodeabogados.puno.Icap.mappers.TipoColegiadoMapper;
import pe.colegiodeabogados.puno.Icap.model.TipoColegiado;
import pe.colegiodeabogados.puno.Icap.service.ITipoColegiadoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoColegiados")
public class TipoColegiadoController {
    private final ITipoColegiadoService tipoColegiadoService;
    private final TipoColegiadoMapper tipoColegiadoMapper;
    @GetMapping
    public ResponseEntity<List<TipoColegiado>> findAll() {
        List<TipoColegiado> list = tipoColegiadoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoColegiado> findById(@PathVariable("id") Long
                                                      id) {
        TipoColegiado obj = tipoColegiadoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoColegiadoDTO dto) {
        TipoColegiado obj = tipoColegiadoService.save(tipoColegiadoMapper.toEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdTipoColegiado()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoColegiado> update(@PathVariable("id") Long
                                                    id, @RequestBody
                                            TipoColegiado dto) {
        dto.setIdTipoColegiado(id);
        TipoColegiado obj = tipoColegiadoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tipoColegiadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
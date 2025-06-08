package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.AgremiadoDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.AgremiadoMapper;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;
import pe.colegiodeabogados.puno.Icap.service.IAgremiadoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/agremiados")
public class AgremiadoController {
    private final IAgremiadoService agremiadoService;
    private final AgremiadoMapper agremiadoMapper;
    @GetMapping
    public ResponseEntity<List<AgremiadoDTO>> findAll() {
        List<AgremiadoDTO> list = agremiadoMapper.toDTOs(agremiadoService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgremiadoDTO> findById(@PathVariable("id") Long
                                                      id) {
        Agremiado obj = agremiadoService.findById(id);
        return ResponseEntity.ok(agremiadoMapper.toDTO(obj));
    }


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AgremiadoDTO.AgremiadoCADto dto) {
        AgremiadoDTO obj = agremiadoService.saveD(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getIdAgremiado()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgremiadoDTO> update(@Valid @RequestBody AgremiadoDTO.AgremiadoCADto dto,@PathVariable("id")
                                               Long    id) {

        AgremiadoDTO obj=agremiadoService.updateD(dto,id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse response = agremiadoService.delete(id);
        return ResponseEntity.ok(response);
    }



}
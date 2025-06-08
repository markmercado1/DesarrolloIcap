package pe.colegiodeabogados.puno.Icap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.colegiodeabogados.puno.Icap.dtos.DetallePagoDTO;
import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.mappers.DetallePagoMapper;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;
import pe.colegiodeabogados.puno.Icap.service.IDetallePagoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/detallePago")
public class DetallePagoController {
    private final IDetallePagoService detallePagoService;
    private final DetallePagoMapper detallePagoMapper;
    @GetMapping
    public ResponseEntity<List<DetallePagoDTO>> findAll() {
        List<DetallePagoDTO> list = detallePagoMapper.toDTOs(detallePagoService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetallePagoDTO> findById(@PathVariable("id") Long
                                                      id) {
        DetallePago obj = detallePagoService.findById(id);
        return ResponseEntity.ok(detallePagoMapper.toDTO(obj));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DetallePagoDTO.DetallePagoCADTo dto) {
        DetallePagoDTO obj = detallePagoService.saveD(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getIdDetallePago()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetallePagoDTO> update(@Valid @RequestBody DetallePagoDTO.DetallePagoCADTo dto,
                                                     @PathVariable("id") Long  id) {

        DetallePagoDTO obj = detallePagoService.updateD(dto,id);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomErrorResponse> delete(@PathVariable("id") Long id) {
        CustomErrorResponse response = detallePagoService.delete(id);
        return ResponseEntity.ok(response);
    }

}
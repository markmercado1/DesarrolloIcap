package pe.colegiodeabogados.puno.Icap.controller;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.colegiodeabogados.puno.Icap.model.VistaAgremiado;
import pe.colegiodeabogados.puno.Icap.service.impl.VistaAgremiadoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/vista-agremiados")
@CrossOrigin(origins = "*") // permite acceso desde el frontend
public class VistaAgremiadoController {

    @Autowired
    private VistaAgremiadoServiceImpl service;

    @GetMapping
    public List<VistaAgremiado> listar() {
        return service.listarAgremiados();
    }
    @GetMapping("/agremiados")
    public ResponseEntity<Page<VistaAgremiado>> listarAgremiados(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "idAgremiado") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<VistaAgremiado> agremiados = service.listarAgremiadosPaginado(pageable);
        return new ResponseEntity<>(agremiados, HttpStatus.OK);
    }
    @GetMapping("/buscar")
    public ResponseEntity<VistaAgremiado> buscarPorId(@RequestParam Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Buscar por nombre, apellido, dni, etc. de forma global y paginada
    @GetMapping("/filtrar")
    public ResponseEntity<Page<VistaAgremiado>> filtrarGlobal(
            @RequestParam String filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "idAgremiado") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<VistaAgremiado> resultados = service.buscarPorFiltroGlobal(filtro, pageable);
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

}
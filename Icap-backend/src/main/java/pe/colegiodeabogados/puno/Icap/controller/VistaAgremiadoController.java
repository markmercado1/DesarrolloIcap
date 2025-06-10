package pe.colegiodeabogados.puno.Icap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.colegiodeabogados.puno.Icap.model.VistaAgremiado;
import pe.colegiodeabogados.puno.Icap.service.impl.VistaAgremiadoService;

import java.util.List;

@RestController
@RequestMapping("/api/vista-agremiados")
@CrossOrigin(origins = "*") // permite acceso desde el frontend
public class VistaAgremiadoController {

    @Autowired
    private VistaAgremiadoService service;

    @GetMapping
    public List<VistaAgremiado> listar() {
        return service.listarAgremiados();
    }
}
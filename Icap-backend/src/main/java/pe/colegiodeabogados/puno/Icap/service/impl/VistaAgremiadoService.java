package pe.colegiodeabogados.puno.Icap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.VistaAgremiado;
import pe.colegiodeabogados.puno.Icap.repository.VistaAgremiadoRepository;


import java.util.List;

@Service
public class VistaAgremiadoService {

    @Autowired
    private VistaAgremiadoRepository repository;

    public List<VistaAgremiado> listarAgremiados() {
        return repository.findAll();
    }
}

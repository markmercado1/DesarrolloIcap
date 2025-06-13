package pe.colegiodeabogados.puno.Icap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.VistaAgremiado;
import pe.colegiodeabogados.puno.Icap.repository.VistaAgremiadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.colegiodeabogados.puno.Icap.service.IVistaAgremiadoService;


import java.util.List;
import java.util.Optional;

@Service
public class VistaAgremiadoServiceImpl implements IVistaAgremiadoService {

    @Autowired
    private VistaAgremiadoRepository repository;

    public List<VistaAgremiado> listarAgremiados() {
        return repository.findAll();
    }

    @Override
    public Page<VistaAgremiado> listarAgremiadosPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Optional<VistaAgremiado> buscarPorId(Long id) {
        return repository.findById(id);
    }
    public Page<VistaAgremiado> buscarPorFiltroGlobal(String filtro, Pageable pageable) {
        return repository.buscarPorFiltroGlobal(filtro, pageable);
    }

    }

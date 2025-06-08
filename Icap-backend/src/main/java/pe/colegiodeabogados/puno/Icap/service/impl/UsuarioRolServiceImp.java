package pe.colegiodeabogados.puno.Icap.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.UsuarioRol;
import pe.colegiodeabogados.puno.Icap.repository.IUsuarioRolRepository;
import pe.colegiodeabogados.puno.Icap.service.IUsuarioRolService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioRolServiceImp implements IUsuarioRolService {
    private final IUsuarioRolRepository repo;
    @Override
    public List<UsuarioRol> findOneByUsuarioUser(String user) {
        return repo.findOneByUsuarioUser(user);
    }
    @Override
    public UsuarioRol save(UsuarioRol ur) {
        return repo.save(ur);
    }
}
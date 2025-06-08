package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.model.Acceso;

import java.util.List;

public interface IAccesoService {
    List<Acceso> getAccesoByUser(String username);
}
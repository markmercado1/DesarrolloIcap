package pe.colegiodeabogados.puno.Icap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.colegiodeabogados.puno.Icap.model.VistaAgremiado;

import java.util.List;

public interface IVistaAgremiadoService {
    List<VistaAgremiado> listarAgremiados();
    Page<VistaAgremiado> listarAgremiadosPaginado(Pageable pageable);
}
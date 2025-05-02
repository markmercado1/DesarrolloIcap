package pe.colegiodeabogados.puno.Icap.service.impl;


import pe.colegiodeabogados.puno.Icap.model.Agremiado;
import pe.colegiodeabogados.puno.Icap.repository.IAgremiadoRepository;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.service.IAgremiadoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class AgremiadoServiceImpl extends CrudGenericoServiceImp<Agremiado,Long>implements IAgremiadoService {
    private  final IAgremiadoRepository agremiadoRepository;
    @Override
    protected ICrudGenericRepository<Agremiado, Long> getRepo() {
        return agremiadoRepository;
    }
}

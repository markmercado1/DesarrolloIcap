package pe.colegiodeabogados.puno.Icap.service.impl;

import pe.colegiodeabogados.puno.Icap.model.DetallePago;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IDetallePagoRepository;
import pe.colegiodeabogados.puno.Icap.service.IDetallePagoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Transactional
@Service
@RequiredArgsConstructor
public class DetallePagoServiceImpl extends CrudGenericoServiceImp<DetallePago,Long>
        implements IDetallePagoService {
    private  final IDetallePagoRepository detallePagoRepository;
    @Override
    protected ICrudGenericRepository<DetallePago, Long> getRepo() {
        return detallePagoRepository;
    }
}
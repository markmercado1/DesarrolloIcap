package pe.colegiodeabogados.puno.Icap.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.Pago;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IPagoRepository;
import pe.colegiodeabogados.puno.Icap.service.IPagoService;

@Transactional
@Service
@RequiredArgsConstructor
public class PagoServiceImpl extends CrudGenericoServiceImp<Pago,Long>
        implements IPagoService {
   private final IPagoRepository pagoRepository;
    @Override
    protected ICrudGenericRepository<Pago, Long> getRepo() {
        return pagoRepository;
    }
}

package pe.colegiodeabogados.puno.Icap.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.model.UserAgremiado;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IUserAgremiadoRepository;
import pe.colegiodeabogados.puno.Icap.service.IUserAgremiadoService;

@Transactional
@Service
@RequiredArgsConstructor
public class UserAgremiadoServiceImpl extends CrudGenericoServiceImp<UserAgremiado,Long>
        implements IUserAgremiadoService {
    private final IUserAgremiadoRepository userAgremiadoRepository;
    @Override
    protected ICrudGenericRepository<UserAgremiado, Long> getRepo() {
        return userAgremiadoRepository;
    }
}

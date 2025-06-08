package pe.colegiodeabogados.puno.Icap.service.impl;

import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;
import pe.colegiodeabogados.puno.Icap.exception.ModelNotFoundException;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.service.ICrudGenericService;

import java.time.LocalDateTime;
import java.util.List;

public abstract class CrudGenericoServiceImp<T,ID> implements
        ICrudGenericService<T,ID> {
    protected abstract ICrudGenericRepository<T,ID> getRepo();
    @Override
    public T save(T t) {
        return getRepo().save(t);
    }
    @Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }
    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }
    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
    }
    @Override
    public CustomErrorResponse delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
        CustomErrorResponse cer=new CustomErrorResponse();
        cer.setStatusCode(200);
        cer.setDatetime(LocalDateTime.now());
        cer.setMessage("true");
        cer.setDetails("Todo Ok");
        return cer;
    }
}
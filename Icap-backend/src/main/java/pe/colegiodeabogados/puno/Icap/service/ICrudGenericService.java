package pe.colegiodeabogados.puno.Icap.service;

import pe.colegiodeabogados.puno.Icap.exception.CustomErrorResponse;

import java.util.List;

public interface ICrudGenericService <T,ID>{
     T save(T t);
    T update(ID id, T t);
    List<T> findAll();
    T findById(ID id);
    CustomErrorResponse delete(ID id);
}

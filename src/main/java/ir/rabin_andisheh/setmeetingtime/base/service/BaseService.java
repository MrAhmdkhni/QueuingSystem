package ir.rabin_andisheh.setmeetingtime.base.service;

import ir.rabin_andisheh.setmeetingtime.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    void saveOrUpdate(E e);

    void delete(E e);

    Optional<E> findById(ID id);

    List<E> findAll();
}

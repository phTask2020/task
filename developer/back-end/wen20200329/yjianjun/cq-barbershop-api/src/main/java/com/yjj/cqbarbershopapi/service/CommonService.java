package com.yjj.cqbarbershopapi.service;

import com.yjj.cqbarbershopapi.entity.Vip;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommonService<T> {
    public boolean save(T t);

    public void deleteById(List<Integer> id);

    public T findById(Integer id);

    public Page<Vip> findAll(int page, int size, String username);

    public Vip update(T t);

}

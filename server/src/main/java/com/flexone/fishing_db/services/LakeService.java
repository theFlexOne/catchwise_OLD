package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Lake;

import java.util.List;

public interface LakeService {

    Lake findByName(String name);
    Lake findById(int id);

    Lake save(Lake lake);

    void delete(int id);

    List<Lake> findAll();

}
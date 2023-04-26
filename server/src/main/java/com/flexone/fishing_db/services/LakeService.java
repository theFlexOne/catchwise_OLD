package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Lake;

import java.util.List;

public interface LakeService {

    Lake findByName(String name);
    Lake findById(int id);
    Lake findByLakeId(Long lakeId);

    Lake save(Lake lake);

    List<Lake> saveAll(List<Lake> lakes);

    void delete(int id);

    List<Lake> findAll();

}
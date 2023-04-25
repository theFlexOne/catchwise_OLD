package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Rod;

import java.util.List;

public interface RodService {

    Rod findById(Long id);
    List<Rod> findAll();
    List<Rod> findAllByType(String type);
    List<Rod> findAllByLength(int length);
    List<Rod> findAllByPower(String power);
    List<Rod> findAllByAction(String action);
    List<Rod> findAllByMaterial(String material);
    List<Rod> findAllByHandle(String handle);

    Rod save(Rod rod);
    void deleteById(Long id);
}

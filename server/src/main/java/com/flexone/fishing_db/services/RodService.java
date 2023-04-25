package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Rod;

import java.util.List;

public interface RodService {

    Rod findById(Long id);
    List<Rod> findAll();
    Rod save(Rod rod);
    void delete(Long id);
}

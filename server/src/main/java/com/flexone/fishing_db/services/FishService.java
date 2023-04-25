package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Fish;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FishService {

    Fish findByName(String name);
    Fish findById(int id);
    List<Fish> findAll();

    Fish save(Fish fish);
    void deleteById(int id);
}

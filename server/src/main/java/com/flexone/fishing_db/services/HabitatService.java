package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Habitat;

import java.util.List;

public interface HabitatService {

    Habitat findById(long id);
    Habitat findByName(String name);
    List<Habitat> findAllByType(String type);
    List<Habitat> findAll();

    Habitat save(Habitat habitat);
    void delete(long id);
}

package com.flexone.fishing_db.services.impl;

import com.flexone.fishing_db.domain.Habitat;
import com.flexone.fishing_db.repositories.HabitatRepository;
import com.flexone.fishing_db.services.HabitatService;

import java.util.List;

public class HabitatServiceImpl implements HabitatService {

    final HabitatRepository habitatRepository;

    public HabitatServiceImpl(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    @Override
    public Habitat findById(long id) {
        return habitatRepository.findById(id).orElse(null);
    }

    @Override
    public Habitat findByName(String name) {
        return habitatRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Habitat> findAllByType(String type) {
        return habitatRepository.findAllByType(type);
    }

    @Override
    public List<Habitat> findAll() {
        return (List<Habitat>) habitatRepository.findAll();
    }

    @Override
    public Habitat save(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    @Override
    public void delete(long id) {
        habitatRepository.deleteById(id);
    }
}

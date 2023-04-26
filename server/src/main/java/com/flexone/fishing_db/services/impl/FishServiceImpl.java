package com.flexone.fishing_db.services.impl;

import com.flexone.fishing_db.domain.Fish;
import com.flexone.fishing_db.repositories.FishRepository;
import com.flexone.fishing_db.services.FishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    final FishRepository fishRepository;

    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @Override
    public Fish save(Fish fish) {
        return fishRepository.save(fish);
    }

    @Override
    public List<Fish> saveAll(List<Fish> fish) {
        return (List<Fish>) fishRepository.saveAll(fish);
    }

    @Override
    public Fish findByName(String name) {
        return fishRepository.findByName(name).orElse(null);
    }

    @Override
    public Fish findById(int id) {
        return fishRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fish> findAll() {
        return (List<Fish>) fishRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        fishRepository.deleteById(id);
    }

}

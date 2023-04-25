package com.flexone.fishing_db.services.impl;

import com.flexone.fishing_db.domain.Lake;
import com.flexone.fishing_db.repositories.LakeRepository;
import com.flexone.fishing_db.services.LakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LakeServiceImpl implements LakeService {

    final LakeRepository lakeRepository;

    public LakeServiceImpl(LakeRepository lakeRepository) {
        this.lakeRepository = lakeRepository;
    }

    @Override
    public Lake findByName(String name) {
        return lakeRepository.findByName(name).orElse(null);
    }

    @Override
    public Lake findById(int id) {
        return lakeRepository.findById(id).orElse(null);
    }

    @Override
    public Lake save(Lake lake) {
        return lakeRepository.save(lake);
    }

    @Override
    public void delete(int id) {
        lakeRepository.deleteById(id);
    }

    @Override
    public List<Lake> findAll() {
        return (List<Lake>) lakeRepository.findAll();
    }
}
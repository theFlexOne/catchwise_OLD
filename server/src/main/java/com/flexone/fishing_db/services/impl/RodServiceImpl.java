package com.flexone.fishing_db.services.impl;

import com.flexone.fishing_db.domain.Rod;
import com.flexone.fishing_db.repositories.RodRepository;
import com.flexone.fishing_db.services.RodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RodServiceImpl implements RodService {

    final RodRepository rodRepository;

    public RodServiceImpl(RodRepository rodRepository) {
        this.rodRepository = rodRepository;
    }

    @Override
    public Rod findById(Long id) {
        return rodRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rod> findAll() {
        return (List<Rod>) rodRepository.findAll();
    }

    @Override
    public Rod save(Rod rod) {
        return rodRepository.save(rod);
    }

    @Override
    public void delete(Long id) {
        rodRepository.deleteById(id);
    }
}

package com.flexone.fishing_db.services.impl;

import com.flexone.fishing_db.domain.Bait;
import com.flexone.fishing_db.repositories.BaitRepository;
import com.flexone.fishing_db.services.BaitService;
import org.hibernate.service.spi.InjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaitServiceImpl implements BaitService {

    final BaitRepository baitRepository;

    public BaitServiceImpl(BaitRepository baitRepository) {
        this.baitRepository = baitRepository;
    }

    @Override
    public Bait findById(long id) {
        return baitRepository.findById(id).orElse(null);
    }

    @Override
    public Bait findByName(String name) {
        return baitRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Bait> findAll() {
        return (List<Bait>) baitRepository.findAll();
    }

    @Override
    public List<Bait> findAllByFish(String name) {
        return baitRepository.findAllByFishName(name);
    }

    @Override
    public List<Bait> findAllByFish(Integer id) {
        return baitRepository.findAllByFishId(id);
    }

    @Override
    public Bait save(Bait bait) {
        return baitRepository.save(bait);
    }

    @Override
    public void delete(long id) {
        baitRepository.deleteById(id);
    }
}

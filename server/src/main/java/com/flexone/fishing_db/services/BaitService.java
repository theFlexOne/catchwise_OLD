package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Bait;

import java.util.List;

public interface BaitService {

    Bait findById(long id);
    Bait findByName(String name);
    List<Bait> findAll();
    List<Bait> findAllByFish(String name);
    List<Bait> findAllByFish(Long id);

    Bait save(Bait bait);
    void deleteById(long id);

}

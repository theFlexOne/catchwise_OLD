package com.flexone.fishing_db.services;

import com.flexone.fishing_db.domain.Lake;
import com.flexone.fishing_db.repositories.LakeRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LakeService {

    Lake findByName(String name);
    Lake findById(long id);

    Lake save(Lake lake);

    void deleteById(long id);

    List<Lake> findAll();

}
package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Fish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FishRepository extends CrudRepository<Fish, Integer> {

    Optional<Fish> findByName(String name);

}

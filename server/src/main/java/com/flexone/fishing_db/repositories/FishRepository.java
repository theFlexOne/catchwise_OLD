package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Fish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends CrudRepository<Fish, Integer> {

    Fish findByName(String name);

    Fish findById(long id);

    void deleteById(long id);

}

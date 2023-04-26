package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Lake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LakeRepository extends CrudRepository<Lake, Integer> {

    Optional<Lake> findByLakeId(Long lakeId);
    Optional<Lake> findByName(String name);
}

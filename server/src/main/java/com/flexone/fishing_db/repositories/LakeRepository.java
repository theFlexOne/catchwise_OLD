package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Lake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LakeRepository extends CrudRepository<Lake, Integer> {

    Lake findByName(String name);
    Lake findById(long id);

    void deleteById(long id);
}

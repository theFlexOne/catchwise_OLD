package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Bait;
import com.flexone.fishing_db.domain.Rod;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RodRepository extends CrudRepository<Rod, Long> {
    
}

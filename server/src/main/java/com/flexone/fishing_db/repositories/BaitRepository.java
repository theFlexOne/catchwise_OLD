package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Bait;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaitRepository extends CrudRepository<Bait, Long> {

    Optional<Bait> findByName(String name);

    List<Bait> findAllByFishName(String name);
    List<Bait> findAllByFishId(Integer id);
}

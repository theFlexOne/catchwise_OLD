package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Bait;
import com.flexone.fishing_db.domain.Habitat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {

    Optional<Habitat> findByName(String name);

    List<Habitat> findAllByType(String name);
}

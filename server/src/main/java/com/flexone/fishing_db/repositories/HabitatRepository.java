package com.flexone.fishing_db.repositories;

import com.flexone.fishing_db.domain.Bait;
import com.flexone.fishing_db.domain.Habitat;
import org.springframework.data.repository.CrudRepository;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {
}

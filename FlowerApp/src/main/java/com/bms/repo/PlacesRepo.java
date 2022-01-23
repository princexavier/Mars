package com.bms.repo;

import com.bms.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepo extends JpaRepository<Place,Long> {
}

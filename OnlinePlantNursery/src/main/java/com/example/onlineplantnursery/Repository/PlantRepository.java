package com.example.onlineplantnursery.Repository;

import com.example.onlineplantnursery.Entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Integer> {
    List<Plant> findByTypeOfPlant(String typeOfPlant);
    List<Plant> findByCommonName(String commonName);
    Optional<Plant> findById(Integer plantId);
}

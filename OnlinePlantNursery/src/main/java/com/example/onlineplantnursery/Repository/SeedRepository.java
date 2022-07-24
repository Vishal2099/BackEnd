package com.example.onlineplantnursery.Repository;

import com.example.onlineplantnursery.Entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeedRepository extends JpaRepository<Seed,Long> {
    List<Seed> findByTypeOfSeed(String typeOfSeed);
    List<Seed> findByCommonName(String commonName);
}

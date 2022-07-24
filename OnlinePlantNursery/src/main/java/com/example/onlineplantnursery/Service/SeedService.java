package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Entity.Seed;

import java.util.List;

public interface SeedService {
    Seed addSeed(Seed seed);

    void updateSeed(Long id, Seed seed);

    void deleteSeed(Long seedId);

    Seed viewSeed(Long seedId);

    List<Seed> viewSeed(String commonName);

    List<Seed> viewAllSeeds();

    List<Seed> viewAllSeeds(String typeOfSeed);
}
package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Entity.Seed;
import com.example.onlineplantnursery.Repository.SeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SeedServiceImpl implements SeedService {

    @Autowired
    SeedRepository seedRepository;
    @Override
    public Seed addSeed(Seed seed) {
        seedRepository.save(seed);
        return seed;
    }

    @Override
    public void deleteSeed(Long SeedId) {
        seedRepository.deleteById(SeedId);
    }

    @Override
    public Seed viewSeed(Long seedId) {
        return seedRepository.findById(seedId).get();
    }

    @Override
    public List<Seed> viewSeed(String commonName) {
        return seedRepository.findByCommonName(commonName);
    }

    @Override
    public List<Seed> viewAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public List<Seed> viewAllSeeds(String typeOfSeed) {
        return seedRepository.findByTypeOfSeed(typeOfSeed);
    }

    @Transactional
    public void updateSeed(Long id, Seed seed) {
        Optional<Seed> seed1=seedRepository.findById(id);
        if(seed1.isPresent()) {
            seed1.get().setCommonName(seed.getCommonName());
            seed1.get().setBloomTime(seed.getBloomTime());
            seed1.get().setDifficultyLevel(seed.getDifficultyLevel());
            seed1.get().setTemperature(seed.getTemperature());
            seed1.get().setTypeOfSeed(seed.getTypeOfSeed());
            seed1.get().setSeedDescription(seed.getSeedDescription());
            seed1.get().setSeedsStock(seed.getSeedsStock());
            seed1.get().setSeedCost(seed.getSeedCost());
        }
        else throw new IllegalStateException("Seed: "+id+ " doesnt exists!");
    }
}
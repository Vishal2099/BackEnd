package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Repository.PlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService{

    @Autowired
    PlantRepository plantRepository;

    @Override
    public Plant addPlant(Plant plant) {
        plantRepository.save(plant);
        return plant;
    }



    @Override
    public void deletePlant(Integer plantId) {
        plantRepository.deleteById(plantId);
    }

    @Override
    public Plant viewPlant(Integer plantId) {
        return plantRepository.findById(plantId).get();
    }

    @Override
    public List<Plant> viewPlant(String commonName) {
        return plantRepository.findByCommonName(commonName);
    }

    @Override
    public List<Plant> viewAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public List<Plant> viewAllPlants(String typeOfPlant) {
        return plantRepository.findByTypeOfPlant(typeOfPlant);
    }

    @Override
    public List<Plant> viewPlantDetails(Integer plantId, String plantName) {
        return null;
    }

//    @Override
//    public List<Plant> viewAllTests() {
//        return plantRepository.findAll();
//    }


    @Transactional
    public void updatePlant(Integer id,Plant plant) {
            Optional<Plant> plant1=plantRepository.findById(id);
            if(plant1.isPresent()) {
                plant1.get().setPlantHeight(plant.getPlantHeight());
                plant1.get().setPlantSpread(plant.getPlantSpread());
                plant1.get().setCommonName(plant.getCommonName());
                plant1.get().setBloomTime(plant.getBloomTime());
                plant1.get().setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
                plant1.get().setDifficultyLevel(plant.getDifficultyLevel());
                plant1.get().setTemperature(plant.getTemperature());
                plant1.get().setTypeOfPlant(plant.getTypeOfPlant());
                plant1.get().setPlantDescription(plant.getPlantDescription());
                plant1.get().setPlantsStock(plant.getPlantsStock());
                plant1.get().setPlantCost(plant.getPlantCost());
            }
            else throw new IllegalStateException("Plant: "+id+ " doesnt exists!");
        }

}

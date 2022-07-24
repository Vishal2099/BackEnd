package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Plant;

import java.util.List;

public interface PlantService {
    Plant addPlant(Plant plant);

    void updatePlant(Integer id, Plant plant);

    void deletePlant(Integer plantId);

    Plant viewPlant(Integer plantId);

    List<Plant> viewPlant(String commonName);

    List<Plant> viewAllPlants();

    List<Plant> viewAllPlants(String typeOfPlant);


    public List<Plant> viewPlantDetails(Integer plantId,String plantName);
}

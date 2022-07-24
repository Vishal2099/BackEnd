package com.example.onlineplantnursery.Controller;
import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Repository.PlanterRepository;
import com.example.onlineplantnursery.Service.PlantService;
import com.example.onlineplantnursery.Service.PlantServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/plant")
@CrossOrigin("http://localhost:3000")
public class PlantController {
    @Autowired
    private PlantServiceImpl plantServiceimpl;
    @Autowired
    private PlantService plantService;

    @PostMapping("/add")
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant){
        Plant plant1 =plantServiceimpl.addPlant(plant);
        log.info("Added a new Plant ");
        log.info(String.valueOf(plant1));
        return new ResponseEntity<>(plant1, HttpStatus.CREATED);
    }
    @GetMapping("/view")
    public ResponseEntity<Plant> viewPlant(@RequestParam Integer plantId){
        Plant plant = plantServiceimpl.viewPlant(plantId);
        return new ResponseEntity<>(plant,HttpStatus.ACCEPTED);
    }
    @GetMapping("/viewall")
    public List<Plant> viewAllPlants(){
        return plantServiceimpl.viewAllPlants();
    }
    @PutMapping("/update")
    public void modifyplant(@RequestParam(value="id")Integer id1, @RequestBody Plant plant) {
        plantServiceimpl.updatePlant(id1,plant);}
    @DeleteMapping("/delete/{plantId}")
    public void removePlant(@PathVariable Integer plantId){
        plantServiceimpl.deletePlant(plantId);
    }
    @GetMapping("/viewByCommonName")
    public List<Plant> ViewByCommonName(@RequestParam String commonName){
        return plantServiceimpl.viewPlant(commonName);
    }
    @GetMapping("/viewByTypeOfPlant")
    public List<Plant> ViewByTypeOfPlant(@RequestParam String typeOfPlant){
        return plantServiceimpl.viewAllPlants(typeOfPlant);
    }

//    @ApiOperation("view all the plant")
//    @GetMapping("/viewalltest")
//    public List<Plant> viewAllTests(){
//        log.info("View all tests");
//        return plantService.viewAllTests();
//    }
}

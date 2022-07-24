package com.example.onlineplantnursery.Controller;

import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Entity.Planter;
import com.example.onlineplantnursery.Repository.PlantRepository;
import com.example.onlineplantnursery.Service.PlanterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planter")
@CrossOrigin("http://localhost:3000")
public class PlanterController {

    @Autowired
    PlanterService planterService;
    @Autowired
    PlantRepository plantRepository;


    @PostMapping(path = "/add")
    public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter){
        return new ResponseEntity<>(planterService.addPlanter(planter), HttpStatus.CREATED);
    }

    @GetMapping("/viewall")
    public List<Planter> getAllPlanter(){
        return planterService.getAllPlanter();
    }

    @GetMapping("/viewPlanter")
    public ResponseEntity<Planter> getPlanterDetails(@RequestParam(value="planterId") Integer id){
        return ResponseEntity.ok().body(planterService.getPlanter(id));
    }

    @DeleteMapping("/delete")
    public void deletePlanter(@RequestParam Integer id){
        planterService.removePlanter(id);
    }

    @PutMapping(path = "/update")
    public void modifyplanter(@RequestParam(value = "PlanterId") Integer id1, @RequestBody Planter planter){
        planterService.updatePlanter(id1,planter);
    }

//    @GetMapping("/viewtest/{plantId}/{plantName}")
//    public ResponseEntity<Plant> viewPlantDetails(@PathVariable Integer plantId, @PathVariable String plantName)
//    {
//        return ResponseEntity.ok(this.planterService.viewPlantDetails(plantId,plantName));
//    }
    @PostMapping("/addPlant")
    public ResponseEntity<Plant> addPlant(@RequestParam Integer planterId, @RequestParam Integer plantId)
    {
        return ResponseEntity.ok(this.planterService.addPlant(planterId,plantId));
    }
}
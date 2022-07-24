package com.example.onlineplantnursery.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="plantrecord")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer plantId;
    private Integer plantHeight;
    private String plantSpread;
    private String commonName;
    private String bloomTime;
    private String medicinalOrCulinaryUse;
    private String difficultyLevel;
    private String temperature;
    private String typeOfPlant;
    private String plantDescription;
    private Integer plantsStock;
    private double plantCost;
    @OneToMany(targetEntity = Planter.class,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "plant_id",
            referencedColumnName = "plantId"
    )
    @JsonIgnore
    private Set<Planter> plants;
}

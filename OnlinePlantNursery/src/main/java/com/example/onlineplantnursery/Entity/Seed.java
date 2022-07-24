package com.example.onlineplantnursery.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="seedrecord")
public class Seed {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long seedId;
        private String commonName;
        private String bloomTime;
        private String watering;
        private String difficultyLevel;
        private String temperature;
        private String typeOfSeed;
        private String seedDescription;
        private Integer seedsStock;
        private double seedCost;
}

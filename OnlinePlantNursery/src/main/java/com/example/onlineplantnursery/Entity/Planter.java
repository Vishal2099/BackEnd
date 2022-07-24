package com.example.onlineplantnursery.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planter {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer planterId;
        private Float planterHeight;
        private Integer planterCapacity;
        private Integer drainageHoles;
        private Integer planterColor;
        private String planterShaper;
        private Integer planterStock;
        private Integer planterCost;

//        @OneToMany(targetEntity=Order.class,cascade = CascadeType.ALL)
//        @JoinColumn(
//                name = "plant_id",
//                referencedColumnName = "planterId"
//        )
//        @JsonIgnore
//        private Set<Order> orders;
        @OneToMany(targetEntity=Plant.class,cascade = CascadeType.ALL)
        @JoinColumn(
                name = "planter_id",
                referencedColumnName = "planterId"
        )
        @JsonIgnore
        private List<Plant> plants;
//        @OneToMany(cascade = CascadeType.ALL)
//        @JoinColumn(
//                name = "",
//                referencedColumnName = "planterId"
//        )
//        @JsonIgnore
//        private List<Seed> seeds;


}

package com.example.onlineplantnursery.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orderrecord")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingOrderId;
    private LocalDate orderDate=LocalDate.now();
    private String transactionMode;
    private int quantity;
    private double totalCost;
    @OneToMany(targetEntity=Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "booking_id",
            referencedColumnName = "bookingOrderId"
    )
    private Set<Customer> customers;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "booking_id",
            referencedColumnName = "bookingOrderId"
    )
    @JsonIgnore
    private Set<Planter> planters;
}
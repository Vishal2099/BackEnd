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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String username;
    private String password;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "customer_id",
//            referencedColumnName = "customerId"
//    )
//    private List<Address> address;
    @OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "cust_id",
            referencedColumnName = "customerId"
    )
    @JsonIgnore
    private Set<Order> orders;


}

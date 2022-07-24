package com.example.onlineplantnursery.Repository;

import com.example.onlineplantnursery.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {



}

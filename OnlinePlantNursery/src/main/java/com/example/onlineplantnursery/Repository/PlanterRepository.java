package com.example.onlineplantnursery.Repository;

import com.example.onlineplantnursery.Entity.Planter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanterRepository extends JpaRepository<Planter, Integer> {
//    Optional<T> findById(ID planterId);

    Optional<Planter> findById(Integer planterId);
//    Planter findBy
}

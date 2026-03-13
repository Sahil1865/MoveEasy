package com.example.sahil.MoveEasy.repository;

import com.example.sahil.MoveEasy.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride,Long> {
}

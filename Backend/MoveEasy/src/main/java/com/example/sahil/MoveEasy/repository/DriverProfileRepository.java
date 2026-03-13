package com.example.sahil.MoveEasy.repository;

import com.example.sahil.MoveEasy.model.DriverProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverProfileRepository extends JpaRepository<DriverProfile,Long> {
}

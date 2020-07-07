package com.demo.repository;

import com.demo.entities.Farms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmsRepository extends JpaRepository<Farms, Long> {
}

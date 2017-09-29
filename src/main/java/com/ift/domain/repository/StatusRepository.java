package com.ift.domain.repository;


import com.ift.domain.SatellitePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<SatellitePosition, String> {
}

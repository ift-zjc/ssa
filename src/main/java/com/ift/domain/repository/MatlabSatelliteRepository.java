package com.ift.domain.repository;

import com.ift.domain.MatlabSatellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatlabSatelliteRepository extends JpaRepository<MatlabSatellite, String> {
}

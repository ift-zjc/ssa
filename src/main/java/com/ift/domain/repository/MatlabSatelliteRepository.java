package com.ift.domain.repository;

import com.ift.domain.MatlabSatellite;
import com.sun.istack.internal.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatlabSatelliteRepository extends JpaRepository<MatlabSatellite, String> {

    // Get satellite based on satellite_id;
    @Nullable
    MatlabSatellite findBySatelliteId(String satelliteId);
}

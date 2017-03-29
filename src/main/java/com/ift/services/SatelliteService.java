package com.ift.services;

import com.ift.domain.Satellite;
import com.ift.domain.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Service
public class SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;

    public Satellite saveSatellite(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    public List<Satellite> listSatellites() {
        return satelliteRepository.findAll();
    }
}

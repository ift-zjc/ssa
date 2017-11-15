package com.ift.services;

import com.ift.domain.MatlabSatellite;
import com.ift.domain.repository.MatlabSatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatelabSatelliteService {

    @Autowired
    private MatlabSatelliteRepository matlabSatelliteRepository;

    public MatlabSatellite saveMatlabSatellite(MatlabSatellite matlabSatellite) { return matlabSatelliteRepository.save(matlabSatellite); }

    public List<MatlabSatellite> listMatlabSatellites() { return matlabSatelliteRepository.findAll(); }

    public MatlabSatellite findBySatelliteId (String satelliteId){
        return matlabSatelliteRepository.findBySatelliteId(satelliteId);
    }

}

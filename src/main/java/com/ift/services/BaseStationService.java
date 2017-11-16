package com.ift.services;

import com.ift.domain.BaseStation;
import com.ift.domain.repository.BaseStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseStationService {

    @Autowired
    private BaseStationRepository baseStationRepository;

    public BaseStation saveBaseStation (BaseStation baseStation) { return baseStationRepository.save(baseStation); }

    public List<BaseStation> listBaseStation() { return baseStationRepository.findAll(); }

    public BaseStation findByBaseId (String bsid){
        return baseStationRepository.findByBsid(bsid);
    }
}

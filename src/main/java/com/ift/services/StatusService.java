package com.ift.services;


import com.ift.domain.SatellitePosition;
import com.ift.domain.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public SatellitePosition saveStatus (SatellitePosition status) {
        return statusRepository.save(status);
    }

    public List<SatellitePosition> listStatus() {
        return statusRepository.findAll();
    }
}

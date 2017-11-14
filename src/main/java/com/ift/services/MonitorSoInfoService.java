package com.ift.services;

import com.ift.domain.MonitorSoInfo;
import com.ift.domain.repository.MonitorSoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorSoInfoService {

    @Autowired
    private MonitorSoInfoRepository monitorSoInfoRepository;

    public MonitorSoInfo saveStatus (MonitorSoInfo status) { return monitorSoInfoRepository.save(status); }

    public List<MonitorSoInfo> listStatus() { return monitorSoInfoRepository.findAll(); }
}

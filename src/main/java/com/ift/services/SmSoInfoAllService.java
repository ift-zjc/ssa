package com.ift.services;

import com.ift.domain.SmSoInfoAll;
import com.ift.domain.repository.SmSoInfoAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmSoInfoAllService {

    @Autowired
    private SmSoInfoAllRepository smSoInfoAllRepository;

    public SmSoInfoAll saveStatus (SmSoInfoAll status) { return smSoInfoAllRepository.save(status); }

    public List<SmSoInfoAll> listStatus() { return smSoInfoAllRepository.findAll(); }

}

package com.ift.services;

import com.ift.domain.Status;
import com.ift.domain.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status saveStatus (Status status) {
        return statusRepository.save(status);
    }

    public List<Status> listStatus() {
        return statusRepository.findAll();
    }
}

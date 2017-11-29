package com.ift.services;

import com.ift.domain.Collision;
import com.ift.domain.repository.CollisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollisionService {
    @Autowired
    private CollisionRepository collisionRepository;
    public Collision saveCollision(Collision collision) {return collisionRepository.save(collision); }
    public List<Collision> ListCollision() { return collisionRepository.findAll(); }
}

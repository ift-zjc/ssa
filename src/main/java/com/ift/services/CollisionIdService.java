package com.ift.services;

import com.ift.domain.CollisionId;
import com.ift.domain.repository.CollisionIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollisionIdService {

    @Autowired
    private CollisionIdRepository collisionIdRepository;

    public CollisionId saveCollisionId (CollisionId collisionId) { return collisionIdRepository.save(collisionId); }

    public List<CollisionId> listCollisionId() { return collisionIdRepository.findAll(); }

    public CollisionId findByCollisionId (String collisionId) {
        return collisionIdRepository.findByCollisionId(collisionId);
    }

//    public CollisionId findByCollisionId2 (String collisionId2) {
//        return collisionIdRepository.findByCollisionId2(collisionId2);
//    }

}

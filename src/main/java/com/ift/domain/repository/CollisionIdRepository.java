package com.ift.domain.repository;

import com.ift.domain.BaseStation;
import com.ift.domain.CollisionId;
import com.sun.istack.internal.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollisionIdRepository extends JpaRepository<CollisionId, String>{

    //
    @Nullable
    CollisionId findByCollisionId(String collisionId);
}

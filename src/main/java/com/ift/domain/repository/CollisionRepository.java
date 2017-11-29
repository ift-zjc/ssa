package com.ift.domain.repository;

import com.ift.domain.Collision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollisionRepository extends JpaRepository<Collision, String> {
}

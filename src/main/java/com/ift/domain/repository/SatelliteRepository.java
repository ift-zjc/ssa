package com.ift.domain.repository;

import com.ift.domain.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, String> {
}

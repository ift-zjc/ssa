package com.ift.domain.repository;

import com.ift.domain.MonitorSoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorSoInfoRepository extends JpaRepository<MonitorSoInfo, String> {
}

package com.ift.domain.repository;


import com.ift.domain.BaseStation;
import com.sun.istack.internal.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseStationRepository extends JpaRepository<BaseStation, String> {

    // get satellite based on bs_id
    @Nullable
    BaseStation findByBsid(String bsid);
}

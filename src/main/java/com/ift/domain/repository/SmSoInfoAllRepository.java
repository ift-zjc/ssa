package com.ift.domain.repository;


import com.ift.domain.SmSoInfoAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmSoInfoAllRepository extends JpaRepository<SmSoInfoAll, String> {
}

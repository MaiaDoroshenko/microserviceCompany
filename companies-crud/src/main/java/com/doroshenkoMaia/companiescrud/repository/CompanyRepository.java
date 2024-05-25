package com.doroshenkoMaia.companiescrud.repository;

import com.doroshenkoMaia.companiescrud.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
    Optional<CompanyEntity>findByName(String name);
}

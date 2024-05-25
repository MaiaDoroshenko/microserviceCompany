package com.doroshenkoMaia.companiescrud.repository;

import com.doroshenkoMaia.companiescrud.entity.WebSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSiteEntity,Long> {
}

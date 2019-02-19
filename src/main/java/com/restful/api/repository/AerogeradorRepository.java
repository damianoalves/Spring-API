package com.restful.api.repository;

import com.restful.api.model.Aerogerador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerogeradorRepository extends JpaRepository<Aerogerador, Long> {
}

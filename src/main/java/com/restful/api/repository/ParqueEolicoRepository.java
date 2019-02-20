package com.restful.api.repository;

import com.restful.api.model.ParqueEolico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueEolicoRepository extends JpaRepository<ParqueEolico, Long>, JpaSpecificationExecutor<ParqueEolico> {
}

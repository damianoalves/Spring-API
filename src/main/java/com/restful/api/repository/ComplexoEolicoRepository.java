package com.restful.api.repository;

import com.restful.api.model.ComplexoEolico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexoEolicoRepository extends JpaRepository<ComplexoEolico, Long> {

}

package com.restful.api.repository;

import com.restful.api.model.ComplexoEolico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

@Repository
public interface ComplexoEolicoRepository extends JpaRepository<ComplexoEolico, Long>, JpaSpecificationExecutor<ComplexoEolico> {

}

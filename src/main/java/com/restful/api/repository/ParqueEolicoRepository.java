package com.restful.api.repository;

import com.restful.api.model.ParqueEolico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

@Repository
public interface ParqueEolicoRepository extends JpaRepository<ParqueEolico, Long>, CrudRepository<ParqueEolico, Long> {

    @Query(value = "SELECT * FROM api.parque_eolico WHERE complexo_eolico_id = ?1", nativeQuery = true)
    List<ParqueEolico> findByComplexoEolicoId(@Param("complexoEolicoId")Long complexoEolicoId);
}

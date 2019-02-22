package com.restful.api.repository;

import com.restful.api.model.Aerogerador;
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
public interface AerogeradorRepository extends JpaRepository<Aerogerador, Long>, CrudRepository<Aerogerador, Long> {

    @Query(value = "SELECT * FROM api.aerogerador WHERE parque_eolico_id = ?1", nativeQuery = true)
    List<Aerogerador> findByParqueEolicoId(@Param("parqueEolicoId")Long parqueEolicoId);
}

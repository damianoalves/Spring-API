package com.restful.api.repository;

import com.restful.api.model.ComplexoEolico;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ComplexoEolicoRepository implements JpaRepository<ComplexoEolico, Long> {

    @Override
    public List<ComplexoEolico> findAll() {
        return null;
    }

    @Override
    public List<ComplexoEolico> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ComplexoEolico> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ComplexoEolico> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ComplexoEolico complexoEolico) {

    }

    @Override
    public void deleteAll(Iterable<? extends ComplexoEolico> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ComplexoEolico> S save(S s) {
        return null;
    }

    @Override
    public <S extends ComplexoEolico> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ComplexoEolico> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ComplexoEolico> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ComplexoEolico> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ComplexoEolico getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends ComplexoEolico> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ComplexoEolico> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ComplexoEolico> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ComplexoEolico> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ComplexoEolico> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ComplexoEolico> boolean exists(Example<S> example) {
        return false;
    }
}

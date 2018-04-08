package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Religion;

@Repository
public interface ReligionRepository extends CrudRepository<Religion, Long> {

}

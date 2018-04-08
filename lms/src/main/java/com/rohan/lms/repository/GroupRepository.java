package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

}

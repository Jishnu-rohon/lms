package com.rohan.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Module;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {
	public List<Module> findAll();
}

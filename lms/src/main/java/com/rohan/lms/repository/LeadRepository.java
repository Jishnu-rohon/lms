package com.rohan.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Lead;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Long> {

	@Query("select l from Lead l where is_deleted=0 and created_by_user_slno=:user_slno")
	List<Lead> findAll(@Param("user_slno") int user_slno);

}

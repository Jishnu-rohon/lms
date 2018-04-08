package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>,UserRepositoryCustom {

	User findBySlno(Long slno);

	boolean existsByLoginId(String loginId);
	
	User findByLoginId(String loginId);

}

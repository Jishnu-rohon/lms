package com.rohan.lms.repositoryImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rohan.lms.model.User;
import com.rohan.lms.repository.UserRepositoryCustom;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int getGroupBySlno(Long slno) {
		Session session = sessionFactory.getCurrentSession();
		
		User u = session.get(User.class, slno);
		if(u.getGrpSlno()==0)
			return 0;
		else
			return u.getGrpSlno();
	}

}

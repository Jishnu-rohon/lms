package com.rohan.lms.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rohan.lms.join.Menu;

public interface MenuRepository {
	
	public List<Menu> getMenu(int user_slno);
	
}

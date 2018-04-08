package com.rohan.lms.join;

import java.util.List;

import com.rohan.lms.model.User;

public class UserMenu {
	User user;
	List<Menu> menu;
	
	public UserMenu() {
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "UserMenu [user=" + user + ", menu=" + menu + "]";
	}

	public UserMenu(User user, List<Menu> menu) {
		super();
		this.user = user;
		this.menu = menu;
	}

}

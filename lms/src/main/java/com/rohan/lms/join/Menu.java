package com.rohan.lms.join;

import java.util.List;

public class Menu {
	//Module
	private String name;
	private String url;
	private int parent_slno;
	
	//GroupModuleAccess
	private int grp_slno;
	
	
	private int mod_slno;
	private int is_all;
	private int is_view;
	private int is_add;
	private int is_edit;
	private int is_delete;
	private int is_none;
	
	private List<Menu> submenu;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParent_slno() {
		return parent_slno;
	}

	public void setParent_slno(int parent_slno) {
		this.parent_slno = parent_slno;
	}

	public int getGrp_slno() {
		return grp_slno;
	}

	public void setGrp_slno(int grp_slno) {
		this.grp_slno = grp_slno;
	}

	public int getMod_slno() {
		return mod_slno;
	}

	public void setMod_slno(int mod_slno) {
		this.mod_slno = mod_slno;
	}

	public int getIs_all() {
		return is_all;
	}

	public void setIs_all(int is_all) {
		this.is_all = is_all;
	}

	public int getIs_view() {
		return is_view;
	}

	public void setIs_view(int is_view) {
		this.is_view = is_view;
	}

	public int getIs_add() {
		return is_add;
	}

	public void setIs_add(int is_add) {
		this.is_add = is_add;
	}

	public int getIs_edit() {
		return is_edit;
	}

	public void setIs_edit(int is_edit) {
		this.is_edit = is_edit;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public int getIs_none() {
		return is_none;
	}

	public void setIs_none(int is_none) {
		this.is_none = is_none;
	}

	public List<Menu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<Menu> submenu) {
		this.submenu = submenu;
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", url=" + url + ", parent_slno=" + parent_slno + ", grp_slno=" + grp_slno
				+ ", mod_slno=" + mod_slno + ", is_all=" + is_all + ", is_view=" + is_view + ", is_add=" + is_add
				+ ", is_edit=" + is_edit + ", is_delete=" + is_delete + ", is_none=" + is_none + ", submenu=" + submenu
				+ "]";
	}

	public Menu(String name, String url, int parent_slno, int grp_slno, int mod_slno, int is_all, int is_view,
			int is_add, int is_edit, int is_delete, int is_none, List<Menu> submenu) {
		super();
		this.name = name;
		this.url = url;
		this.parent_slno = parent_slno;
		this.grp_slno = grp_slno;
		this.mod_slno = mod_slno;
		this.is_all = is_all;
		this.is_view = is_view;
		this.is_add = is_add;
		this.is_edit = is_edit;
		this.is_delete = is_delete;
		this.is_none = is_none;
		this.submenu = submenu;
	}

}

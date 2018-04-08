package com.rohan.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.join.Menu;
import com.rohan.lms.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository mr;
	
	List<Menu> all = new ArrayList<>();
	
	public List<Menu> getMenu(int user_slno) {
		all = mr.getMenu(user_slno);
		return (genMod(new Menu("root","/root",-1,1,0,1,1,1,1,1,0,null))).getSubmenu();
	}
	
	private Menu genMod(Menu m)
	{
		
		Menu genM = null;
		for (Menu menu : all) {
			
			List<Menu> ch = getMenuChildren(m.getMod_slno());
			if(ch.size()>0)
			{
				m.setSubmenu(ch);
				for (Menu menu2 : ch) {
					genMod(menu2);
				}
			}
		}
		//genM.add(m);
		genM = m;
		//System.out.println("GenM = "+genM);
		return genM;
	}
	
	private List<Menu> getMenuChildren(int id)
	{
		//List<Menu> all = getMods();
		List<Menu> children = new ArrayList<>();
		for (Menu mod : all) {
			if(mod.getParent_slno()==id)
			{
				children.add(mod);
			}
		}
		return children;
	}
}

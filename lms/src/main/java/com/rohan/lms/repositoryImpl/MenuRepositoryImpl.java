package com.rohan.lms.repositoryImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.Module;
import com.rohan.lms.join.Menu;
import com.rohan.lms.repository.MenuRepository;
import com.rohan.lms.service.UserService;

@Repository
@Transactional
public class MenuRepositoryImpl implements MenuRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserService us;
	
	@Override
	public List<Menu> getMenu(int user_slno) {
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("User grp = "+us.getGroupByUserSlno((long)user_slno));
		
		int grp = us.getGroupByUserSlno((long)user_slno);
		String querystr = "";
		if(grp==0)
		{
		querystr = "select "
				+ " mm.name as name,mm.url as url,mm.parent_slno as parent_slno, "
				+ " muma.mod_slno as mod_slno , muma.is_all as is_all, muma.is_view as is_view, muma.is_add as is_add,"
				+ " muma.is_edit as is_edit, muma.is_delete as is_delete, muma.is_none as is_none "
				+ " from "
				+ " m_module mm "
				+ " left join m_user_module_access muma on mm.slno = muma.mod_slno"
				+ " where muma.usr_slno = :usr_slno and muma.is_none=0";
		}
		else
		{
			querystr = "select "
					+ " mm.name as name,mm.url as url,mm.parent_slno as parent_slno, "
					+ " muma.mod_slno as mod_slno , muma.is_all as is_all, muma.is_view as is_view, muma.is_add as is_add,"
					+ " muma.is_edit as is_edit, muma.is_delete as is_delete, muma.is_none as is_none "
					+ " from "
					+ " m_module mm "
					+ " left join m_group_module_access muma on mm.slno = muma.mod_slno"
					+ " where muma.grp_slno = :grp_slno and muma.is_none=0";
		}
		SQLQuery query = session.createSQLQuery(querystr);
		if(grp==0)
		{
			query.setParameter("usr_slno", user_slno);
		}
		else
		{
			query.setParameter("grp_slno", grp);
		}
		
		query.setResultTransformer(Transformers.aliasToBean(Menu.class));
		
		return query.list();
	}

}

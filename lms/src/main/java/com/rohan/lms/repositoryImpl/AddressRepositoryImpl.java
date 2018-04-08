package com.rohan.lms.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Address;
import com.rohan.lms.repository.AddressRepositoryCustom;

@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Address> getAll() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.getTransaction().commit();
		List<Address> addresses = new ArrayList<Address>();
		SQLQuery query = null;
		
		String sql = "select  obj.slno as slno, obj.client_slno as clientSlno, obj.address_type_slno as addressTypeSlno, obj.street as street, "
				+ " obj.city_slno as citySlno, cty.city_name as cityName, "
				+ " obj.state_slno as stateSlno, s.state_name as stateName, obj.country_slno as countrySlno, c.country_name as countryName, "
				+ " obj.pin_slno as pinSlno, obj.approve_stat as approveStat, obj.company_slno as companySlno, obj.created_date as createdDate, "
				+ " obj.dt_action as dtAction, obj.is_deleted as isDeleted "
				+ " from  m_address obj "
				+ " left join m_state s on s.slno=obj.state_slno "
				+ " left join  m_country c on c.slno=obj.country_slno"
				+ " left join  m_city cty on cty.slno=obj.city_slno";
		
		try {
			query = session.createSQLQuery(sql);
			
			query.setResultTransformer(Transformers.aliasToBean(Address.class));
			
			addresses = query.list();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen())
				session.close();
		}
		return addresses;
	}

}

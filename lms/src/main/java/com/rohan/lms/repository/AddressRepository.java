package com.rohan.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>, AddressRepositoryCustom {
	
	//@Query(value="select obj.slno,obj.client_slno,obj.address_type_slno from  m_address obj where obj.slno=:slno", nativeQuery=true)
	public Address findOneBySlno(@Param(value = "slno") int slno);
	
	@Query(value="select  obj.slno, obj.client_slno, obj.address_type_slno, obj.street, obj.city_slno, obj.state_slno, s.state_name, obj.country_slno, c.country_name, obj.pin_slno, obj.approve_stat, obj.company_slno, obj.created_date, obj.dt_action, obj.is_deleted from  m_address obj  left join  m_state s on s.slno=obj.state_slno left join  m_country c on c.slno=obj.country_slno", nativeQuery=true)
	public List<Address> findAll();
	
}

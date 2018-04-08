package com.rohan.lms.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rohan.lms.model.Client;
import com.rohan.lms.repository.ClientRepositoryCustom;
import com.rohan.lms.utility.ResponseStatus;

@Repository
@Transactional
public class ClientRepositoryImpl implements ClientRepositoryCustom {

	@Autowired
	private SessionFactory sessionFactory;
	
//	private final Logger logger = LoggerFactory.getLogger(ClientRepositoryImpl.getClass());
	
	@Override
	public ResponseStatus addClient(Client client) {
		ResponseStatus rs = new ResponseStatus();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		try {
			session.saveOrUpdate(client);
			//session.save(client.getKycs());
			session.getTransaction().commit();
			
			rs.setMessage("Client Inserted Successfully");
			rs.setStatus(1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			
			rs.setMessage("Client Insert Unsuccessful");
			rs.setStatus(0);
			
		} finally {
			if(session.isOpen())
				session.close();
		}
		return rs;
	}
	
	@Override
	public ResponseStatus updateClient(Client client) {
		ResponseStatus rs = new ResponseStatus();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Client updClient = new Client();
		try {
			/*updClient = session.get(Client.class,client.getSlno());
			updClient.setAddresses(client.getAddresses());*/
			
			//session.update(updClient);
			
			client.getAddresses();
			client.getKycs();
			client.getClientProfessions();
			
			
			session.merge(client);
			
			session.getTransaction().commit();
			
			rs.setMessage("Client Updated Successfully");
			rs.setStatus(1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			rs.setMessage("Client Update UnSuccessful");
			rs.setStatus(0);
		} finally {
			if(session.isOpen())
				session.close();
		}
		return rs;
	}

	@Override
	public List<Client> getAll(int slno) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Client> clients = new ArrayList<Client>();
		Query query = null;
		String qstr = "select obj from Client obj "
				+ " where obj.is_deleted=:is_deleted and obj.created_by_user_slno=:created_by_user_slno "
				+ " order by obj.slno desc";
		try {
			query = session.createQuery(qstr);
			query.setParameter("is_deleted", 0);
			query.setParameter("created_by_user_slno", slno);
			
			clients = query.list();
			for (int i = 0; i < clients.size(); i++) {
				Hibernate.initialize(clients.get(i).getAddresses());
				Hibernate.initialize(clients.get(i).getKycs());
				Hibernate.initialize(clients.get(i).getClientProfessions());
			}
			/*for (int i = 0; i < clients.size(); i++) {
				System.out.println(clients.get(i).getAddresses());
				System.out.println(clients.get(i).getKycs());
				System.out.println(clients.get(i).getClientProfessions());
			}*/
			/*for (Client client : clients) {
				Hibernate.initialize(client.getAddresses());
				Hibernate.initialize(client.getKycs());
				Hibernate.initialize(client.getClientProfessions());
				
			}*/
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen())
				session.close();
		}
		
		return clients;
	}

	@Override
	public ResponseStatus deleteClient(Integer slno) {
		System.out.println("deleteClient slno = "+slno);
		ResponseStatus rs = new ResponseStatus();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		try {
			
			Client client = (Client)session.get(Client.class, slno);
			client.setIs_deleted(1);
			/*client.getAddresses();
			client.getKycs();
			client.getClientProfessions();*/
			
			
			session.update(client);
			
			session.getTransaction().commit();
			
			rs.setMessage("Client Deleted Successfully");
			rs.setStatus(1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			rs.setMessage("Client Delete UnSuccessful");
			rs.setStatus(0);
		} finally {
			if(session.isOpen())
				session.close();
		}
		return rs;
	}

	@Override
	public List<Client> getAllDeleted(int user_slno) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Client> clients = new ArrayList<Client>();
		Query query = null;
		String qstr = "select obj from Client obj "
				+ " where obj.is_deleted=:is_deleted and obj.created_by_user_slno=:created_by_user_slno "
				+ " order by obj.slno desc";
		try {
			query = session.createQuery(qstr);
			query.setParameter("is_deleted", 1);
			query.setParameter("created_by_user_slno", user_slno);
			
			clients = query.list();
			for (int i = 0; i < clients.size(); i++) {
				Hibernate.initialize(clients.get(i).getAddresses());
				Hibernate.initialize(clients.get(i).getKycs());
				Hibernate.initialize(clients.get(i).getClientProfessions());
			}
			/*for (int i = 0; i < clients.size(); i++) {
				System.out.println(clients.get(i).getAddresses());
				System.out.println(clients.get(i).getKycs());
				System.out.println(clients.get(i).getClientProfessions());
			}*/
			/*for (Client client : clients) {
				Hibernate.initialize(client.getAddresses());
				Hibernate.initialize(client.getKycs());
				Hibernate.initialize(client.getClientProfessions());
				
			}*/
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen())
				session.close();
		}
		
		return clients;
	}

	@Override
	public ResponseStatus restoreClient(Integer slno) {
		System.out.println("restoreClient slno = "+slno);
		ResponseStatus rs = new ResponseStatus();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		try {
			
			Client client = (Client)session.get(Client.class, slno);
			client.setIs_deleted(0);
			/*client.getAddresses();
			client.getKycs();
			client.getClientProfessions();*/
			
			
			session.update(client);
			
			session.getTransaction().commit();
			
			rs.setMessage("Client Restored Successfully");
			rs.setStatus(1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			rs.setMessage("Client Restore UnSuccessful");
			rs.setStatus(0);
		} finally {
			if(session.isOpen())
				session.close();
		}
		return rs;
	}

}

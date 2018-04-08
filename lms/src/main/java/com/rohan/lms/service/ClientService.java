package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rohan.lms.model.Client;
import com.rohan.lms.repository.ClientRepository;
import com.rohan.lms.utility.ResponseStatus;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository cr;
	
	public Client add(Client client)
	{
		return cr.save(client);
	}
	
	public List<Client> getAll(int slno)
	{
		//return (List<Client>)cr.findAll();
		return cr.getAll(slno);
	}
	
	public Client getById(int slno)
	{
		return cr.findOneBySlno(slno);
	}
	
	public Client update(Client client)
	{
		return cr.save(client);
	}
	
	public ResponseStatus deleteClient(Integer slno)
	{
		//cr.delete(client);
		return cr.deleteClient(slno);
	}

	public ResponseStatus addClient(Client client) {
		// TODO Auto-generated method stub
		return cr.addClient(client);
	}
	
	public ResponseStatus updateClient(Client client) {
		// TODO Auto-generated method stub
		return cr.updateClient(client);
	}

	public List<Client> getAllDeleted(int user_slno) {
		// TODO Auto-generated method stub
		return cr.getAllDeleted(user_slno);
	}

	public ResponseStatus restoreClient(Integer slno) {
		// TODO Auto-generated method stub
		return cr.restoreClient(slno);
	}
}

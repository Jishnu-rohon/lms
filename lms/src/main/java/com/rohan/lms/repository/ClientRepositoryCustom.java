package com.rohan.lms.repository;

import java.util.List;

import com.rohan.lms.model.Client;
import com.rohan.lms.utility.ResponseStatus;

public interface ClientRepositoryCustom {
	List<Client> getAll(int slno); 
	
	ResponseStatus addClient(Client client);

	ResponseStatus updateClient(Client client);
	
	ResponseStatus deleteClient(Integer slno);
	
	List<Client> getAllDeleted(int user_slno);
	
	ResponseStatus restoreClient(Integer slno);
}

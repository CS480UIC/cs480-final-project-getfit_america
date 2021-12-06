package client.service;


import java.util.List;

import client.dao.ClientDao;
import client.domain.Client;

/**
 * logic functions such as register, login
 * @author Mitchell Misayah
 *
 */
public class ClientService {
	private ClientDao clientDao = new ClientDao();
	
	/**
	 * register a Client
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Client form) throws ClientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Client client = clientDao.findByClientID(form.getClient_id());
		if(client.getClient_id()!=null && client.getClient_id() == form.getClient_id()) throw new ClientException("This client id has been registered!");
		clientDao.add(form);
	}

	public List<Object> findWeightAvg() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return clientDao.findWeightAvg();
		
	}

	public List<Object> findWeightBelow180() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return clientDao.findWeighBelow180();
		
	}
}

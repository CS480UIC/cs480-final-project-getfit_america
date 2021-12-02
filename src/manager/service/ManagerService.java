package manager.service;


import java.util.List;

import manager.dao.ManagerDao;
import manager.domain.Manager;

/**
 * logic functions such as register, login
 * @author Melville Misayah
 *
 */
public class ManagerService {
	private ManagerDao managerDao = new ManagerDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Manager form) throws ManagerException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		
		Manager entity1 = managerDao.findByID(form.getId());
		if(entity1.getId()!=null && entity1.getId()==form.getId()) throw new ManagerException("This manager has been registered!");
		managerDao.add(form);
	}

	public List<Object> findAllManagerId_2003_2005() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return managerDao.findManagerId_2003_2005();
		
	}	

}

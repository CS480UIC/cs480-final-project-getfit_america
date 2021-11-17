package init.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.User;
import init.dao.initDao;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 */
public class initService {
	private UserDao userDao = new UserDao();
	private initDao initDao = new initDao();
	
	/**
	 * Register a user
	 */
	public void initializeDB() throws initException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		initDao.initialize();
	}
	
	

	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findall();
		
	}
}

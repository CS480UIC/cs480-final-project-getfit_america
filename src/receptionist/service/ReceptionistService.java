package receptionist.service;


import receptionist.dao.ReceptionistDao;
import receptionist.domain.Receptionist;

/**
 * logic functions such as register, login
 * @author Melville Misayah
 *
 */
public class ReceptionistService {
	private ReceptionistDao receptionistDao = new ReceptionistDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Receptionist form) throws ReceptionistException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Receptionist entity1 = receptionistDao.findByID(form.getEmployee_id());
		if(entity1.getEmployee_id() !=null && entity1.getEmployee_id() == form.getEmployee_id()) throw new ReceptionistException("This receptionist name has been registered!");
		receptionistDao.add(form);
	}

}

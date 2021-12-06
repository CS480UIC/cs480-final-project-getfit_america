package trainer.service;


import java.util.List;

import trainer.dao.TrainerDao;
import trainer.domain.Trainer;

/**
 * logic functions such as register, login
 * @author Mitchell Misayah
 *
 */
public class TrainerService {
	private TrainerDao trainerDao = new TrainerDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Trainer form) throws TrainerException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Trainer entity1 = trainerDao.findByEmployeeID(form.getEmployee_id());
		if(entity1.getEmployee_id()!=null && entity1.getEmployee_id() == form.getEmployee_id()) throw new TrainerException("This trainer employee_id has been registered!");
		trainerDao.add(form);
	}

	public List<Object> findallTrainers() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return trainerDao.findallTrainers();
		
	}
	
	public List<Object> findTrainerClient() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return trainerDao.findTrainerClient();
		
	}
	
	public List<Object> findClientSpecialCondition() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return trainerDao.findClientSpecialCondition();	
	}
	
	public List<Object> findTrainerComplexQuery3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return trainerDao.findTrainerComplexQuery3();	
	}
}

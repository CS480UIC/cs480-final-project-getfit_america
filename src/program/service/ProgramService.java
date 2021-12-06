package program.service;


import java.util.List;

import program.dao.ProgramDao;
import program.domain.Program;

/**
 * logic functions such as register, login
 * @author Mitchell Misayah
 *
 */
public class ProgramService {
	private ProgramDao programDao = new ProgramDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Program form) throws ProgramException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Program entity1 = programDao.findByEnrollmentNumber(form.getEnrollment_number());
		if(entity1.getEnrollment_number()!=null && entity1.getEnrollment_number().equals(form.getEnrollment_number())) throw new ProgramException("This user name has been registered!");
		programDao.add(form);
	}

	public List<Object> findKeto() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return programDao.findKeto();
		
	}

	public List<Object> program_concat() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return programDao.program_concat();
		
	}
}

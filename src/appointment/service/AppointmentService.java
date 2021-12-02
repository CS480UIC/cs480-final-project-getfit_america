package appointment.service;


import appointment.dao.AppointmentDao;
import appointment.domain.Appointment;

/**
 * 
 * @author Melville Misayah
 *
 */
public class AppointmentService {
	private AppointmentDao appointmentDao = new AppointmentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Appointment form) throws AppointmentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Appointment entity1 = appointmentDao.findBySelectedProg(form.getSelected_prog());
		if(entity1.getSelected_prog()!=null && entity1.getSelected_prog()==form.getSelected_prog()) throw new AppointmentException("This user name has been registered!");
		appointmentDao.add(form);
	}

}

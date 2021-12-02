package appointment.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appointment.dao.AppointmentDao;
import appointment.domain.Appointment;

/**
 * Servlet implementation class UserServlet
 */

public class AppointmentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppointmentServletUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		AppointmentDao appointmentdao = new AppointmentDao();
		Appointment appointment = null;

		if(method.equals("search"))
		{
			try {
				appointment = appointmentdao.findBySelectedProg(Integer.parseInt(request.getParameter("selected_prog")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(appointment.getSelected_prog()!=null){
				request.setAttribute("appointment", appointment);
				request.getRequestDispatcher("/jsps/appointment/appointmentupdate_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Appointment not found");
				request.getRequestDispatcher("/jsps/appointment/appointment_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Appointment form = new Appointment();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			//form.setId(Integer.parseInt(request.getParameter("id")));
			form.setSelected_prog(Integer.parseInt(request.getParameter("selected_prog")));
			form.setAppointment_date(java.sql.Date.valueOf(request.getParameter("appointment_date")));
			form.setLocation(info.get(3));
			form.setProgram_app_num(Integer.parseInt(info.get(4)));
			

			try {
				appointmentdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Appointment Updated");
			request.getRequestDispatcher("/jsps/appointment/appointment_read_output.jsp").forward(request, response);
		}
	}
}




package receptionist.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import receptionist.dao.ReceptionistDao;
import receptionist.domain.Receptionist;

/**
 * Servlet implementation class UserServlet
 */

public class ReceptionistServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceptionistServletUpdate() {
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
		ReceptionistDao receptionistdao = new ReceptionistDao();
		Receptionist receptionist = null;

		if(method.equals("search"))
		{
			try {
				receptionist = receptionistdao.findByID(Integer.parseInt(request.getParameter("employee_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(receptionist.getEmployee_id()!=null){
				request.setAttribute("receptionist", receptionist);
				request.getRequestDispatcher("/jsps/receptionist/receptionist_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Receptionist not found");
				request.getRequestDispatcher("/jsps/receptionist/receptionist_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Receptionist form = new Receptionist();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}

			
			form.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));
			try {
				receptionistdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Receptionist Updated");
			request.getRequestDispatcher("/jsps/receptionist/receptionist_read_output.jsp").forward(request, response);
		}
	}
}




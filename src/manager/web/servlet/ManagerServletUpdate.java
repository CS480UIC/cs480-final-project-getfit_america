package manager.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.dao.ManagerDao;
import manager.domain.Manager;

/**
 * Servlet implementation class UserServlet
 */

public class ManagerServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServletUpdate() {
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
		ManagerDao entity1dao = new ManagerDao();
		Manager manager = null;

		if(method.equals("search"))
		{
			try {
				manager = entity1dao.findByID(Integer.parseInt(request.getParameter("ID")));
				//entity1 = entity1dao.findByUsername(request.getParameter("username"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(manager.getFirst_name()!=null){
				request.setAttribute("manager", manager);
				request.getRequestDispatcher("/jsps/manager/manager_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/manager/manager_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Manager form = new Manager();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));

			
			form.setId(Integer.parseInt(info.get(0)));
			form.setDepartment_id(Integer.parseInt(info.get(1)));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));
			form.setCreated_at(java.sql.Date.valueOf(info.get(4)));			
			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Manager Updated");
			request.getRequestDispatcher("/jsps/manager/manager_read_output.jsp").forward(request, response);
		}
	}
}




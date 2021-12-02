package program.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.dao.ProgramDao;
import program.domain.Program;

/**
 * Servlet implementation class UserServlet
 */

public class ProgramServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProgramServletUpdate() {
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
		ProgramDao porgramdao = new ProgramDao();
		Program program = null;

		if(method.equals("search"))
		{
			try {
				program = porgramdao.findByEnrollmentNumber(Integer.parseInt( request.getParameter("enrollment_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(program.getEnrollment_number()!=null){
				request.setAttribute("program", program);
				request.getRequestDispatcher("/jsps/program/program_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Program not found");
				request.getRequestDispatcher("/jsps/program/program_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Program form = new Program();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			//TODO fix
			form.setEnrollment_number(Integer.parseInt( request.getParameter("enrollment_number")));
			form.setProgram_id(Integer.parseInt( request.getParameter("program_id")));
			form.setProgram_name(info.get(3));
			form.setDescription(info.get(4));			
			

			try {
				porgramdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Program Updated");
			request.getRequestDispatcher("/jsps/program/program_read_output.jsp").forward(request, response);
		}
	}
}




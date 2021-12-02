package program.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.dao.ProgramDao;
import program.domain.Program;


/**
 * Servlet implementation class UserServlet
 */

public class ProgramServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramServletDelete() {
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
		ProgramDao programDao = new ProgramDao();
		Program program = null;
		if(method.equals("search"))
		{
			try {
				program = programDao.findByEnrollmentNumber(Integer.parseInt( request.getParameter("enrollment_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(program.getEnrollment_number()!=null){
						System.out.println(program);
						request.setAttribute("program", program);
						request.getRequestDispatcher("/jsps/program/program_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Program not found");
				request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				programDao.delete(request.getParameter("enrollment_number"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Program Deleted");
			request.getRequestDispatcher("/jsps/program/program_read_output.jsp").forward(request, response);
		}
	}
}




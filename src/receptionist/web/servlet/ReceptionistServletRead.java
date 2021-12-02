package receptionist.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import receptionist.dao.ReceptionistDao;
import receptionist.domain.Receptionist;


/**
 * Servlet implementation class UserServlet
 */

public class ReceptionistServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceptionistServletRead() {
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
		Receptionist receptionist = null;
		ReceptionistDao receptionistDao = new ReceptionistDao();
		
		try {
			receptionist = receptionistDao.findByID(Integer.parseInt(request.getParameter("username")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(receptionist.getEmployee_id()!=null){
					System.out.println(receptionist);
					request.setAttribute("receptionist", receptionist);
					request.getRequestDispatcher("/jsps/receptionist/receptionist_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Receptionist not found");
			request.getRequestDispatcher("/jsps/receptionist/receptionist_read_output.jsp").forward(request, response);
		}
	}
}




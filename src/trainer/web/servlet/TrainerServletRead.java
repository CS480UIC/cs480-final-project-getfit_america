package trainer.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainer.dao.TrainerDao;
import trainer.domain.Trainer;


/**
 * Servlet implementation class UserServlet
 */

public class TrainerServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainerServletRead() {
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
		Trainer trainer = null;
		TrainerDao trainerDao = new TrainerDao();
		
		try {
			trainer = trainerDao.findByEmployeeID(Integer.parseInt(request.getParameter("employee_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(trainer.getEmployee_id()!=null){
					System.out.println(trainer);
					request.setAttribute("trainer", trainer);
					request.getRequestDispatcher("/jsps/trainer/trainer_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Trainer not found");
			request.getRequestDispatcher("/jsps/trainer/trainer_read_output.jsp").forward(request, response);
		}
	}
}




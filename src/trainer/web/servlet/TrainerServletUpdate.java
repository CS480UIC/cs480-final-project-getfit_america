package trainer.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainer.dao.TrainerDao;
import trainer.domain.Trainer;

/**
 * Servlet implementation class UserServlet
 */

public class TrainerServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainerServletUpdate() {
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
		TrainerDao trainerdao = new TrainerDao();
		Trainer trainer = null;

		if(method.equals("search"))
		{
			try {
				trainer = trainerdao.findByEmployeeID(Integer.parseInt(request.getParameter("employee id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(trainer.getEmployee_id()!=null){
				request.setAttribute("trainer", trainer);
				request.getRequestDispatcher("/jsps/trainer/trainer_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Trainer not found");
				request.getRequestDispatcher("/jsps/trainer/trainer_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Trainer form = new Trainer();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			//TODO fix
			form.setEmployee_id(Integer.parseInt(info.get(1)));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));	

			try {
				trainerdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Trainer Updated");
			request.getRequestDispatcher("/jsps/trainer/trainer_read_output.jsp").forward(request, response);
		}
	}
}




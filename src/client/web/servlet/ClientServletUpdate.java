package client.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.dao.ClientDao;
import client.domain.Client;

/**
 * Servlet implementation class UserServlet
 */

public class ClientServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServletUpdate() {
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
		ClientDao clientdao = new ClientDao();
		Client client = null;

		if(method.equals("search"))
		{
			try {
				client = clientdao.findByClientID(Integer.parseInt( request.getParameter("client_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(client.getClient_id()!=null){
				request.setAttribute("client", client);
				request.getRequestDispatcher("/jsps/client/client_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Client not found");
				request.getRequestDispatcher("/jsps/entity1/client_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Client form = new Client();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			//TODO fix
			form.setClient_id(Integer.parseInt( info.get(0)));
			form.setTrainer_id(Integer.parseInt( info.get(1)));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));
			form.setAge(Integer.parseInt( info.get(4)));	
			form.setWeight(Double.parseDouble( info.get(5)));
			form.setBody_fat(Double.parseDouble( info.get(6)));

			try {
				clientdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Client Updated");
			request.getRequestDispatcher("/jsps/client/client_read_output.jsp").forward(request, response);
		}
	}
}




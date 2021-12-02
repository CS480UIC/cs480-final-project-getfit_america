package client.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.domain.Client;
import client.service.ClientException;
import client.service.ClientService;


/**
 * Servlet implementation class UserServlet
 */

public class ClientServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServletCreate() {
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
		ClientService clientservice = new ClientService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Client form = new Client();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		
		form.setClient_id(Integer.parseInt( info.get(0)));
		form.setTrainer_id(Integer.parseInt( info.get(1)));
		form.setFirst_name(info.get(2));
		form.setLast_name(info.get(3));
		form.setAge(Integer.parseInt( info.get(4)));	
		form.setWeight(Double.parseDouble( info.get(5)));
		form.setBody_fat(Double.parseDouble( info.get(6)));
		
		
		
		
		try {
			clientservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | ClientException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}

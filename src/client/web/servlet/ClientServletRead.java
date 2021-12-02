package client.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.dao.ClientDao;
import client.domain.Client;


/**
 * Servlet implementation class UserServlet
 */

public class ClientServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServletRead() {
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
		Client client = null;
		ClientDao entity1Dao = new ClientDao();
		
		try {
			client = entity1Dao.findByClientID(Integer.parseInt( request.getParameter("client_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(client.getClient_id()!=null){
					System.out.println(client);
					request.setAttribute("client", client);
					request.getRequestDispatcher("/jsps/client/client_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Client not found");
			request.getRequestDispatcher("/jsps/client/client_read_output.jsp").forward(request, response);
		}
	}
}




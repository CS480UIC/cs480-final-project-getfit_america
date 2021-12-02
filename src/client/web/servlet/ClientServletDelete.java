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

public class ClientServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServletDelete() {
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
		ClientDao entity1Dao = new ClientDao();
		Client client = null;
		if(method.equals("search"))
		{
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
						request.getRequestDispatcher("/jsps/client/client_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Client not found");
				request.getRequestDispatcher("/jsps/client/client_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				entity1Dao.delete(request.getParameter("client_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Client Deleted");
			request.getRequestDispatcher("/jsps/client/client_read_output.jsp").forward(request, response);
		}
	}
}




package it.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.Model.Viaggio;
import it.Model.ViaggioPromo;
import it.Model.Persistence.ViaggioDTO;
import it.Model.Persistence.ViaggioDAO;
import it.Model.Carrello;


public class ViaggioControl extends HttpServlet {
	
	static ViaggioDAO dto= new ViaggioDTO();
	
	public ViaggioControl() {
		super();
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Carrello cart = (Carrello)request.getSession().getAttribute("carrello");
		if(cart == null) {
			cart = new Carrello();
			request.getSession().setAttribute("carrello", cart);
		}
		String action = (String) request.getParameter("action");

		try{
			
			if(action!=null){
				
				if(action.equals("addC")){
					
					int codtratta = Integer.parseInt(request.getParameter("id"));
					cart.addProduct(dto.doRetrieveByKey(codtratta));
									} 
				else if (action.equalsIgnoreCase("deleteC")) {
					
					int id = Integer.parseInt(request.getParameter("id"));
					cart.deleteProduct(dto.doRetrieveByKey(id));
				} 
				
			}
			
		}

		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		
		request.getSession().setAttribute("carrello",cart);
		try{
			
			request.removeAttribute("viaggi");
			request.setAttribute("viaggi", dto.doRetrieveAll("dataorap"));
			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/catalogo.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

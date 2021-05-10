package cl.inacap.zcapApp.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.ConsolasDAOLocal;
import cl.inacap.zCapModel.dto.Consola;



/**
 * Servlet implementation class VerConsolaController
 */
@WebServlet("/VerConsolaController.do")
public class VerConsolaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Inject
	private ConsolasDAOLocal consolasDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerConsolaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("nombreEliminar") != null) {
			String nombre = request.getParameter("nombreEliminar".trim());
			List<Consola> busqueda = consolasDAO.filterByName(nombre);
			
			Consola consolaAEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			if(consolaAEliminar != null) {
				consolasDAO.delete(consolaAEliminar);
			}
		}
		
		List<Consola> consolas = consolasDAO.getAll();
		
		request.setAttribute("consolas", consolas);
			
		//ESTO NOS LANZA LA VISTA AL MOMENTO DE RECIBIR UN GET
		request.getRequestDispatcher("WEB-INF/vistas/verConsolas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

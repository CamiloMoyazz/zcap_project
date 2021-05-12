package cl.inacap.zcapApp.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.JuegosDAOLocal;
import cl.inacap.zCapModel.dto.Juego;



/**
 * Servlet implementation class VerJuegosController
 */
@WebServlet("/VerJuegosController.do")
public class VerJuegosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Inject
	private JuegosDAOLocal juegosDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerJuegosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Juego> juegos = juegosDAO.getAll();
		
		request.setAttribute("juegos", juegos);
		
		
		request.getRequestDispatcher("WEB-INF/vistas/verJuegos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

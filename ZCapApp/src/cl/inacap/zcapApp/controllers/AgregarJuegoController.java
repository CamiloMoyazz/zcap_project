package cl.inacap.zcapApp.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.ConsolasDAO;
import cl.inacap.zCapModel.dao.ConsolasDAOLocal;
import cl.inacap.zCapModel.dao.JuegosDAOLocal;
import cl.inacap.zCapModel.dto.Consola;
import cl.inacap.zCapModel.dto.Juego;

/**
 * Servlet implementation class AgregarJuegoController
 */
@WebServlet("/AgregarJuegoController.do")
public class AgregarJuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConsolasDAOLocal consolasDAO;
	
	@Inject
	private JuegosDAOLocal juegosDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarJuegoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Consola> consolas = consolasDAO.getAll();
		request.setAttribute("consolas", consolas);
		
		request.getRequestDispatcher("WEB-INF/vistas/agregarJuegos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreTxt = request.getParameter("nombre-txt".trim());
		String descripcionTxt = request.getParameter("descripcion-txt".trim());
		String consolaTxt = request.getParameter("consola-select".trim());
		String aptoTxt = request.getParameter("apto-radio".trim());
		String precioTxt = request.getParameter("precio-txt".trim());
		String fechaTxt = request.getParameter("fecha-txt".trim());
		int precio=0;
		Consola consola = null;
		LocalDate fecha;
		
		//PARA CONVERTIR LAS FECHAS DESDE Y HACIA TEXTO
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		fecha = LocalDate.parse(fechaTxt,formater);
		
		List<Consola> consolasFiltradas = consolasDAO.filterByName(consolaTxt);
		
		if(!consolasFiltradas.isEmpty()) {
			consola = consolasFiltradas.get(0);
		}
		
		//TODO: SI LA CONSOLA LLEGA NULL ACA, HAY QUE MANDAR UN MENSAJE DE ERROR
		//TODO: VALIDAR QUE EL PRECIO SE UN NUMERO MAYOR A 0
		
		precio = Integer.parseInt(precioTxt);

		Juego juego = new Juego();
		juego.setNombre(nombreTxt);
		juego.setDescripcion(descripcionTxt);
		juego.setConsola(consola);
		juego.setApto(aptoTxt.equals("si")); // Si hay un SI se guarda un TRUE y es un NO se guarda FALSE
		juego.setPrecio(precio);
		juego.setFechaLanzamiento(fecha);
		
		juegosDAO.save(juego);

		request.setAttribute("mensaje", "Juego Registrado!");
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

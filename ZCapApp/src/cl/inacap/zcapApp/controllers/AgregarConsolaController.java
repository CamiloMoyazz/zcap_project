package cl.inacap.zcapApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AgregarConsolaController
 */
@WebServlet("/AgregarConsolaController.do")
public class AgregarConsolaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Inject
	private ConsolasDAOLocal consolasDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarConsolaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/agregarConsolas.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//CREAMOS UNA LISTA DE TIPO STRING PARA GUARDAR DENTRO TODOS LOS ERRORES ENCONTRADOS DE UN FORMULARIO
		List<String> errores = new ArrayList<>();
		
		
		//NOMBRE-TXT
		String nombre = request.getParameter("nombre-txt").trim();
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre");
		}
		
		
		//ANIO LANZAMIENTO-TXT
		String lanzamientoTxt = request.getParameter("anio-txt").trim();
		int lanzamiento=0;
		try {
			lanzamiento = Integer.parseInt(lanzamientoTxt);
		}catch(Exception ex) {
			errores.add("El año debe ser númerico");
		}
		
		
		//MARCA-TXT
		String marca = request.getParameter("marca-select").trim();
		if(marca.isEmpty()) {
			errores.add("Debe seleccionar una marca");
		}
		
		
		//PREGUNTA FINAL
		if(errores.isEmpty()) {
			//PUEDO INGRESAR LA CONSOLA EN LA LISTA 
			Consola consola = new Consola();
			consola.setNombre(nombre);
			consola.setMarca(marca);
			consola.setLanzamiento(lanzamiento);
			consolasDAO.save(consola);
			
			request.setAttribute("mensaje", "Consola Registrada Exitosamente");
			
		}else {
			//MOSTRAR TODOS LOS ERRORES
			request.setAttribute("errores", errores);
		}
		
		doGet(request, response);
		
	}

}

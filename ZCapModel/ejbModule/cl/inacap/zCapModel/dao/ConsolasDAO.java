package cl.inacap.zCapModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.zCapModel.dto.Consola;

/**
 * Session Bean implementation class ConsolasDAO
 */
@Stateless
@LocalBean
public class ConsolasDAO implements ConsolasDAOLocal {

	private static List<Consola> consolas = new ArrayList<>(); //LISTA ESTATICA DE LAS CONSOLAS 

	/**
	 * Default constructor.
	 */
	public ConsolasDAO() {
		
	}

	@Override
	public void save(Consola consola) {
		consolas.add(consola);

	}

	@Override
	public List<Consola> getAll() {
		// TODO Auto-generated method stub
		return consolas;
	}

	@Override
	public void delete(Consola consola) {
		consolas.remove(consola);

	}

	@Override
	public List<Consola> filterByName(String nombre) {
		
		// CON STREAM RECORREMOS LA LISTA DE CONSOLAS, FILTRAMOS POR CADA NOMBRE DE CONSOLA QUE CONTENGA EL NOMBRE, COLECCIONALO EN UNA LISTA DE COLECCION;
		return consolas.stream().filter(c->c.getNombre().toLowerCase().contains(nombre.toLowerCase())).collect(Collectors.toList());
	}

}

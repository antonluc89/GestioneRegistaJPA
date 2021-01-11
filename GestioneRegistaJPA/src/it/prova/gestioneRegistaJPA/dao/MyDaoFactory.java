package it.prova.gestioneRegistaJPA.dao;

import it.prova.gestioneRegistaJPA.dao.film.FilmDAO;
import it.prova.gestioneRegistaJPA.dao.film.FilmDAOImpl;
import it.prova.gestioneRegistaJPA.dao.regista.RegistaDAO;
import it.prova.gestioneRegistaJPA.dao.regista.RegistaDAOImpl;

public class MyDaoFactory {
	private static FilmDAO filmDAOInstance = null;
	private static RegistaDAO registaDAOInstance = null;

	public static FilmDAO getFilmDAOInstance() {
		if (filmDAOInstance == null)
			filmDAOInstance = new FilmDAOImpl();
		return filmDAOInstance;
	}

	public static RegistaDAO getRegistaDAOInstance() {
		if (registaDAOInstance == null)
			registaDAOInstance = new RegistaDAOImpl();
		return registaDAOInstance;
	}
}

package it.prova.gestioneRegistaJPA.service.film;

import java.util.List;

import it.prova.gestioneRegistaJPA.dao.film.FilmDAO;
import it.prova.gestioneRegistaJPA.model.Film;
import it.prova.gestioneRegistaJPA.model.Regista;

public interface FilmService {
	public List<Film> listAllFilms() throws Exception;

	public Film trovaById(Long id) throws Exception;

	public void aggiorna(Film filmInstance) throws Exception;

	public void inserisciNuovo(Film filmInstance) throws Exception;

	public void rimuovi(Film filmInstance) throws Exception;

	public Film cercaConIdConJoin(Long id) throws Exception;

	public void cancellaFilmTramiteRegista(Regista registaInstance) throws Exception;

	public List<Film> cercaByNomeCognomeRegista(String nomeRegista, String cognomeRegista) throws Exception;

	public List<Film> cercadoveGenereFilmNull() throws Exception;

	public void setFilmDAO(FilmDAO filmDAO);

}

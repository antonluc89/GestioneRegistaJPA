package it.prova.gestioneRegistaJPA.dao.film;

import java.util.List;

import it.prova.gestioneRegistaJPA.dao.IBaseDAO;
import it.prova.gestioneRegistaJPA.model.Film;
import it.prova.gestioneRegistaJPA.model.Regista;

public interface FilmDAO extends IBaseDAO<Film> {

	public Film findByIdWithJoin(Long id) throws Exception;

	public void deleteByRegista(Regista registaInstance) throws Exception;

	public List<Film> findAllByNomeCognomeRegista(String nameProducer, String surnameProducer) throws Exception;

	public List<Film> findAllWhereGenereIsNull() throws Exception;

}

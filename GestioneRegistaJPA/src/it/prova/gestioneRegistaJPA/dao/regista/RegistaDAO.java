package it.prova.gestioneRegistaJPA.dao.regista;

import java.util.List;

import it.prova.gestioneRegistaJPA.dao.IBaseDAO;
import it.prova.gestioneRegistaJPA.model.Regista;

public interface RegistaDAO extends IBaseDAO<Regista> {

	public Regista maxNumBerOscarWins() throws Exception;

	public List<Regista> findAllByGenereFilmAndDurataGreaterThan(String genereInput, int durataInput) throws Exception;
}
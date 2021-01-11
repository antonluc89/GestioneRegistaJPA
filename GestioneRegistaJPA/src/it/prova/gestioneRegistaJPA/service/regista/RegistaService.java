package it.prova.gestioneRegistaJPA.service.regista;

import java.util.List;

import it.prova.gestioneRegistaJPA.dao.regista.RegistaDAO;
import it.prova.gestioneRegistaJPA.model.Regista;

public interface RegistaService {

	public List<Regista> listAllRegisti() throws Exception;

	public Regista trovaById(Long id) throws Exception;

	public void aggiorna(Regista registaInstance) throws Exception;

	public void inserisciNuovo(Regista registaInstance) throws Exception;

	public void rimuovi(Regista registaInstance) throws Exception;

	public Regista massimoNumeroOscarVinti() throws Exception;

	public List<Regista> trovaFilmdoveGenereEDurataMaggioreDi(String genereFilm, int durataFilm) throws Exception;

	public void setRegistaDAO(RegistaDAO registaDAO);

}

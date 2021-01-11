package it.prova.gestioneRegistaJPA.service.film;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneRegistaJPA.dao.film.FilmDAO;
import it.prova.gestioneRegistaJPA.model.Film;
import it.prova.gestioneRegistaJPA.model.Regista;
import it.prova.gestioneRegistaJPA.dao.EntityManagerUtil;

public class FilmServiceImpl implements FilmService {

	private FilmDAO filmDAO;

	@Override
	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;

	}

	@Override
	public List<Film> listAllFilms() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			filmDAO.setEntityManager(entityManager);

			return filmDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Film trovaById(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			filmDAO.setEntityManager(entityManager);

			return filmDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Film filmInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			filmDAO.setEntityManager(entityManager);

			filmDAO.update(filmInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Film filmInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			filmDAO.setEntityManager(entityManager);

			filmDAO.insert(filmInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Film filmInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			filmDAO.setEntityManager(entityManager);

			filmDAO.delete(filmInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Film cercaConIdConJoin(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			filmDAO.setEntityManager(entityManager);

			return filmDAO.findByIdWithJoin(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void cancellaFilmTramiteRegista(Regista registaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			filmDAO.setEntityManager(entityManager);

			filmDAO.deleteByRegista(registaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Film> cercaByNomeCognomeRegista(String nomeRegista, String cognomeRegista) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			filmDAO.setEntityManager(entityManager);

			return filmDAO.findAllByNomeCognomeRegista(nomeRegista, cognomeRegista);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Film> cercadoveGenereFilmNull() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			filmDAO.setEntityManager(entityManager);

			return filmDAO.findAllWhereGenereIsNull();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}

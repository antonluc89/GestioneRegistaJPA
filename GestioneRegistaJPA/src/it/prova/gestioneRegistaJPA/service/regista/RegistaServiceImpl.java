package it.prova.gestioneRegistaJPA.service.regista;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneRegistaJPA.dao.regista.RegistaDAO;
import it.prova.gestioneRegistaJPA.model.Regista;
import it.prova.gestioneRegistaJPA.dao.EntityManagerUtil;

public class RegistaServiceImpl implements RegistaService {

	private RegistaDAO registaDAO;

	public void setRegistaDAO(RegistaDAO registaDAO) {
		this.registaDAO = registaDAO;
	}

	@Override
	public List<Regista> listAllRegisti() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			registaDAO.setEntityManager(entityManager);

			return registaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Regista trovaById(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			registaDAO.setEntityManager(entityManager);

			return registaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Regista registaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			registaDAO.setEntityManager(entityManager);

			registaDAO.update(registaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Regista registaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			registaDAO.setEntityManager(entityManager);

			registaDAO.insert(registaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Regista registaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			registaDAO.setEntityManager(entityManager);

			registaDAO.delete(registaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public Regista massimoNumeroOscarVinti() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			registaDAO.setEntityManager(entityManager);

			return registaDAO.maxNumBerOscarWins();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Regista> trovaFilmdoveGenereEDurataMaggioreDi(String genereFilm, int durataFilm) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			registaDAO.setEntityManager(entityManager);

			return registaDAO.findAllByGenereFilmAndDurataGreaterThan(genereFilm, durataFilm);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}

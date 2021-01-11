package it.prova.gestioneRegistaJPA.dao.regista;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import it.prova.gestioneRegistaJPA.model.Regista;

public class RegistaDAOImpl implements RegistaDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Regista> list() throws Exception {
		return entityManager.createQuery("from Regista", Regista.class).getResultList();
	}

	@Override
	public Regista get(Long id) throws Exception {
		return entityManager.find(Regista.class, id);
	}

	@Override
	public void update(Regista registaInstance) throws Exception {
		if (registaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		registaInstance = entityManager.merge(registaInstance);
	}

	@Override
	public void insert(Regista registaInstance) throws Exception {
		if (registaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(registaInstance);
	}

	@Override
	public void delete(Regista registaInstance) throws Exception {
		if (registaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(registaInstance));
	}

	@Override
	public Regista maxNumBerOscarWins() throws Exception {
		TypedQuery<Regista> query = entityManager.createQuery(
				"select r from Regista r where r.numeroOscarVinti = (select MAX(r2.numeroOscarVinti) from Regista r2 where r2.id = r.id) order by r.id",
				Regista.class);
		return query.setMaxResults(1).getSingleResult();
	}

	@Override
	public List<Regista> findAllByGenereFilmAndDurataGreaterThan(String genereFilm, int durataFilm) throws Exception {
		TypedQuery<Regista> query = entityManager
				.createQuery("from Regista r join fetch r.films r where r.genere=?1 AND r.durata>?2", Regista.class);
		return query.setParameter(1, genereFilm).setParameter(2, durataFilm).getResultList();
	}

}

package it.prova.gestioneRegistaJPA.dao.film;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneRegistaJPA.model.Film;
import it.prova.gestioneRegistaJPA.model.Regista;

public class FilmDAOImpl implements FilmDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Film> list() throws Exception {
		return entityManager.createQuery("from Film", Film.class).getResultList();
	}

	@Override
	public Film get(Long id) throws Exception {
		return entityManager.find(Film.class, id);
	}

	@Override
	public void update(Film filmInstance) throws Exception {
		if (filmInstance == null) {
			throw new Exception("Problema valore in input");
		}

		filmInstance = entityManager.merge(filmInstance);
	}

	@Override
	public void insert(Film filmInstance) throws Exception {
		if (filmInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(filmInstance);
	}

	@Override
	public void delete(Film filmInstance) throws Exception {
		if (filmInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(filmInstance));
	}

	@Override
	public Film findByIdWithJoin(Long id) throws Exception {
		TypedQuery<Film> query = entityManager.createQuery("from Film f join fetch f.regista where f.id = ?1",
				Film.class);
		return query.setParameter(1, id).getSingleResult();
	}

	@Override
	public void deleteByRegista(Regista registaInstance) throws Exception {
		if (registaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(registaInstance));
	}

	@Override
	public List<Film> findAllByNomeCognomeRegista(String nameProducer, String surnameProducer) throws Exception {
		TypedQuery<Film> query = entityManager
				.createQuery("from Film f left join fetch f.regista f where f.nome=?1 AND f.cognome=?2", Film.class);
		return query.setParameter(1, nameProducer).setParameter(2, surnameProducer).getResultList();
	}

	@Override
	public List<Film> findAllWhereGenereIsNull() throws Exception {
		TypedQuery<Film> query = entityManager.createQuery("from Film f where f.genere IS NULL", Film.class);
		return query.getResultList();
	}

}

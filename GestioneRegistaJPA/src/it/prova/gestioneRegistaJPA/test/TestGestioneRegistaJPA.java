package it.prova.gestioneRegistaJPA.test;

import it.prova.gestioneRegistaJPA.dao.EntityManagerUtil;
import it.prova.gestioneRegistaJPA.model.Film;
import it.prova.gestioneRegistaJPA.model.Regista;
import it.prova.gestioneRegistaJPA.service.MyServiceFactory;
import it.prova.gestioneRegistaJPA.service.film.FilmService;
import it.prova.gestioneRegistaJPA.service.regista.RegistaService;

public class TestGestioneRegistaJPA {

	public static void main(String[] args) {

		RegistaService registaService = MyServiceFactory.getRegistaServiceInstance();
		FilmService filmService = MyServiceFactory.getFilmServiceInstance();

		try {

			// TEST CRUD BASE PER REGISTA
			System.out.println("*******************PROVA INSERT REGISTA**************************");
			Regista nuovoRegista = new Regista("Walter", "Disney", 4);
			registaService.inserisciNuovo(nuovoRegista);
			System.out.println("Regista inserito: " + nuovoRegista);

			System.out.println("*********************PROVA DELETE REGISTA*********************");
			long idRegistaDaEliminare = 5L;
			Regista registaDaEliminare = registaService.trovaById(idRegistaDaEliminare);
			if (registaDaEliminare != null) {
				registaService.rimuovi(registaDaEliminare);
				registaDaEliminare = registaService.trovaById(idRegistaDaEliminare);
				if (registaDaEliminare == null)
					System.out.println("Cancellazione effettuata!!!");
				else
					System.out.println("Cancellazione fallita!!!");
			}

			System.out.println("*********************PROVA LIST REGISTA*********************");
			for (Regista registaItem : registaService.listAllRegisti()) {
				System.out.println(registaItem);
			}

			// TEST CRUD BASE PER FILM
			System.out.println("*******************PROVA INSERT FILM**************************");
			Film nuovoFilm = new Film("Pippo", "Cartone", 80);
			// VADO A COLLEGARLO AL REGISTA APPENA INSERITO
			nuovoFilm.setRegista(nuovoRegista);
			// SALVATAGGIO NUOVO FILM
			filmService.inserisciNuovo(nuovoFilm);
			System.out.println("Film inserito: " + nuovoFilm);

			System.out.println("*******************PROVA DELETE FILM**************************");
			Film filmDaEliminare = filmService.trovaById(2L);
			if (filmDaEliminare != null) {
				filmService.rimuovi(filmDaEliminare);
				filmDaEliminare = filmService.trovaById(2L);
				if (filmDaEliminare == null)
					System.out.println("Cancellazione effettuata!!!");
				else
					System.out.println("Cancellazione fallita!!!");
			}

			System.out.println("*********************PROVA LIST FILM*********************");
			for (Film filmItem : filmService.listAllFilms()) {
				System.out.println(filmItem);
			}

			// TEST ALTRI METODI PER REGISTA
			System.out.println(
					"***************PROVA FIND REGISTI BY GENERE FILM AND DURATA MAGGIORE DI*******************");
			for (Regista registaItem : registaService.trovaFilmdoveGenereEDurataMaggioreDi("as", 30)) {
				System.out.println(registaItem);
			}
			System.out.println("*******************PROVA MAX OSCAR VINTI**************************");
			System.out.println(registaService.massimoNumeroOscarVinti());

			// TEST ALTRI METODI PER FILM
			System.out.println("*******************PROVA DELETE FILM BY REGISTA**************************");
			long idRegistaPerEliminare = 1L;
			Film filmTramiteJoin = filmService.trovaById(idRegistaPerEliminare);
			if (filmTramiteJoin != null) {
				filmService.rimuovi(filmTramiteJoin);
				filmTramiteJoin = filmService.trovaById(idRegistaPerEliminare);
				if (filmTramiteJoin == null)
					System.out.println("Cancellazione effettutata!!!");
				else
					System.out.println("Cancellazione fallita!!!");
			}

			System.out.println("*******************PROVA FIND WITH JOIN FILM**************************");
			Film filmConJoin = filmService.cercaConIdConJoin(6L);
			System.out.println(filmConJoin);

			System.out.println("***************PROVA FIND FILM BY NOME E COGNOME REGISTA*******************");
			for (Film filmItem : filmService.cercaByNomeCognomeRegista("Walter", "Disney")) {
				System.out.println(filmItem);
			}

			System.out.println("*********************PROVA FIND FILM DOVE GENERE IS NULL*********************");
			for (Film filmGenereNullItem : filmService.cercadoveGenereFilmNull()) {
				System.out.println(filmGenereNullItem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			EntityManagerUtil.shutdown();
		}

	}

}

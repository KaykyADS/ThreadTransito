package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCarro = 1; idCarro < 5; idCarro++) {
			Thread tCont = new ThreadController(idCarro, semaforo);
			tCont.start();
		}
	}
}

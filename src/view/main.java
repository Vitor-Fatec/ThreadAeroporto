package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforonorte = new Semaphore(permissoes);

		Semaphore semaforosul = new Semaphore(permissoes);

		for (int idAvi�o = 1; idAvi�o <= 12; idAvi�o++) {
			Thread aviao = new ThreadAeroporto(idAvi�o, semaforonorte, semaforosul);
			aviao.start();
		}
	}

}

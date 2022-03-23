package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	private Semaphore semaforonorte;
	private Semaphore semaforosul;
	private int idAviao;


	public ThreadAeroporto(int idAvi�o, Semaphore semaforonorte, Semaphore semaforosul) {
		this.semaforonorte = semaforonorte;
		this.semaforosul = semaforosul;
		this.idAviao = idAvi�o;
	}

		@Override
		public void run() {
		decolagem();
		}

		private void decolagem() {
			int manobra = (int) (Math.random() * 2700) + 3000;
			int taxiar = (int) (Math.random() * 2) + 4999;
			int decolagem = (int) (Math.random() * 5) + 1000;
			int afastamento = (int) (Math.random() * 3) + 3000;
			
			int pista = (int) (Math.random() * 1.5) + 1;
			
			switch(pista) {
			
			case 1: 
				try {
					semaforonorte.acquire();
					System.out.println("Avi�o ID#"+idAviao+" est� circulando na pista Norte");
					System.out.println("Ir� fazer a manobra agora");
					System.out.println("Manobra realizada");
					System.out.println("Come�ando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a decolagem ");
					sleep(decolagem);
					System.out.println("Decolagem realizada");
					System.out.println("Aguarde o afastamento para outro avi�o entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado. Pista liberada");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaforonorte.release();
				}
			case 2: 
				try {
					semaforosul.acquire();
					System.out.println("Avi�o ID#"+idAviao+" est� circulando na pista sul");
					System.out.println("Ir� fazer a manobra agora");
					sleep(manobra);
					System.out.println("Manobra realizada");
					System.out.println("Come�ando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a decolagem ");
					sleep(decolagem);
					System.out.println("Decolagem realizada");
					System.out.println("Aguarde o afastamento para outro avi�o entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado. Pista liberada");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaforosul.release();
				}
			}

}
		
		
		
		
}
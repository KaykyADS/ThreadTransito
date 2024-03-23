package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {
    private int idCarro;
    private Semaphore semaforo;
    private String message;

    public ThreadController(int idCarro, Semaphore semaforo) {
        super();
        this.idCarro = idCarro;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        switch (idCarro) {
            case 1:
                message = "O carro " + idCarro + " está indo para a ESQUERDA...\n";
                break;
            case 2:
                message = "O carro " + idCarro + " está indo para a DIREITA...\n";
                break;
            case 3:
                message = "O carro " + idCarro + " está indo para CIMA...\n";
                break;
            case 4:
                message = "O carro " + idCarro + " está indo para BAIXO...\n";    
                break;
        }
        System.out.println("O carro " + idCarro + " quer passar mas está aguardando...");
        try {
            semaforo.acquire();
            Passagem();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

    private void Passagem() {
        System.out.println(message);
        try {
            sleep(2000);
            System.out.println("Pista liberada.\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

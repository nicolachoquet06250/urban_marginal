package fr.nicolas.choquet.urban_marginal.connection;

import java.io.IOException;
import java.net.Socket;

public class ServerSocket extends Thread {
    private Object recepteur;
    private java.net.ServerSocket serverSocket;

    public ServerSocket(Object recepteur, int port) {
        this.recepteur = recepteur;
        try {
            serverSocket = new java.net.ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Erreur grave lors de la création du socket: " + e);
            System.exit(0);
        }
    }

    @Override
    public void run() {
        Socket socket;
        while (true) {
            try {
                System.out.println("Le serveur attend !");
                socket = serverSocket.accept();
                System.out.println("Un client s'est connecté !");
            } catch (IOException e) {
                System.out.println("Erreur grave lors de la création du socket: " + e);
                System.exit(0);
            }
        }
    }
}

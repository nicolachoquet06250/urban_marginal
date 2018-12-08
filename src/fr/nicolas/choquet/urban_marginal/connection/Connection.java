package fr.nicolas.choquet.urban_marginal.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread {
    private Object recepteur;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Connection(Socket socket, Object recepteur) {
        this.recepteur = recepteur;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Erreur sur le canal de sortie " + e.getMessage());
            System.exit(0);
        }
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Erreur sur le canal d'entré " + e.getMessage());
            System.exit(0);
        }

        start();
    }

    public void envoi(Object object) {
        try {
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Erreur sur l'objet outputStream !");
        }
    }
}

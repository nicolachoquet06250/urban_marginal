package fr.nicolas.choquet.urban_marginal.connection;

import javax.swing.*;
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

        createOutputStream(socket);

        createInputStream(socket);

        start();
    }

    private void createInputStream(Socket socket) {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Erreur sur le canal d'entré " + e.getMessage());
            System.exit(0);
        }
    }

    private void createOutputStream(Socket socket) {
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Erreur sur le canal de sortie " + e.getMessage());
            System.exit(0);
        }
    }

    public void envoi(Object object) {
        try {
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Erreur sur l'objet outputStream !");
        }
    }

    @Override
    public void run() {
        boolean inOk = true;
        Object reception;
        while (inOk) {
            try {
                reception = inputStream.readObject();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "L'ordinateur distant s'est déconnecté !");
                inOk = false;
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    System.out.println("Le canal d'entré n'à pas pu se fermé !");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Le type de l'objet récupéré est inconnu !");
                System.exit(0);
            }
        }
    }
}

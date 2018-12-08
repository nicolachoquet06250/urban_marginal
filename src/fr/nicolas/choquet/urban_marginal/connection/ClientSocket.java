package fr.nicolas.choquet.urban_marginal.connection;


import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
    private boolean connectionOK = false;

    public ClientSocket(String ip, int port, Object recepteur) {
        try {
            Socket socket = new Socket(ip, port);
            System.out.println("La connexion serveur à réussis !");
            connectionOK = true;
            new Connection(socket, recepteur);
        }
        catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Server not found !");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Input/Output error !");
        }

    }

    public boolean isConnectionOK() {
        return connectionOK;
    }
}

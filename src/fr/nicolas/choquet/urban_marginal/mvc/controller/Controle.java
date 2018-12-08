package fr.nicolas.choquet.urban_marginal.mvc.controller;

import fr.nicolas.choquet.urban_marginal.connection.ClientSocket;
import fr.nicolas.choquet.urban_marginal.connection.ServerSocket;
import fr.nicolas.choquet.urban_marginal.mvc.vue.EntreeJeu;

import javax.swing.*;

public class Controle {
    private EntreeJeu frmEntreeJeu;
    private int port = 6666;

    public EntreeJeu getFrmEntreeJeu() {
        return frmEntreeJeu;
    }

    public int getPort() {
        return port;
    }

    public Controle() {
        frmEntreeJeu = new EntreeJeu(this);
        frmEntreeJeu.setVisible(true);
    }

    public void evenementVue(JFrame frame, Object info) {
        if(frame instanceof EntreeJeu) {
            evenementEntreeJeu(info);
        }
    }

    private void evenementEntreeJeu(Object info) {
        String _info = (String)info;
        if(_info.equals("serveur")) {
            ServerSocket serverSocket = new ServerSocket(this, getPort());
            serverSocket.start();
        }
        else {
            if((new ClientSocket(_info, getPort(), this)).isConnectionOK()) {

            }
        }
    }

    public static void main(String[] argv) {
        new Controle();
    }
}

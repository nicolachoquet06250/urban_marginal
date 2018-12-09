package fr.nicolas.choquet.urban_marginal.mvc.controller;

import fr.nicolas.choquet.urban_marginal.connection.ClientSocket;
import fr.nicolas.choquet.urban_marginal.connection.ServerSocket;
import fr.nicolas.choquet.urban_marginal.mvc.model.Jeu;
import fr.nicolas.choquet.urban_marginal.mvc.model.JeuClient;
import fr.nicolas.choquet.urban_marginal.mvc.model.JeuServeur;
import fr.nicolas.choquet.urban_marginal.mvc.vue.Arene;
import fr.nicolas.choquet.urban_marginal.mvc.vue.ChoixJoueur;
import fr.nicolas.choquet.urban_marginal.mvc.vue.EntreeJeu;

import javax.swing.*;

public class Controle {
    private EntreeJeu frmEntreeJeu;
    private int port = 6666;
    private Jeu jeu;
    private Arene frmArene;
    private ChoixJoueur frmChoixJoueur;

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
            jeu = new JeuServeur(this);
            frmEntreeJeu.dispose();
            frmArene = new Arene(this);
            frmArene.setVisible(true);
        }
        else {
            if((new ClientSocket(_info, getPort(), this)).isConnectionOK()) {
                jeu = new JeuClient(this);
                frmEntreeJeu.dispose();
                frmArene = new Arene(this);
                frmChoixJoueur = new ChoixJoueur(this);
                frmChoixJoueur.setVisible(true);
            }
        }
    }

    public static void main(String[] argv) {
        new Controle();
    }
}

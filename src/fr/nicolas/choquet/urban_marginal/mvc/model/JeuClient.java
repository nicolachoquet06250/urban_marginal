package fr.nicolas.choquet.urban_marginal.mvc.model;

import fr.nicolas.choquet.urban_marginal.connection.Connection;
import fr.nicolas.choquet.urban_marginal.mvc.controller.Controle;

public class JeuClient extends Jeu {
    public JeuClient(Controle controle) {
        this.controle = controle;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void reception(Connection connection, Object info) {

    }

    @Override
    public void deconnection(Connection connection) {

    }

    public void envoi(Object info) {
        super.envoi(connection, info);
    }
}

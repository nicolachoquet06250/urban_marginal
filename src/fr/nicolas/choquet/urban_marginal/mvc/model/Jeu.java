package fr.nicolas.choquet.urban_marginal.mvc.model;

import fr.nicolas.choquet.urban_marginal.connection.Connection;
import fr.nicolas.choquet.urban_marginal.mvc.controller.Controle;

public abstract class Jeu {
    protected Controle controle;
    protected Connection connection;

    public abstract void setConnection(Connection connection);
    public abstract void reception(Connection connection, Object info);
    public abstract void deconnection(Connection connection);

    public void envoi(Connection connection, Object info) {
        connection.envoi(info);
    }
}

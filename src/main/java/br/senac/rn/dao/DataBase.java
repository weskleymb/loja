package br.senac.rn.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {
    
    private final String conexao = "ConexaoDB";
    private static DataBase singleton = new DataBase();
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    private DataBase() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(conexao);
            manager = factory.createEntityManager();
        }
    }

    public static DataBase getInstance() {
        return singleton;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

}

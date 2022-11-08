package br.com.alura.clientelo.daos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    private static final EntityManagerFactory FACTORY = Persistence.
            createEntityManagerFactory("clientelo");

    public static EntityManager createEntityManager() {
        return FACTORY.createEntityManager();
    }
}


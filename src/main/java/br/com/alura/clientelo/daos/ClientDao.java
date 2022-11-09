package br.com.alura.clientelo.daos;

import br.com.alura.clientelo.daos.util.EntityManagerCreator;
import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {

    EntityManager entityManager;

    public ClientDao() {
        this.entityManager = EntityManagerCreator.createEntityManager();
    }

    public Client findById(long id){
        return entityManager.find(Client.class, id);
    }

    public List<Client> findAll(){
        return entityManager.createQuery("from " + Client.class.getName()).getResultList();
    }

    public void create(Client client){
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    public void update(Client client){
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
    }

    public void delete(Client client){
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }

    public void deleteById(Long id){
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
}

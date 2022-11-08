package br.com.alura.clientelo.daos;

import br.com.alura.clientelo.daos.util.EntityManagerCreator;
import br.com.alura.clientelo.models.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDao {

    EntityManager entityManager;

    public OrderDao() {
        this.entityManager = EntityManagerCreator.createEntityManager();
    }

    public Order findById(long id){
        return entityManager.find(Order.class, id);
    }

    public List<Order> findAll(){
        return entityManager.createQuery("from " + Order.class.getName()).getResultList();
    }

    public void create(Order order){
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }

    public void update(Order order){
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
    }

    public void delete(Order order){
        entityManager.getTransaction().begin();
        entityManager.remove(order);
        entityManager.getTransaction().commit();
    }

    public void deleteById(Order order){
        entityManager.getTransaction().begin();
        entityManager.remove(order);
        entityManager.getTransaction().commit();
    }
}

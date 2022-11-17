package br.com.alura.clientelo.daos;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.daos.util.EntityManagerCreator;
import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.OrderCategoryReport;

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

    public List<Order> findAllWithFetchLazy(){
        return entityManager.createQuery("from " + Order.class.getName() + " o JOIN FETCH o.client_id").getResultList();
    }
    
    public List<Order> findAllByClient(Client client){return entityManager.createQuery("from " + Order.class.getName() + " o where o.client = " + client.getId()).getResultList();}

    public void create(Order order){
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }

    public void createAll(List<Order> orders){
        entityManager.getTransaction().begin();
        orders.forEach(order -> entityManager.persist(order));
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

    public void deleteById(Long id){
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
}

package br.com.alura.clientelo.daos;

import br.com.alura.clientelo.daos.util.EntityManagerCreator;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.models.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {

    EntityManager entityManager;

    public ProductDao() {
        this.entityManager = EntityManagerCreator.createEntityManager();
    }

    public Product findById(long id){
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll(){
        return entityManager.createQuery("from " + Product.class.getName()).getResultList();
    }

    public void create(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public void update(Product product){
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
    }

    public void delete(Product product){
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    public void deleteById(Product product){
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}

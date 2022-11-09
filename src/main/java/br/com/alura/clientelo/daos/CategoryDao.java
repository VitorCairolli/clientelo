package br.com.alura.clientelo.daos;

import br.com.alura.clientelo.daos.util.EntityManagerCreator;
import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    EntityManager entityManager;

    public CategoryDao() {
        this.entityManager = EntityManagerCreator.createEntityManager();
    }

    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll(){
        return entityManager.createQuery("from " + Category.class.getName()).getResultList();
    }

    public void create(Category category){
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }

    public void update(Category category){
        entityManager.getTransaction().begin();
        entityManager.merge(category);
        entityManager.getTransaction().commit();
    }

    public void delete(Category category){
        entityManager.getTransaction().begin();
        entityManager.remove(category);
        entityManager.getTransaction().commit();
    }

    public void deleteById(Long id){
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
}

package br.com.alura.clientelo.daos;

import br.com.alura.clientelo.daos.util.EntityManagerCreator;
import br.com.alura.clientelo.models.Product;
import br.com.alura.clientelo.vo.ClientTotalPriceAndOrdersVO;
import br.com.alura.clientelo.vo.MostSoldProductsVO;

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

    public List<MostSoldProductsVO> findMostSoldProducts(){
        String query = "select new " + MostSoldProductsVO.class.getName() + " (p.id, p.name, p.price, sum(pi2.quantity) as products_sold, p.quantityInStock, p.description) from Product p join ProductItem pi2 on pi2.product = p group by p.id order by products_sold desc";

        return entityManager.createQuery(query).getResultList();
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

    public void deleteById(Long id){
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
}

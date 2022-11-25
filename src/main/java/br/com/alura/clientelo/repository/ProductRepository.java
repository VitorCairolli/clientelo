package br.com.alura.clientelo.repository;

import br.com.alura.clientelo.models.Product;
import br.com.alura.clientelo.vo.MostSoldProductsVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select new br.com.alura.clientelo.vo.MostSoldProductsVO (p.id, p.name, p.price, sum(pi2.quantity) as products_sold, p.quantityInStock, p.description) from Product p join ProductItem pi2 on pi2.product = p group by p.id order by products_sold desc")
    List<MostSoldProductsVO> findOrderedByMostSoldProducts();
}

package br.com.alura.clientelo.repository;

import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.vo.ClientTotalPriceAndOrdersVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("select new br.com.alura.clientelo.vo.ClientTotalPriceAndOrdersVO (c.name, sum(o.totalPrice), count(o.id)) from Client c join Order o on o.client = c group by c.id order by sum(o.totalPrice) desc")
    List<ClientTotalPriceAndOrdersVO> findByMostExpended();
}

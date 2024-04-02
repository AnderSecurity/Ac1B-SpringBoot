package com.facens.ac1.Repository;

import com.facens.ac1.Model.Produtos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
    @Query (value="select * from produtos where precoprod > ?1", nativeQuery = true)
    List<Produtos> findAllByPriceMoreThan(Double pricDouble);

    @Query (value="select * from produtos where precoprod <= ?1", nativeQuery = true)
    List<Produtos> findAllByPriceLessAndEqualThan(Double value);

    @Query (value="select * from produtos where nameprod like ?1%", nativeQuery = true)
    List<Produtos> findAllByBeginName(String name);
}

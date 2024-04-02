package com.facens.ac1.Repository;

import com.facens.ac1.Model.Categorias;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    @Query(value="select * from categorias where namecat like ?1%", nativeQuery = true)
    List<Categorias> findAllByBeginName(String name);

    @Query(value="select ca from categorias ca left join fetch ca.idprodutos where ca.idcat = :id")
    Categorias findCategoryById(@Param("id") Long id);
}

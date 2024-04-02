package com.facens.ac1.Controller;

import com.facens.ac1.Model.Produtos;
import com.facens.ac1.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProdutosController {
    @Autowired
    private ProdutosRepository produtosRepository;

    public List<Produtos> findAll(){
        return produtosRepository.findAll();
    }

    public void save(Produtos produtos){
        produtosRepository.save(produtos);
    }

    public void delete(Integer id){
        produtosRepository.deleteById(id);
    }

    public Produtos findById(Integer id){
        return produtosRepository.getReferenceById(id);
    }

    public void update(Produtos produtos){
        produtosRepository.save(produtos);
    }

    public List<Produtos> findAllByPriceMoreThan(Double pricDouble) {
        return produtosRepository.findAllByPriceMoreThan(pricDouble);
    }

    public List<Produtos> findAllByPriceLessAndEqualThan(Double value) {
        return produtosRepository.findAllByPriceLessAndEqualThan(value);
    }

    public List<Produtos> findAllByBeginName(String name) {
        return produtosRepository.findAllByBeginName(name);
    }
}

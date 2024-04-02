package com.facens.ac1.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "categorias")
@Table(name = "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="idcat")
    private Long idcat;

    @Column(columnDefinition = "TINYTEXT")
    private String namecat;

    @OneToMany(mappedBy = "categorias")
    private List<Produtos> idprodutos;

    public Long getId_categorias() {
        return idcat;
    }

    public void setId_categorias(Long id_categorias) {
        this.idcat = id_categorias;
    }

    public String getCat_nome() {
        return namecat;
    }

    public void setCat_nome(String cat_nome) {
        this.namecat = cat_nome;
    }

    public List<Produtos> getProdutos() {
        return idprodutos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.idprodutos = produtos;
    }

    public Categorias(String cat_nome) {
        this.namecat = cat_nome;
    }

    public Categorias(Long id_categorias, String cat_nome) {
        this.idcat = id_categorias;
        this.namecat = cat_nome;
    }

    public Categorias() {
    }

    public void findProdutosByCategoryId () {
        System.out.println("Categoria: " + this.namecat);
        System.out.println("Produtos: ");
        this.idprodutos.forEach(x -> System.out.println("\nnome: " + x.getProd_nome() + "\nPreço: " + x.getProd_preco()));
    }
}

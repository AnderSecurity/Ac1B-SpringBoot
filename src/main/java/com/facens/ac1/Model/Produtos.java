package com.facens.ac1.Model;

import jakarta.persistence.*;

@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProd;

    @Column(columnDefinition = "TINYTEXT")
    private String nameprod;

    private double precoprod;

    @ManyToOne
    private Categorias categorias;

    public Integer getId_produtos() {
        return idProd;
    }

    public void setId_produtos(Integer id_produtos) {
        this.idProd = id_produtos;
    }

    public String getProd_nome() {
        return nameprod;
    }

    public void setProd_nome(String prod_nome) {
        this.nameprod = prod_nome;
    }

    public double getProd_preco() {
        return precoprod;
    }

    public void setProd_preco(double prod_preco) {
        this.precoprod = prod_preco;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Produtos(String  prod_nome, double prod_preco, Categorias categorias){
        this.nameprod = prod_nome;
        this.precoprod = prod_preco;
        this.categorias = categorias;
    }

    public Produtos() {
    }
}

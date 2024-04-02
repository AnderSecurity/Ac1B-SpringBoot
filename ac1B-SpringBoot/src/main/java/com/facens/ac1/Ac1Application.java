package com.facens.ac1;

import com.facens.ac1.Controller.CategoriaController;
import com.facens.ac1.Controller.ProdutosController;
import com.facens.ac1.Model.Categorias;
import com.facens.ac1.Model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutosController produtosController, @Autowired CategoriaController categoriaController) {
		return (args) -> {
			Categorias			categoria = new Categorias("Calças");
			Categorias			categoria2 = new Categorias("Camisetas");
			
			categoriaController.save(categoria);
			categoriaController.save(categoria2);

			Produtos			produto = new Produtos("Jeans Longo", 50D, categoria);
			Produtos			produto2 = new Produtos("Camiseta Polo", 100D, categoria2);

			produtosController.save(produto);
			produtosController.save(produto2);

			System.out.println("\nEncontrar todos os produtos pelo id de categoria '1'");
			categoriaController.findCategoryById(1L).findProdutosByCategoryId();
			System.out.println("\n==================================");
			System.out.println("Encontrar todas as categorias que começam com 'Cal'");
			categoriaController.findAllByBeginName("Cal").forEach(x -> System.out.println(x.getId_categorias() + " " + x.getCat_nome() + " "));

			System.out.println("\n==================================");
			System.out.println("Encontrar todos os produtos com o preço maior que '70.00'");
			produtosController.findAllByPriceMoreThan(70D).forEach(x -> System.out.println(x.getProd_nome()));
			System.out.println("\n==================================");
			System.out.println("Encontrar todos os produtos com o preço menor ou igual a '50.00'");
			produtosController.findAllByPriceLessAndEqualThan(50D).forEach(x -> System.out.println(x.getProd_nome()));
			System.out.println("\n==================================");
			System.out.println("Encontrar todos os produtos com o começo de nome 'Cami'");
			produtosController.findAllByBeginName("Cami").forEach(x -> System.out.println(x.getProd_nome()));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}
}

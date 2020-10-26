package com.quarkus.ifood.graphql.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import com.quarkus.ifood.graphql.model.Prato;
import com.quarkus.ifood.graphql.model.Restaurante;

@GraphQLApi
public class PratoAPI {
	
	@Query("buscarPratos")
    @Description("Esta query retorna todos os pratos")
    public List<Prato> bustarTodosPratos() {
        Prato prato = new Prato();
        prato.setNome("feijao");
        prato.setDescricao("prato tipico de algum lugar");
        prato.setValor(BigDecimal.TEN);
        
        
        Prato prato2 = new Prato();
        prato2.setNome("arroz");
        prato2.setDescricao("prato arroz");
        prato2.setValor(BigDecimal.TEN);
        
        
        List<Prato> lista = new ArrayList<>();
        lista.add(prato);
        lista.add(prato2);
        return lista;
    }

    @Query("buscarPratoPorId")
    @Description("Esta query retorna um prato")
    public Prato bustarPrato(@Name("id") Integer id) {
        System.out.println("ID: " + id);
        Prato prato = new Prato();
        prato.setNome("feijao");
        prato.setDescricao("prato tipico de algum lugar");
        prato.setValor(BigDecimal.TEN);
        return prato;
    }

    @Name("restaurante")
    public Restaurante buscarRestaurante(@Source Prato prato) {
    	if ("arroz".equals(prato.getNome())) {
    		return null;
    	}
        Restaurante restaurante = new Restaurante();
        restaurante.setDono("João");
        restaurante.setNome("Manguai");
        return restaurante;
    }

    @Mutation
    @Description("Altera o restaurante")
    public Restaurante alterar(Restaurante restaurante) {
        System.out.println(restaurante.getNome());
        return restaurante;
    }

}

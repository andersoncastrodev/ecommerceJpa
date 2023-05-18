package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Test;

public class CachePrimeiroNivelTeste extends EntityManagerTest {

    @Test
    public void verificarCache(){

        Produto produto = entityManager.find(Produto.class, 1);

        System.out.println(produto.getNome());
        System.out.println("------------------------------------");

        // entityManager.clear(); //-> Obriga o JPA a limpar o cache da memoria.

        //Busca da Memoria , não mas faz uma consulta um outro select
        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());

        System.out.println(produtoResgatado.getNome());
        System.out.println("------------------------------------");


    }
}

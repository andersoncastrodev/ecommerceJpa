package com.algaworks.ecommerce.iniciandocomjpa;


import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador(){

        // o metodo find () busca na hora que o metodo é executado.
       //  Produto produto = entityManager.find(Produto.class, 1);

        // o metodo getReference() busca somento que uma propriedade o objeto for solicitado.
        Produto produto = entityManager.getReference(Produto.class, 1);

        System.out.println("Andia não buscou!");

        Assert.assertNotNull(produto);

       // Assert.assertEquals("Kindle", produto.getNome());

          System.out.println(produto.getNome());

      //  System.out.println(produto.getDescricao());
        System.out.println("Agora buscou!");
    }

    @Test
    public void atualizarReferencia(){

        Produto produto = entityManager.find(Produto.class, 1);

        produto.setNome("Microfone Samson");

        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome() );

    }

}

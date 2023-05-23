package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {



    @Test
    public void inserirPrimeiroObjeto(){
        Produto produto = new Produto();

       // produto.setId(2);
        produto.setNome("Camera Canon");
        produto.setDescricao("A melhor definicao para as fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();

        //Salvando o objeto no banco de dados.
        entityManager.persist(produto);

        entityManager.getTransaction().commit();

        //Limpando os dados que estão na memoria em tempo de execução
        entityManager.clear();

        //Pegar o Produto salvo por ultimo pelo ID.
        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);

        System.out.println(produtoVerificacao.getNome() +" "+ produtoVerificacao.getDescricao() );

    }

    @Test
    public void inserirObjetoComMerge(){
        Produto produto = new Produto();

       // produto.setId(4);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A melhor qualidade de som");
        produto.setPreco(new BigDecimal(10000));

        entityManager.getTransaction().begin();

        //Salvando usando o merger() inveis do persist().
        entityManager.merge(produto);

        entityManager.getTransaction().commit();

        //Limpando os dados que estão na memoria em tempo de execução
        entityManager.clear();

        //Pegar o Produto salvo por ultimo pelo ID.
        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);

        System.out.println(produtoVerificacao.getNome() +" "+ produtoVerificacao.getDescricao() );

    }

    @Test
    public void mostraDiferencaPersistMerge(){
        Produto produtoMerge = new Produto();

       // produtoMerge.setId(5);
        produtoMerge.setNome("SmartPhone One Plus");
        produtoMerge.setDescricao("O processador mais rapido");
        produtoMerge.setPreco(new BigDecimal(25000));

        entityManager.getTransaction().begin();

        //Salvando usando o merger() inveis do persist().
        entityManager.merge(produtoMerge);

        entityManager.getTransaction().commit();

        //Limpando os dados que estão na memoria em tempo de execução
        entityManager.clear();

        //Pegar o Produto salvo por ultimo pelo ID.
        Produto produtoVerificacao = entityManager.find(Produto.class, produtoMerge.getId());

        Assert.assertNotNull(produtoVerificacao);

        System.out.println(produtoVerificacao.getNome() +" "+ produtoVerificacao.getDescricao() );

    }

    @Test
    public void removerObjeto(){

        //Buscando o objeto que sera removindo do banco de dados.
        //O 3 é o ID do regristro no banco de dados.
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();

        //Removendo o produto.
        entityManager.remove(produto);

        entityManager.getTransaction().commit();

    }


    @Test
    public void atualizarObjeto(){

        Produto produto = new Produto();

        //produto.setId(1);

        produto.setNome("Kindle PaperWhite");

        produto.setDescricao("Muda a descricao");

        produto.setPreco(new BigDecimal(500));

        entityManager.getTransaction().begin();

        entityManager.merge(produto);

        entityManager.getTransaction().commit();

        entityManager.clear();


        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        //Fazendo as Verificações
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle PaperWhite",produtoVerificacao.getNome());

    }

    @Test
    public void atualizarObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle PaperWhite 2° Geracao");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        //Fazendo as Verificações
        Assert.assertEquals("Kindle PaperWhite 2° Geracao",produtoVerificacao.getNome());
    }

    @Test
    public void abrirFecharAtrancao(){

        //Abre a transação no JPA
        entityManager.getTransaction().begin();

        // Salvar
     //   entityManager.persist();

        // Alterar
    //    entityManager.merge();

        // Remove
   //     entityManager.remove();

        //Fecha a transação no JPA
        entityManager.getTransaction().commit();
    }
}

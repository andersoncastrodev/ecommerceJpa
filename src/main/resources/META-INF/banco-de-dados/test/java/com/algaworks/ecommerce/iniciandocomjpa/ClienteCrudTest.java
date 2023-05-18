package com.algaworks.ecommerce.iniciandocomjpa;


import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class ClienteCrudTest extends EntityManagerTest {

    //Inserindo um cliente NOVO.
    @Test
    public void inserirCliente(){
        Cliente cliente = new Cliente();

      //  cliente.setId(3);
        cliente.setNome("Jose Lucas");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertNotNull(clienteVerificacao);

        System.out.println(cliente.getId() +" "+ cliente.getNome() );
    }


    //Buscar Cliente por codigo
    @Test
    public void buscarClientePorId(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertNotNull(clienteVerificacao);

        System.out.println(cliente.getId() +" "+ cliente.getNome() );

    }

    //Atualizando um cliente
    @Test
    public void atualizarCliente(){
        Cliente cliente = new Cliente();

     //  cliente.setId(1);
        cliente.setNome("Francisco Roberto XXXXX");

        entityManager.getTransaction().begin();

        entityManager.merge(cliente);

        entityManager.getTransaction().commit();

        entityManager.clear();

       // Cliente clienteVerificacao = entityManager.find(Cliente.class,cliente.getNome());

      //  Assert.assertNotNull("Francisco Roberto XXXXX",clienteVerificacao.getNome());

       System.out.println(cliente.getNome() );
    }

    //Removendo um Cliente
    @Test
    public void removerCliente(){

        //Buscando o Objeto para depois deletar.
        Cliente cliente = entityManager.find(Cliente.class,2);

        entityManager.getTransaction().begin();

        entityManager.remove(cliente);

        entityManager.getTransaction().commit();

        entityManager.clear();

    }
}

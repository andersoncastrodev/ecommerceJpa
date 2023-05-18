package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import org.junit.Test;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test
    public void abrirFecharCancelarTransacao(){

        entityManager.getTransaction().begin();

        //Aqui fica as operações.

        entityManager.getTransaction().commit();
    }
}

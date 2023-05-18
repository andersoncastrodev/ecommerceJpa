package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Test;

public class FlushTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void chamarFlush(){
        try{
            entityManager.getTransaction().begin();

            Pedido pedido = entityManager.find(Pedido.class,1);
            pedido.setStatus(StatusPedido.PAGO);

            entityManager.flush();  // O Flush Obriga o JPA e descarregar tudo que tem na memoria para o banco de dados e força a fazer o update.

            entityManager.getTransaction().commit();

            if (pedido.getPagamento() == null){
                throw  new RuntimeException("Pedido ainda não foi pago.");
            }

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}

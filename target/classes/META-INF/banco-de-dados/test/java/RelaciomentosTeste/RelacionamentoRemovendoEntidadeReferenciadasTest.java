package RelaciomentosTeste;

import com.algaworks.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

public class RelacionamentoRemovendoEntidadeReferenciadasTest extends EntityManagerTest {

    //Testando o Relacionamento Pedido e cliente - Muitos para Um
    @Test
    public void removerEntidadeRelacionada(){

        Pedido pedido = entityManager.find(Pedido.class, 1);

        Assert.assertFalse(pedido.getItemPedidos().isEmpty());

        entityManager.getTransaction().begin();

        //Removendo os Itens do pedido para depois renover o pedido. Usando lambda.
        pedido.getItemPedidos().forEach( i -> entityManager.remove(i) );

        entityManager.remove(pedido);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);
        Assert.assertNotNull(pedidoVerificacao);
    }




}

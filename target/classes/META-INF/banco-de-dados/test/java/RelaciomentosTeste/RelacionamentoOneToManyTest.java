package RelaciomentosTeste;

import com.algaworks.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

    //Testando o Relacionamento Pedido e cliente - Muitos para Um
    @Test
    public void verificarRelacionamento(){

        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();

        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);

        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();

        entityManager.persist(pedido);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificação = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertFalse(clienteVerificação.getPedido().isEmpty());


    }


}

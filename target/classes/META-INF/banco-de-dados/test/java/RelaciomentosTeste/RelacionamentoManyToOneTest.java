package RelaciomentosTeste;

import com.algaworks.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

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

        Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificado.getCliente());


    }

    //Testando o relacionamento ItemPedido e Pedido e Produto - Muitos para Um

    @Test
    public void verificarRelacionamentoItemPedido(){

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);

        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);

        itemPedido.setProduto(produto);

        //Inicio do salvar no banco
        entityManager.getTransaction().begin();

        //Mandando salvar
        entityManager.persist(pedido);
        //Mandando salvar
        entityManager.persist(itemPedido);

        //Salvando de Vez
        entityManager.getTransaction().commit();

        //Limpar a memoria do EntityManager
        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class, itemPedido.getPedido());

        Assert.assertNotNull(itemPedidoVerificacao.getPedido());
        Assert.assertNotNull(itemPedidoVerificacao.getProduto());

    }



}

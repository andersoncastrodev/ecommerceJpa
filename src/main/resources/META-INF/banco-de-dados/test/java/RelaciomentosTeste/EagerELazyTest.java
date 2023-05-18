package RelaciomentosTeste;

import com.algaworks.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verificarComportamento(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

       // pedido.getItemPedidos();
    }




}

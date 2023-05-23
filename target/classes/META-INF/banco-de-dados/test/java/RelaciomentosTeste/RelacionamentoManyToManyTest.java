package RelaciomentosTeste;

import com.algaworks.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RelacionamentoManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){

        Produto produto = entityManager.find(Produto.class,1);
        Categoria categoria = entityManager.find(Categoria.class,1);

        entityManager.getTransaction().begin();

        //Maneira inversa da entidade
      //  categoria.setProdutos(Arrays.asList(produto) );

        //Maneira normal do mapeamento para o mappedby
        produto.setCategorias(Arrays.asList(categoria));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class,categoria.getId());
        Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());



    }




}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ListaSimplesTest {

    @Test
    void deveAdicionarNoInicio(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);

        listaSimples.adicionaInicio(aluno3);

        assertEquals(listaSimples.recuperaElemento(0), aluno3);
    }

    @Test
    void deveAdicionarNoFim(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);

        listaSimples.adicionaFim(aluno3);

        assertEquals(listaSimples.recuperaElemento(listaSimples.size()-1), aluno3);
    }

    @Test
    void deveAdicionarEmUmaPosicaoEspecifica(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);

        listaSimples.adiciona(aluno3, 3);

        assertEquals(listaSimples.recuperaElemento(3), aluno3);
    }

    @Test
    void deveRetornarTrueSeExistirObjeto(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        assert listaSimples.existeDado(aluno3);
    }

    @Test
    void deveRetornarElemento(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        Aluno alunoRecuperado = listaSimples.recuperaElemento(2);

        assertEquals(aluno3, alunoRecuperado);
    }

    @Test
    void deveRemoverDaPosicaoEspecifica(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        listaSimples.remove(1);

        Aluno alunoRecuperado = listaSimples.recuperaElemento(1);

        assert aluno1 != alunoRecuperado;
    }

    @Test
    void deveRemoverDoInicio(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        listaSimples.removeInicio();

        Aluno alunoRecuperado = listaSimples.recuperaElemento(0);

        assert aluno1 != alunoRecuperado;
    }

    @Test
    void deveRemoverDoFim(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        listaSimples.removeFim();

        Aluno alunoRecuperado = listaSimples.recuperaElemento(listaSimples.size()-1);

        assert aluno1 != alunoRecuperado;
    }

    @Test
    void deveRetornarAQuantidadeDeElementosSalvos(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        assertEquals(3, listaSimples.size());
    }

    @Test
    void deveLimparALista(){
        ListaSimples<Aluno> listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno3);

        listaSimples.limpa();

        assertEquals(0, listaSimples.size());
    }
}

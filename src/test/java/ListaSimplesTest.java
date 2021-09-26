import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaSimplesTest {

    @Test
    void deveAdicionarEmUmaPosicaoEspecifica(){
        ListaSimples listaSimples = new ListaSimples<>();

        Aluno aluno1 = new Aluno("Artur", 20);
        Aluno aluno2 = new Aluno("Maria", 25);
        Aluno aluno3 = new Aluno("Joao", 30);

        listaSimples.adicionaFim(aluno1);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adicionaFim(aluno2);
        listaSimples.adiciona(aluno3, 3);

        Celula celula = (Celula) listaSimples.recupera(3);
        Aluno aluno = (Aluno) celula.getElemento();

        assertEquals(aluno.getNome(), aluno3.getNome());
    }
}

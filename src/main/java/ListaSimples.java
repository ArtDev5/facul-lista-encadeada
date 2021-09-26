public class ListaSimples<T> {

    private Celula inicio, fim;
    private int tamanho;

    public ListaSimples() {
        this.inicio = null;
        this.fim = null;
    }

    public ListaSimples(T elemento){
        this.inicio = null;
        this.fim = null;
        adicionaInicio(elemento);
    }

    //validacao
    public void adiciona(T elemento, int posicao){
        if (this.tamanho == 0 || posicao == 0) {
            adicionaInicio(elemento);
        } else if (posicao == tamanho) {
            adicionaFim(elemento);
        } else {
            Celula nova = new Celula(elemento);
            Celula anterior = (Celula) recupera(posicao-1);
            Celula proxima = anterior.getProximo();

            anterior.setProximo(nova);
            nova.setProximo(proxima);
        }
        this.tamanho++;
    }

    public void adicionaInicio(T elemento) {
        Celula nova = new Celula(elemento);

        if (this.tamanho == 0) {
            inicio = fim = nova;
        } else {
            nova.setProximo(inicio);
            inicio = nova;
        }
        this.tamanho++;
    }

    public void adicionaFim(T elemento){
        if (this.tamanho == 0) {
            adicionaInicio(elemento);
        } else {
            Celula nova = new Celula(elemento);
            fim.setProximo(nova);
            fim = nova;
        }
        this.tamanho++;
    }

    public boolean existeDado(T elemento){
        if (this.tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException("Não existe dados na lista");
        } else {
            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()) {
                Celula celula = (Celula) it.getAtual().getElemento();
                if (celula != elemento) {
                    it.next();
                    i++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public T recupera(int posicao) {

        if (this.tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException("Não existe dados na lista");
        } else if (!posicaoOcupada(posicao)) {
            throw new ArrayIndexOutOfBoundsException("A posição " + posicao + " é inválida!");
        } else {

            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()) {
                if (i != posicao) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }

            return (T) it.getAtual();
        }
    }

    public void remove(int posicao){
        if (this.tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException("Lista vazia");
        } else if (!posicaoOcupada(posicao)) {
            throw new ArrayIndexOutOfBoundsException("A posição " + posicao + " é inválida!");
        } else {
            Celula anterior = (Celula) recupera(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();
            anterior.setProximo(proxima);
            tamanho--;
        }
    }

    public void removeInicio() {

        if (this.tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException("Lista vazia");
        } else if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.getProximo();
        }
        this.tamanho--;
    }

    public void removeFim(){
        if (this.tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException("Lista vazia");
        } else {
            fim = null;
            this.tamanho--;
        }
    }

    public int size(){
        return this.tamanho;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }

    public void limpa(){
        Iterador it = new Iterador(this.inicio);
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != null) {
                it.getAtual().setElemento(null);
                i++;
            } else {
                break;
            }
        }
    }
}
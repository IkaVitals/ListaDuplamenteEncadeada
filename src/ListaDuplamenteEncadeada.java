public class ListaDuplamenteEncadeada <T>{

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista = 0;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista =0;
    }

    public T get(int index){

        return this.getNo(index).getConteudo();

    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo!=null){
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
        // a cada elemento novo na lista ele incrmenta mais 1 no atrabito tamnaho lista
    }

    public void add(int index, T elemento){
        // sobracarga do método add, recebe um indice e um elemento to tipo generioco
        NoDuplo<T> noAuxiliar = getNo(index);
        // O no auxiliar vai receber o no que esto passando no idice
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        //criando um objeto chamado novo no
        novoNo.setNoProximo(noAuxiliar);

        if(novoNo.getNoProximo() != null){
            // se o novo no for diferente de nulo
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            // o novo no irá setar o no previo
            novoNo.getNoProximo().setNoPrevio(novoNo);
            // ele desfaz o no encadeado para colocar o novo nó
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;

        }

        if(index == 0){
            primeiroNo = novoNo;
        } else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }

        tamanhoLista++;
    }

    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if(primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if(noAuxiliar != ultimoNo){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            }else{
               ultimoNo = noAuxiliar;
            }

        }

        this.tamanhoLista--;
    }


    private NoDuplo<T> getNo (int index){
        NoDuplo<T> noAuxiliar = primeiroNo;
        // declara que o no auxiliar recebe o primeiro no
        for (int i = 0; (i<index) && (noAuxiliar!=null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        } // equanto o i < indice e no Auxiliar difente de nulo ele continua a lista, quando não for mais verdadeiro ai cheguei na posição

        return noAuxiliar;
    }

    public int size(){
        return tamanhoLista = 0;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]---->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno+="null";
        return strRetorno;
    }
}

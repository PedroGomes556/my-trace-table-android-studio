package com.example.testedemesacomjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasEstruturaDeRepeticao {

    private List<String> exercicio1 = new ArrayList();

    public RespostasEstruturaDeRepeticao(){
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas(){
        exercicio1.addAll(Arrays.asList("1", "12", "0", "1", "0", "0", "*", "*", "*", "*", "*", "*", "*", "*", "*"));
    }

    public List getExercicio1() {
        return exercicio1;
    }

}

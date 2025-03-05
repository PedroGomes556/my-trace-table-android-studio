package com.example.testedemesacomjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasLista {

    private List<String> exercicio1 = new ArrayList();

    public RespostasLista(){
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas(){
        exercicio1.addAll(Arrays.asList("0", "*", "*", "17", "18", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"));
    }

    public List getExercicio1() {
        return exercicio1;
    }

}

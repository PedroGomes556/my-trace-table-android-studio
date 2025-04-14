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
        exercicio1.addAll(Arrays.asList(
                "0", "*", "*",
                "0", "0", "*",
                "2", "0", "*",
                "2", "1", "*",
                "7", "1", "*",
                "7", "1", "8",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));
    }

    public List getExercicio1() {
        return exercicio1;
    }
    public List getExercicio2() {
        return exercicio1;
    }

}



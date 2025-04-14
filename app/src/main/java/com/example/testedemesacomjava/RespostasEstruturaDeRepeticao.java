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
        exercicio1.addAll(Arrays.asList(
                "4", "*", "*",
                "4", "12", "*",
                "4", "12", "2",
                "4", "12", "2",
                "4", "9", "2",
                "4", "9", "2",
                "4", "6", "2",
                "4", "6", "2",
                "4", "3", "2",
                "4", "3", "9"));
    }

    public List getExercicio1() {
        return exercicio1;
    }

}

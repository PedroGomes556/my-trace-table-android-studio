package com.example.testedemesacomjava;

import java.util.ArrayList;
import java.util.List;

public class RespostasCondicionais {

    private List<String> exercicio1 = new ArrayList();

    public RespostasCondicionais(){
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas(){

    }

    public List getExercicio1() {
        return exercicio1;
    }

}

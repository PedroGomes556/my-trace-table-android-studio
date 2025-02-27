package com.example.testedemesacomjava;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasAritmetico {

    private List<String> exercicio1 = new ArrayList();
    private ArrayList<Integer> exercicio2 = new ArrayList();
    private ArrayList<Integer> exercicio3 = new ArrayList();
    private ArrayList<Integer> exercicio4= new ArrayList();
    private ArrayList<Integer> exercicio5 = new ArrayList();
    private ArrayList<Integer> exercicio6 = new ArrayList();


    public RespostasAritmetico(){
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas(){
      exercicio1.addAll(Arrays.asList("3", "*", "*", "3", "27", "*", "3", "27", "10", "1", "27", "10", "1", "27", "17"));
    }

    public List getExercicio1() {
        return exercicio1;
    }
}

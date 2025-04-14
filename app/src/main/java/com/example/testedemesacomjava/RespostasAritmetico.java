package com.example.testedemesacomjava;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasAritmetico {

    private List<String> exercicio1 = new ArrayList();
    private List<String> exercicio2 = new ArrayList();
    private List<String> exercicio3 = new ArrayList();


    public RespostasAritmetico(){
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas(){
      exercicio1.addAll(Arrays.asList(
              "3", "*", "*",
              "3", "27", "*",
              "3", "27", "10",
              "1", "27", "10",
              "1", "27", "17",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*"));
      exercicio2.addAll(Arrays.asList(
              "*", "*", "49",
              "7", "*", "49",
              "7", "4", "49",
              "7", "4", "9",
              "64", "4", "9",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*"));
      exercicio3.addAll(Arrays.asList(
              "*", "8", "*",
              "*", "8", "3",
              "5", "8", "3",
              "5", "6", "3",
              "5", "6", "11",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*",
              "*", "*", "*"));
    }

    public List getExercicio1() {
        return exercicio1;
    }

    public List getExercicio2() {
        return exercicio2;
    }

    public List getExercicio3() {
        return exercicio3;
    }
}

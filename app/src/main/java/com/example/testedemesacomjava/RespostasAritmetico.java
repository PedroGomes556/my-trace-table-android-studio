package com.example.testedemesacomjava;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasAritmetico {

    private List<Integer> exercicio1 = new ArrayList();
    private ArrayList<Integer> exercicio2 = new ArrayList();
    private ArrayList<Integer> exercicio3 = new ArrayList();
    private ArrayList<Integer> exercicio4= new ArrayList();
    private ArrayList<Integer> exercicio5 = new ArrayList();
    private ArrayList<Integer> exercicio6 = new ArrayList();

    private void populaRespostas(){
        exercicio1 = Arrays.asList(3, null, null, 3, 27, null, 3, 27, 10, 1, 27, 10, 1, 27, 17);

    }

    public List getExercicio1() {
        return exercicio1;
    }
}

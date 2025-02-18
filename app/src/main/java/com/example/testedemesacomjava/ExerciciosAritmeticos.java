package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExerciciosAritmeticos extends AppCompatActivity {

    public String tipoExercicio = null;
    public TextView textTituloMenu = null;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_exercicios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tipoExercicio = getIntent().getStringExtra("tipoExercicio");
        textTituloMenu = findViewById(R.id.id_text_legenda);
        DefineTituloDoMenu();

    }

    public void DefineTituloDoMenu(){
        if(tipoExercicio.equals("condicional")){
            textTituloMenu.setText("ESTRUTURAS CONDICIONAIS");
        }else if (tipoExercicio.equals("repeticao")) {
            textTituloMenu.setText("ESTRUTURAS DE REPETIÇÃO");
        }else if (tipoExercicio.equals("aritimetico")){
            textTituloMenu.setText("OPERADORES ARITMÉTICOS");
        }else if(tipoExercicio.equals("listas")){
            textTituloMenu.setText("LISTAS");
        }
    }

    public void IniciarExercicio1(View view){
        Intent intent = new Intent(this, ExercicioAritmetico.class);
        intent.putExtra("numeroExercicio", "1");
        startActivity(intent);
    }
    public void IniciarExercicio2(View view){
        Intent intent = new Intent(this, ExercicioAritmetico.class);
        intent.putExtra("numeroExercicio", "2");
        startActivity(intent);
    }
    public void IniciarExercicio3(View view){
        Intent intent = new Intent(this, ExercicioAritmetico.class);
        intent.putExtra("numeroExercicio", "3");
        startActivity(intent);
    }
    public void IniciarExercicio4(View view){
        Intent intent = new Intent(this, ExercicioAritmetico.class);
        intent.putExtra("numeroExercicio", "4");
        startActivity(intent);
    }
    public void IniciarExercicio5(View view){
        Intent intent = new Intent(this, ExercicioAritmetico.class);
        intent.putExtra("numeroExercicio", "5");
        startActivity(intent);
    }
    public void IniciarExercicio6(View view){
        Intent intent = new Intent(this, ExercicioAritmetico.class);
        intent.putExtra("numeroExercicio", "6");
        startActivity(intent);
    }

}
package com.example.testedemesacomjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuExercicio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_exercicios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Condicionais(View view){
        Intent intent = new Intent(this, ExerciciosAritmeticos.class);
        intent.putExtra("tipoExercicio", "condicional");
        startActivity(intent);
    }

    public void EstruturaRepeticao(View view){
        Intent intent = new Intent(this, ExerciciosAritmeticos.class);
        intent.putExtra("tipoExercicio", "repeticao");
        startActivity(intent);
    }

    public void OperadoresAritmeticos(View view){
        Intent intent = new Intent(this, ExerciciosAritmeticos.class);
        intent.putExtra("tipoExercicio", "aritimetico");
        startActivity(intent);
    }

    public void Listas(View view){
        Intent intent = new Intent(this, ExerciciosAritmeticos.class);
        intent.putExtra("tipoExercicio", "listas");
        startActivity(intent);
    }

}
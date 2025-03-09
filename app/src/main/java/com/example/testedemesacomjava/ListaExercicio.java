package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListaExercicio extends AppCompatActivity {

    public String tipoExercicio = null;
    public TextView textTituloMenu = null;
    public Button buttonExercicio1;
    public Button buttonExercicio2;
    public Button buttonExercicio3;
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

        // Ativa a Toolbar como ActionBar para suportar o menu
        // Configura a Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarListaExercicio);
        setSupportActionBar(toolbar);

        // Altera a cor do ícone de overflow (três pontinhos)
        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setTint(Color.BLACK); // Troque Color.BLACK pela cor desejada
        }

        tipoExercicio = getIntent().getStringExtra("tipoExercicio");
        textTituloMenu = findViewById(R.id.id_text_legenda);
        buttonExercicio1 = findViewById(R.id.button_exercicio1);
        buttonExercicio2= findViewById(R.id.button_exercicio2);
        buttonExercicio3 = findViewById(R.id.button_exercicio3);

        //APENAS O TIPO DE EXERCÍCIO DE OPERADORES ARITMÉTICOS POSSUI 3 EXERCÍCIOS
        if(!tipoExercicio.equals("aritmetico")){
            buttonExercicio2.setVisibility(View.INVISIBLE);
            buttonExercicio3.setVisibility(View.INVISIBLE);
        }else{
            buttonExercicio2.setVisibility(View.VISIBLE);
            buttonExercicio3.setVisibility(View.VISIBLE);
        }
        DefineTituloDoMenu();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // Adicione ação para o item do menu
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void DefineTituloDoMenu(){
        if(tipoExercicio.equals("condicional")){
            textTituloMenu.setText("ESTRUTURAS CONDICIONAIS");
        }else if (tipoExercicio.equals("repeticao")) {
            textTituloMenu.setText("ESTRUTURAS DE REPETIÇÃO");
        }else if (tipoExercicio.equals("aritmetico")){
            textTituloMenu.setText("OPERADORES ARITMÉTICOS");
        }else if(tipoExercicio.equals("listas")){
            textTituloMenu.setText("LISTAS");
        }
    }

    public void IniciarExercicio1(View view){
        Intent intent = new Intent(this, Exercicio.class);
        intent.putExtra("numeroExercicio", "1");
        intent.putExtra("tipoExercicio", tipoExercicio);
        startActivity(intent);
    }
    public void IniciarExercicio2(View view){
        Intent intent = new Intent(this, Exercicio.class);
        intent.putExtra("numeroExercicio", "2");
        intent.putExtra("tipoExercicio", tipoExercicio);
        startActivity(intent);
    }
    public void IniciarExercicio3(View view){
        Intent intent = new Intent(this, Exercicio.class);
        intent.putExtra("numeroExercicio", "3");
        intent.putExtra("tipoExercicio", tipoExercicio);
        startActivity(intent);
    }


}
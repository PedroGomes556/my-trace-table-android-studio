package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spanString = new SpannableString(item.getTitle().toString());
            spanString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spanString.length(), 0); // Cor do texto
            item.setTitle(spanString);
        }
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.action_menu_principal) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_menu_exercicios){
            intent = new Intent(this, MenuExercicio.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_ajuda) {
            intent = new Intent(this, AjudaActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_sobre) {
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_sair){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Fechar Aplicativo");
            builder.setMessage("Deseja realmente sair do aplicativo?");
            builder.setPositiveButton("Sim", (dialog, which) -> {
                ((Activity) this).finishAffinity(); // Fecha o app
            });
            builder.setNegativeButton("Não", (dialog, which) -> dialog.dismiss());

            // Criar o diálogo
            AlertDialog alertDialog = builder.create();

            // Mostrar o diálogo e mudar a cor de fundo
            alertDialog.setOnShowListener(dialog -> {
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(
                        ContextCompat.getColor(this, R.color.background_button_color)
                ));
            });
            alertDialog.show();
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
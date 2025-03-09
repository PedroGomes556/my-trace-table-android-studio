package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;



import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MenuExercicio extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @SuppressLint("MissingInflatedId")
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

        // Ativa a Toolbar como ActionBar para suportar o menu
        // Configura a Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Altera a cor do ícone de overflow (três pontinhos)
        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setTint(Color.BLACK); // Troque Color.BLACK pela cor desejada
        }

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

    public void Condicionais(View view){
        Intent intent = new Intent(this, ListaExercicio.class);
        intent.putExtra("tipoExercicio", "condicional");
        startActivity(intent);
    }

    public void EstruturaRepeticao(View view){
        Intent intent = new Intent(this, ListaExercicio.class);
        intent.putExtra("tipoExercicio", "repeticao");
        startActivity(intent);
    }

    public void OperadoresAritmeticos(View view){
        Intent intent = new Intent(this, ListaExercicio.class);
        intent.putExtra("tipoExercicio", "aritmetico");
        startActivity(intent);
    }

    public void Listas(View view){
        Intent intent = new Intent(this, ListaExercicio.class);
        intent.putExtra("tipoExercicio", "listas");
        startActivity(intent);
    }

}
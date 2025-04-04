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



import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MenuExercicio extends AppCompatActivity {

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
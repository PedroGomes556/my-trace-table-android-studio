package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AjudaActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajuda);
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
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_menu_exercicios){
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_ajuda) {
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_sobre) {
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_sair){
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
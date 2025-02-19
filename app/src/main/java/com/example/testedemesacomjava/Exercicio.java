package com.example.testedemesacomjava;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio extends AppCompatActivity {

    private String numeroExercicio = null;
    private TextView textTituloMenu = null;
    private String tipoExercicio = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_exercicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //RECUPERANDO INTENT
        numeroExercicio = getIntent().getStringExtra("numeroExercicio");
        tipoExercicio = getIntent().getStringExtra("tipoExercicio");
        textTituloMenu = findViewById(R.id.id_numero_exercicio);

        DefineNumeroExercicio();

        Button btnToast = findViewById(R.id.button31);
        btnToast.setOnClickListener(v -> {
            VerificaResposta();
            if(isAcertouTudo()){
                Toast.makeText(Exercicio.this, "Resposta correta!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Exercicio.this, "Resposta incorreta, tente novamente!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void DefineNumeroExercicio(){
        if(numeroExercicio.equals("1")){
            textTituloMenu.setText("EXERCÍCIO 1");
        }else if (numeroExercicio.equals("2")) {
            textTituloMenu.setText("EXERCÍCIO 2");
        }else if (numeroExercicio.equals("3")){
            textTituloMenu.setText("EXERCÍCIO 3");
        }else if(numeroExercicio.equals("4")){
            textTituloMenu.setText("EXERCÍCIO 4");
        }else if(numeroExercicio.equals("5")) {
            textTituloMenu.setText("EXERCÍCIO 5");
        }else{
            textTituloMenu.setText("EXERCÍCIO 6");
        }
    }


    boolean acertouTudo = true;

    public boolean isAcertouTudo(){
        return acertouTudo;
    }

    public void VerificaResposta(){
        EditText campo1 = findViewById(R.id.editTextNumber19346345688);
        EditText campo4 = findViewById(R.id.editTextNumber196767834243588);
        EditText campo7 = findViewById(R.id.editTextNumber11);
        if(!campo1.getText().toString().equals("3") || !campo4.getText().toString().equals("3")
                || !campo7.getText().toString().equals("3")){
            acertouTudo = false;
            campo1.setTextColor(Color.RED);
            campo4.setTextColor(Color.RED);
            campo7.setTextColor(Color.RED);
        }else{
            campo1.setTextColor(Color.GREEN);
            campo4.setTextColor(Color.GREEN);
            campo7.setTextColor(Color.GREEN);
        }

        EditText campo5 = findViewById(R.id.editTextNumber1855dsd123123435456);
        EditText campo8 = findViewById(R.id.editTextNumber12);
        EditText campo11 = findViewById(R.id.editTextNumber1554742);
        EditText campo14 = findViewById(R.id.editTextNumber185sd5);
        if(!campo5.getText().toString().equals("27") || !campo8.getText().toString().equals("27")
                    || !campo11.getText().toString().equals("27") || !campo14.getText().toString().equals("27")){
            acertouTudo = false;
            campo5.setTextColor(Color.RED);
            campo8.setTextColor(Color.RED);
            campo11.setTextColor(Color.RED);
            campo14.setTextColor(Color.RED);
        }else{
            campo5.setTextColor(Color.GREEN);
            campo8.setTextColor(Color.GREEN);
            campo11.setTextColor(Color.GREEN);
            campo14.setTextColor(Color.GREEN);
        }

        EditText campo9 = findViewById(R.id.editTextNumber13);
        EditText campo12 = findViewById(R.id.editTextNumber1665);
        if(!campo9.getText().toString().equals("10") || !campo12.getText().toString().equals("10")){
            acertouTudo = false;
            campo9.setTextColor(Color.RED);
            campo12.setTextColor(Color.RED);
        }else{
            campo9.setTextColor(Color.GREEN);
            campo12.setTextColor(Color.GREEN);
        }

        EditText campo10 = findViewById(R.id.editTextNumber14874);
        EditText campo13 = findViewById(R.id.editTextNumber1988dff);
        if(!campo10.getText().toString().equals("1") || (!campo13.getText().toString().equals("1"))){
            acertouTudo = false;
            campo10.setTextColor(Color.RED);
            campo13.setTextColor(Color.RED);
        }else{
            campo10.setTextColor(Color.GREEN);
            campo13.setTextColor(Color.GREEN);
        }

        EditText campo16 = findViewById(R.id.editTextNumberasd1777);
        if(!campo16.getText().toString().equals("17")){
            acertouTudo = false;
            campo16.setTextColor(Color.RED);
        }else{
            campo16.setTextColor(Color.GREEN);
        }



    }

}
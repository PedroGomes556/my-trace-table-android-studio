package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio extends AppCompatActivity {

    EditText campo1, campo2, campo3, campo4, campo5,
            campo6, campo7, campo8, campo9, campo10, campo11, campo12, campo13, campo14, campo15;
    private String numeroExercicio = null;
    private TextView textTituloMenu = null;
    private String tipoExercicio = null;
    private Button buttonTentarDenovo;
    private Button buttonRetornarMenuExercicio;
    private Button buttonVerificarRestposta;
    boolean acertouTudo = true;

    List<String> respostaUsuario = new ArrayList<String>();
    @SuppressLint("MissingInflatedId")
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

        campo1 = findViewById(R.id.editTextNumber1);
        campo2 = findViewById(R.id.editTextNumber2);
        campo3 = findViewById(R.id.editTextNumber3);
        campo4 = findViewById(R.id.editTextNumber4);
        campo5 = findViewById(R.id.editTextNumber5);
        campo6 = findViewById(R.id.editTextNumber6);
        campo7 = findViewById(R.id.editTextNumber11);
        campo8 = findViewById(R.id.editTextNumber8);
        campo9 = findViewById(R.id.editTextNumber9);
        campo10 = findViewById(R.id.editTextNumber10);
        campo11 = findViewById(R.id.editTextNumber11);
        campo12 = findViewById(R.id.editTextNumber12);
        campo13 = findViewById(R.id.editTextNumber13);
        campo15 = findViewById(R.id.editTextNumber14);
        campo15 = findViewById(R.id.editTextNumber15);

        //RECUPERANDO INTENT
        numeroExercicio = getIntent().getStringExtra("numeroExercicio");
        tipoExercicio = getIntent().getStringExtra("tipoExercicio");
        textTituloMenu = findViewById(R.id.id_numero_exercicio);

        Toast.makeText(Exercicio.this, tipoExercicio, Toast.LENGTH_SHORT).show();

        buttonRetornarMenuExercicio = findViewById(R.id.buttonMenuExercicios);
        buttonRetornarMenuExercicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuExercicio.class);
            startActivity(intent);
        });

        buttonTentarDenovo = findViewById(R.id.buttonTentarNovamente);
        buttonTentarDenovo.setOnClickListener(v -> {
            buttonVerificarRestposta.setClickable(true);
            buttonVerificarRestposta.setVisibility(View.VISIBLE);

            buttonRetornarMenuExercicio.setVisibility(View.INVISIBLE);
            buttonRetornarMenuExercicio.setClickable(false);
            buttonTentarDenovo.setVisibility(View.INVISIBLE);
            buttonTentarDenovo.setClickable(false);


        });

        DefineNumeroExercicio();

        buttonVerificarRestposta = findViewById(R.id.button31);
        buttonVerificarRestposta.setOnClickListener(v -> {
            VerificaResposta();
            if(isAcertouTudo()){
                Toast.makeText(Exercicio.this, "Resposta correta!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Exercicio.this, "Resposta incorreta, tente novamente!", Toast.LENGTH_SHORT).show();
                buttonVerificarRestposta.setClickable(false);
                buttonVerificarRestposta.setVisibility(View.INVISIBLE);

                buttonRetornarMenuExercicio.setVisibility(View.VISIBLE);
                buttonRetornarMenuExercicio.setClickable(true);
                buttonTentarDenovo.setVisibility(View.VISIBLE);
                buttonTentarDenovo.setClickable(true);
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


    private void limparCampos(){
        campo1.setText("");
        //campo2.setText("");
        //campo3.setText("");
        campo4.setText("");
        campo5.setText("");
        //campo6.setText("");
        campo7.setText("");
        campo8.setText("");
        campo9.setText("");
        campo10.setText("");
        campo11.setText("");
        campo12.setText("");
        campo13.setText("");
        campo14.setText("");
        campo15.setText("");
    }


    public boolean isAcertouTudo(){
        return acertouTudo;
    }

    public void VerificaResposta() {
        respostaUsuario = Arrays.asList(campo1.getText().toString(), campo2.getText().toString(), campo3.getText().toString(), campo4.getText().toString()
                , campo5.getText().toString(), campo6.getText().toString(), campo7.getText().toString(), campo8.getText().toString(),
                campo9.getText().toString(), campo10.getText().toString(), campo11.getText().toString(), campo12.getText().toString()
                , campo13.getText().toString(), campo14.getText().toString(), campo15.getText().toString());

        Toast.makeText(Exercicio.this, respostaUsuario.toString(), Toast.LENGTH_SHORT).show();
        if (tipoExercicio.equals("aritmetico")) {
            RespostasAritmetico respostasAritmetico = new RespostasAritmetico();
            if (numeroExercicio.equals("1")) {

            }
        }
    }
}
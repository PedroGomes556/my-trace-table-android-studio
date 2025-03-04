package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    List<String> respostaUsuario = new ArrayList<>();

    List<EditText> campos = new ArrayList<>();

    RespostasAritmetico respostasAritmetico = new RespostasAritmetico();
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
        campo7 = findViewById(R.id.editTextNumber7);
        campo8 = findViewById(R.id.editTextNumber8);
        campo9 = findViewById(R.id.editTextNumber9);
        campo10 = findViewById(R.id.editTextNumber10);
        campo11 = findViewById(R.id.editTextNumber11);
        campo12 = findViewById(R.id.editTextNumber12);
        campo13 = findViewById(R.id.editTextNumber13);
        campo14 = findViewById(R.id.editTextNumber14);
        campo15 = findViewById(R.id.editTextNumber15);

        campos = Arrays.asList(
                campo1, campo2, campo3, campo4, campo5,
                campo6, campo7, campo8, campo9, campo10,
                campo11, campo12, campo13, campo14, campo15
        );


        //RECUPERANDO INTENT
        numeroExercicio = getIntent().getStringExtra("numeroExercicio");
        tipoExercicio = getIntent().getStringExtra("tipoExercicio");
        textTituloMenu = findViewById(R.id.id_numero_exercicio);

        Toast.makeText(Exercicio.this, tipoExercicio, Toast.LENGTH_SHORT).show();
        Toast.makeText(Exercicio.this, numeroExercicio, Toast.LENGTH_SHORT).show();

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

            limparCampos();
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


        bloqueaCampos();
    }

    public void bloqueaCampos(){
        //Indica que o campo deve ficar bloqueado, pois a variável não existe
        for (int i = 0; i < respostasAritmetico.getExercicio1().size(); i++) {
            if (respostasAritmetico.getExercicio1().get(i).equals("*")){
                campos.get(i).setFocusable(false);
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado));
            }

        }
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

    public void limparCampos(){
        for (int i = 0; i < campos.size(); i++){
            //Limpar apenas os campos que não estejam bloqueados
            if (!respostasAritmetico.getExercicio1().get(i).equals("*")){
                campos.get(i).setFocusable(true);
                campos.get(i).setFocusableInTouchMode(true);
                campos.get(i).setText("");
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_branco));
                campos.get(i).setTextColor(Color.BLACK);
            }
        }
    }

    public boolean isAcertouTudo(){
        return acertouTudo;
    }

    public void getResposta(){
        respostaUsuario.add(0, campo1.getText().toString());
        respostaUsuario.add(1, campo2.getText().toString());
        respostaUsuario.add(2, campo3.getText().toString());
        respostaUsuario.add(3, campo4.getText().toString());
        respostaUsuario.add(4, campo5.getText().toString());
        respostaUsuario.add(5, campo6.getText().toString());
        respostaUsuario.add(6, campo7.getText().toString());
        respostaUsuario.add(7, campo8.getText().toString());
        respostaUsuario.add(8, campo9.getText().toString());
        respostaUsuario.add(9, campo10.getText().toString());
        respostaUsuario.add(10, campo11.getText().toString());
        respostaUsuario.add(11, campo12.getText().toString());
        respostaUsuario.add(12, campo13.getText().toString());
        respostaUsuario.add(13, campo14.getText().toString());
        respostaUsuario.add(14, campo15.getText().toString());
    }

    public void VerificaResposta() {


        getResposta();
        campos = Arrays.asList(
                campo1, campo2, campo3, campo4, campo5,
                campo6, campo7, campo8, campo9, campo10,
                campo11, campo12, campo13, campo14, campo15
        );

        //Toast.makeText(Exercicio.this, respostaUsuario.toString(), Toast.LENGTH_SHORT).show();
        if (tipoExercicio.equals("aritmetico")) {
            if (numeroExercicio.equals("1")) {
                //Toast.makeText(Exercicio.this, "ENTROUUU", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < respostasAritmetico.getExercicio1().size(); i++) {
                    String respostaCorreta = respostasAritmetico.getExercicio1().get(i).toString();
                    String respostaDoUsuario = respostaUsuario.get(i);

                    if (respostaCorreta.equals(respostaDoUsuario) && !respostasAritmetico.getExercicio1().get(i).equals("*")) {
                        campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_verde_claro));
                        campos.get(i).setFocusable(false);
                        campos.get(i).setTextColor(Color.parseColor("#006400"));
                    } else if (!respostaCorreta.equals(respostaDoUsuario) && !respostasAritmetico.getExercicio1().get(i).equals("*")){
                        acertouTudo = false;
                        campos.get(i).setFocusable(false);
                        campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_vermelho));
                        campos.get(i).setTextColor(Color.RED);
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            VibrationEffect effect = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE);
                            vibrator.vibrate(effect);
                        } else {
                            vibrator.vibrate(500);
                        }


                    }
                }

            }
        }
    }

}
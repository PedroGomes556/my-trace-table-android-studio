package com.example.testedemesacomjava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

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

    private EditText legendaLinha1, legendaLinha2, legendaLinha3, legendaLinha4, legendaLinha5;


    private EditText legendaVariavel1, legendaVariavel2, legendaVariavel3;
    private ImageView imagemExercicio;

    List<String> respostaUsuario = new ArrayList<>();

    List<EditText> campos = new ArrayList<>();

    RespostasAritmetico respostasAritmetico = new RespostasAritmetico();
    RespostasCondicionais respostasCondicionais = new RespostasCondicionais();
    RespostasLista respostasLista = new RespostasLista();
    RespostasEstruturaDeRepeticao respostasEstruturaDeRepeticao = new RespostasEstruturaDeRepeticao();

    MediaPlayer mediaPlayer;


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

       /* Toast.makeText(Exercicio.this, tipoExercicio, Toast.LENGTH_SHORT).show();
        Toast.makeText(Exercicio.this, numeroExercicio, Toast.LENGTH_SHORT).show();*/

        imagemExercicio = findViewById(R.id.imageView_Exercicio);
        legendaLinha1 = findViewById(R.id.linha1);
        legendaLinha2 = findViewById(R.id.linha2);
        legendaLinha3 = findViewById(R.id.linha3);
        legendaLinha4 = findViewById(R.id.linha4);
        legendaLinha5 = findViewById(R.id.linha5);

        legendaVariavel1 = findViewById(R.id.lengendaVariavel1);
        legendaVariavel2 = findViewById(R.id.lengendaVariavel2);
        legendaVariavel3 = findViewById(R.id.lengendaVariavel3);

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

            if (tipoExercicio.equals("aritmetico")) {
                if (numeroExercicio.equals("1")) {
                    limparCampos(respostasAritmetico.getExercicio1());
                } else if (numeroExercicio.equals("2")) {
                    limparCampos(respostasAritmetico.getExercicio2());
                } else {
                    limparCampos(respostasAritmetico.getExercicio3());
                }
            } else if (tipoExercicio.equals("condicional")) {
                limparCampos(respostasCondicionais.getExercicio1());
            } else if (tipoExercicio.equals("repeticao")) {
                limparCampos(respostasEstruturaDeRepeticao.getExercicio1());
            } else {
                limparCampos(respostasLista.getExercicio1());
            }
        });

        DefineNumeroExercicio();

        buttonVerificarRestposta = findViewById(R.id.button31);
        buttonVerificarRestposta.setOnClickListener(v -> {
            VerificaResposta();
            if (isAcertouTudo()) {
                //Toast.makeText(Exercicio.this, "Resposta correta!", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                // Inflar o layout personalizado
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogView = inflater.inflate(R.layout.dialog_text_image, null);


                builder.setView(dialogView);

                AlertDialog dialog = builder.create();
                dialog.show();

                // Fechar automaticamente após 2 segundos (2000ms)
                new Handler().postDelayed(dialog::dismiss, 3000);
                mediaPlayer = MediaPlayer.create(this, R.raw.success);
                mediaPlayer.start();


            } else {
                //Toast.makeText(Exercicio.this, "Resposta incorreta, tente novamente!", Toast.LENGTH_SHORT).show();
                buttonVerificarRestposta.setClickable(false);
                buttonVerificarRestposta.setVisibility(View.INVISIBLE);

                buttonRetornarMenuExercicio.setVisibility(View.VISIBLE);
                buttonRetornarMenuExercicio.setClickable(true);
                buttonTentarDenovo.setVisibility(View.VISIBLE);
                buttonTentarDenovo.setClickable(true);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                // Inflar o layout personalizado
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogView = inflater.inflate(R.layout.dialog_text_image_sad, null);


                builder.setView(dialogView);

                AlertDialog dialog = builder.create();
                dialog.show();

                // Fechar automaticamente após 2 segundos (2000ms)
                new Handler().postDelayed(dialog::dismiss, 3000);
            }
        });

        if (tipoExercicio.equals("aritmetico")) {
            if (numeroExercicio.equals("1")) {
                imagemExercicio.setImageResource(R.drawable.aritmetico_exercicio1);
                bloqueaCampos(respostasAritmetico.getExercicio1());
                limparCampos(respostasAritmetico.getExercicio1());
            } else if (numeroExercicio.equals("2")) {
                imagemExercicio.setImageResource(R.drawable.aritmetico_exercicio2);
                bloqueaCampos(respostasAritmetico.getExercicio2());
                limparCampos(respostasAritmetico.getExercicio2());
            } else {
                imagemExercicio.setImageResource(R.drawable.aritmetico_exercicio3);
                bloqueaCampos(respostasAritmetico.getExercicio3());
                limparCampos(respostasAritmetico.getExercicio3());
            }
        } else if (tipoExercicio.equals("condicional")) {
            //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
            legendaLinha4.setVisibility(View.INVISIBLE);
            legendaLinha5.setVisibility(View.INVISIBLE);
            campo10.setVisibility(View.INVISIBLE);
            campo11.setVisibility(View.INVISIBLE);
            campo12.setVisibility(View.INVISIBLE);
            campo13.setVisibility(View.INVISIBLE);
            campo14.setVisibility(View.INVISIBLE);
            campo15.setVisibility(View.INVISIBLE);

            //MUDANDO O NÚMERO DA LINHA
            legendaLinha2.setText("6");
            legendaLinha3.setText("7");

            imagemExercicio.setImageResource(R.drawable.condicional_exercicio1);
            bloqueaCampos(respostasCondicionais.getExercicio1());
            limparCampos(respostasCondicionais.getExercicio1());
        } else if (tipoExercicio.equals("repeticao")) {
            //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
            legendaLinha3.setVisibility(View.INVISIBLE);
            legendaLinha4.setVisibility(View.INVISIBLE);
            legendaLinha5.setVisibility(View.INVISIBLE);
            campo7.setVisibility(View.INVISIBLE);
            campo8.setVisibility(View.INVISIBLE);
            campo9.setVisibility(View.INVISIBLE);
            campo10.setVisibility(View.INVISIBLE);
            campo11.setVisibility(View.INVISIBLE);
            campo12.setVisibility(View.INVISIBLE);
            campo13.setVisibility(View.INVISIBLE);
            campo14.setVisibility(View.INVISIBLE);
            campo15.setVisibility(View.INVISIBLE);

            //MUDANDO O NÚMERO DA LINHA
            legendaLinha1.setText("3");
            legendaLinha2.setText("6");

            imagemExercicio.setImageResource(R.drawable.estrutura_de_repeticao_exercicio1);
            bloqueaCampos(respostasEstruturaDeRepeticao.getExercicio1());
            limparCampos(respostasEstruturaDeRepeticao.getExercicio1());
        } else {
            //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
            legendaLinha3.setVisibility(View.INVISIBLE);
            legendaLinha4.setVisibility(View.INVISIBLE);
            legendaLinha5.setVisibility(View.INVISIBLE);
            campo7.setVisibility(View.INVISIBLE);
            campo8.setVisibility(View.INVISIBLE);
            campo9.setVisibility(View.INVISIBLE);
            campo10.setVisibility(View.INVISIBLE);
            campo11.setVisibility(View.INVISIBLE);
            campo12.setVisibility(View.INVISIBLE);
            campo13.setVisibility(View.INVISIBLE);
            campo14.setVisibility(View.INVISIBLE);
            campo15.setVisibility(View.INVISIBLE);

            //EXCLUINDO A COLUNA 2
            campo3.setVisibility(View.GONE);
            campo6.setVisibility(View.GONE);
            legendaVariavel2.setVisibility(View.GONE);

            //MUDANDO O NÚMERO DA LINHA
            legendaLinha1.setText("2");
            legendaLinha2.setText("5");

            imagemExercicio.setImageResource(R.drawable.lista_exercicio1);
            bloqueaCampos(respostasLista.getExercicio1());
            limparCampos(respostasLista.getExercicio1());
        }


    }

    public void bloqueaCampos(List<String> resposta) {

        //Indica que o campo deve ficar bloqueado, pois a variável não existe
        for (int i = 0; i < resposta.size(); i++) {
            if (resposta.get(i).equals("*")) {
                campos.get(i).setFocusable(false);
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado));
            }

        }
    }

    public void DefineNumeroExercicio() {
        if (numeroExercicio.equals("1")) {
            textTituloMenu.setText("EXERCÍCIO 1");
        } else if (numeroExercicio.equals("2")) {
            textTituloMenu.setText("EXERCÍCIO 2");
        } else if (numeroExercicio.equals("3")) {
            textTituloMenu.setText("EXERCÍCIO 3");
        } else if (numeroExercicio.equals("4")) {
            textTituloMenu.setText("EXERCÍCIO 4");
        } else if (numeroExercicio.equals("5")) {
            textTituloMenu.setText("EXERCÍCIO 5");
        } else {
            textTituloMenu.setText("EXERCÍCIO 6");
        }
    }

    public void limparCampos(List<String> resposta) {
        for (int i = 0; i < campos.size(); i++) {
            //Limpar apenas os campos que não estejam bloqueados
            if (!resposta.get(i).equals("*")) {
                campos.get(i).setFocusable(true);
                campos.get(i).setFocusableInTouchMode(true);
                campos.get(i).setText("");
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_branco));
                campos.get(i).setTextColor(Color.BLACK);
            }
        }
    }

    public boolean isAcertouTudo() {
        return acertouTudo;
    }

    public void getResposta() {
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

    public void VerificarResposta(List<String> resposta) {
        acertouTudo = true;
        for (int i = 0; i < resposta.size(); i++) {
            String respostaCorreta = resposta.get(i).toString();
            String respostaDoUsuario = respostaUsuario.get(i);

            if (respostaCorreta.equals(respostaDoUsuario) && !resposta.get(i).equals("*")) {
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_verde_claro));
                campos.get(i).setFocusable(false);
                campos.get(i).setTextColor(Color.parseColor("#006400"));
            } else if (!respostaCorreta.equals(respostaDoUsuario) && !resposta.get(i).equals("*")) {
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
                VerificarResposta(respostasAritmetico.getExercicio1());
            } else if (numeroExercicio.equals("2")) {
                VerificarResposta(respostasAritmetico.getExercicio2());
            } else {
                VerificarResposta(respostasAritmetico.getExercicio3());
            }
        } else if (tipoExercicio.equals("condicional")) {
            VerificarResposta(respostasCondicionais.getExercicio1());
        } else if (tipoExercicio.equals("repeticao")) {
            VerificarResposta(respostasEstruturaDeRepeticao.getExercicio1());
        } else {
            VerificarResposta(respostasLista.getExercicio1());
        }
    }



}
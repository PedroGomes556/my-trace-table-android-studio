package com.example.testedemesacomjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toolbar;

import com.example.testedemesacomjava.ui.gallery.GalleryFragment;
import com.example.testedemesacomjava.ui.gallery.GalleryViewModel;
import com.example.testedemesacomjava.ui.home.HomeFragment;
import com.example.testedemesacomjava.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testedemesacomjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar2);

        // Verifica se o Overflow Menu (três pontinhos) existe e altera a cor para preto
        if (binding.appBarMain.toolbar2.getOverflowIcon() != null) {
            binding.appBarMain.toolbar2.getOverflowIcon().setTint(ContextCompat.getColor(this, android.R.color.black));
        }


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Instanciação do ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.appBarMain.toolbar2,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        // Sincroniza o estado do toggle
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Mudar a cor das três barrinhas (hambúrguer) para preto
        toggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, android.R.color.black));

    }

    public void Exercicios(View view){
        Intent intent = new Intent(this, MenuExercicio.class);
        startActivity(intent);
    }

    public void sobre(View view){
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }

    public void FecharApp(View view) {
        Context context = view.getContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Fechar Aplicativo");
        builder.setMessage("Deseja realmente sair do aplicativo?");
        builder.setPositiveButton("Sim", (dialog, which) -> {
            ((Activity) context).finishAffinity(); // Fecha o app
        });
        builder.setNegativeButton("Não", (dialog, which) -> dialog.dismiss());

        // Criar o diálogo
        AlertDialog alertDialog = builder.create();

        // Mostrar o diálogo e mudar a cor de fundo
        alertDialog.setOnShowListener(dialog -> {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(
                    ContextCompat.getColor(context, R.color.background_button_color)
            ));
        });

        alertDialog.show();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
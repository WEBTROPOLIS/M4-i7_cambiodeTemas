package com.example.cambiodetemas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        aplicarTemaSeleccionado();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mostrar el mensaje de bienvenida al iniciar la actividad


        Button botonBlue = findViewById(R.id.botonBlue);
        Button botonOrange = findViewById(R.id.botonOrange);
     


        Toast.makeText(MainActivity.this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();

        botonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "¡Cambiando a Tema AZUL!", Toast.LENGTH_SHORT).show();
                cambiarTemaAzul(v);

            }
        });

        botonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "¡Cambiando a Tema NARANJA!", Toast.LENGTH_SHORT).show();
                cambiarTemaNaranja(v);

            }
        });

    }

    public void cambiarTemaAzul(View view) {
        // cambiar el tema a azul
        aplicarTema("AppThemeBlue");

    }

    public void cambiarTemaNaranja(View view) {
        // Lógica para cambiar el tema a naranja
        aplicarTema("AppThemeOrange");
    }

    private void aplicarTema(String tema) {
        SharedPreferences sharedPreferences = getSharedPreferences("theme_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("selected_theme", tema);
        editor.apply();

        // Reiniciar la actividad actual para aplicar el nuevo tema
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void aplicarTemaSeleccionado() {
        SharedPreferences sharedPreferences = getSharedPreferences("theme_prefs", MODE_PRIVATE);
        String temaSeleccionado = sharedPreferences.getString("selected_theme", "AppTheme");
        setTheme(getResources().getIdentifier(temaSeleccionado, "style", getPackageName()));
    }
}

package com.example.aplicativo_maya; // Seu pacote
import android.widget.ImageButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ListaExercicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_exercicio);

        ImageButton btnComecar = findViewById(R.id.btnComecar);
        ImageButton btnComecar1 = findViewById(R.id.btnComecar1);
        ImageButton btnComecar2 = findViewById(R.id.btnComecar2);

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lembre-se: O segundo parâmetro é a CLASSE JAVA da tela de exercícios
                Intent intent = new Intent(ListaExercicio.this, exercicio_in.class);
                startActivity(intent);
            }
        });

        btnComecar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaExercicio.this, exercicio_in.class);
                startActivity(intent);
            }
        });

        btnComecar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaExercicio.this, exercicio_in.class);
                startActivity(intent);
            }
        });

    }
}
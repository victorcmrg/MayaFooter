package com.example.aplicativo_maya;

import android.os.Bundle;

public class ExercicioActivity extends BaseFooterActivity {

    @Override
    protected int getTabIndex() {
        return 1; // Tab "Exercícios"
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        // Cole aqui qualquer lógica que você já tinha na sua tela de exercícios
    }
}
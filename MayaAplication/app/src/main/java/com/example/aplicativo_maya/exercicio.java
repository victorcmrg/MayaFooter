package com.example.aplicativo_maya;

import android.os.Bundle;

public class exercicio extends BaseFooterActivity {

    @Override
    protected int getTabIndex() {
        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        // Cole aqui qualquer lógica extra que você tinha na tela de exercícios
    }
}
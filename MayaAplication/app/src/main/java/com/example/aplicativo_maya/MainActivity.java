package com.example.aplicativo_maya;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private FooterNavigationView footer;
    private static final String[] TAGS = {"home", "exercicio", "perfil", "mural"};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        footer = findViewById(R.id.footer_navigation);

        if (savedInstanceState == null) {
            // 1. Criamos as instâncias de todas as telas
            HomepageFragment home = new HomepageFragment();
            ExercicioFragment exercicio = new ExercicioFragment();
            PerfilFragment perfil = new PerfilFragment();
            MuralFragment mural = new MuralFragment();
            ListaExerciciosFragment listaExercicios = new ListaExerciciosFragment();

            // 2. Fazemos UMA única transação: adicionamos todos e já escondemos
            // os que não devem aparecer na tela inicial.
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, home, TAGS[0])
                    .add(R.id.fragment_container, exercicio, TAGS[1]).hide(exercicio)
                    .add(R.id.fragment_container, perfil, TAGS[2]).hide(perfil)
                    .add(R.id.fragment_container, mural, TAGS[3]).hide(mural)
                    .add(R.id.fragment_container, listaExercicios, "lista_exercicios").hide(listaExercicios)
                    .commitNow();
        }

        footer.setSelectedTab(0);
        footer.setOnTabSelectedListener(this::showFragment);

        ViewCompat.setOnApplyWindowInsetsListener(footer, (view, insets) -> {
            int bottom = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), bottom);
            return insets;
        });
    }
    
// =========================================================================
    // MÉTODOS DE NAVEGAÇÃO DA MAIN ACTIVITY
    // =========================================================================

    public void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_NONE); // Garante zero delay

        Fragment listaExercicios = getSupportFragmentManager().findFragmentByTag("lista_exercicios");
        Fragment exercicioPrincipal = getSupportFragmentManager().findFragmentByTag(TAGS[1]);

        // 1. SE CLICAR NA MESMA ABA QUE JÁ ESTÁ:
        if (index == currentIndex) {
            // Se for a aba de Exercícios (index 1) E a tela secundária estiver aberta:
            if (index == 1 && listaExercicios != null && !listaExercicios.isHidden()) {
                // Volta para a tela principal de exercícios instantaneamente
                ft.hide(listaExercicios);
                if (exercicioPrincipal != null) ft.show(exercicioPrincipal);
                ft.commitNow();
            }
            return; // Encerra aqui
        }

        // 2. SE TROCAR PARA UMA ABA DIFERENTE:
        Fragment current = getSupportFragmentManager().findFragmentByTag(TAGS[currentIndex]);
        Fragment next = getSupportFragmentManager().findFragmentByTag(TAGS[index]);

        if (current != null) ft.hide(current); // Esconde a aba antiga

        // Se a tela secundária de exercícios estava aberta, temos que garantir que ela seja escondida também!
        if (listaExercicios != null && !listaExercicios.isHidden()) {
            ft.hide(listaExercicios);
        }

        if (next != null) ft.show(next); // Mostra a nova aba

        ft.commitNow(); // commitNow resolve o bug da tela branca
        currentIndex = index;
        footer.setSelectedTab(index);
    }

    public void abrirDetalheExercicio() {
        Fragment exercicioPrincipal = getSupportFragmentManager().findFragmentByTag(TAGS[1]);
        Fragment listaExercicios = getSupportFragmentManager().findFragmentByTag("lista_exercicios");

        if (exercicioPrincipal != null && listaExercicios != null) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_NONE) // Instantâneo
                    .hide(exercicioPrincipal)
                    .show(listaExercicios)
                    .commitNow(); // Força a atualização síncrona na UI
        }
    }

    public void voltarParaExercicioPrincipal() {
        Fragment exercicioPrincipal = getSupportFragmentManager().findFragmentByTag(TAGS[1]);
        Fragment listaExercicios = getSupportFragmentManager().findFragmentByTag("lista_exercicios");

        if (exercicioPrincipal != null && listaExercicios != null) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_NONE) // Instantâneo
                    .hide(listaExercicios)
                    .show(exercicioPrincipal)
                    .commitNow(); // Resolve o bug de deixar a tela vazia
        }
    }
}
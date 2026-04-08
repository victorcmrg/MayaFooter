package com.example.aplicativo_maya;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class ListaExerciciosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_lista_exercicio, container, false);

        // =====================================================================
        // AJUSTE DINÂMICO DA STATUS BAR / ILHA (CUTOUT)
        // =====================================================================
        Space statusBarSpace = view.findViewById(R.id.statusBarSpace);

        if (statusBarSpace != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
                // Pega o tamanho exato do topo (incluindo câmera, ilha, bateria)
                int topInset = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()).top;

                // Ajusta a altura do espaço invisível no XML
                statusBarSpace.getLayoutParams().height = topInset;
                statusBarSpace.requestLayout();

                return insets;
            });
        }
        // =====================================================================

        ImageButton btnVoltar  = view.findViewById(R.id.btnVoltar);
        ImageButton btnComecar  = view.findViewById(R.id.btnComecar);
        ImageButton btnComecar1 = view.findViewById(R.id.btnComecar1);
        ImageButton btnComecar2 = view.findViewById(R.id.btnComecar2);

        // Lógica do botão VOLTAR
        if (btnVoltar != null) {
            btnVoltar.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).voltarParaExercicioPrincipal();
                }
            });
        }

        // Lógica para COMEÇAR o exercício
        View.OnClickListener goToExercicio = v -> {
            Intent intent = new Intent(getActivity(), ExercicioInActivity.class);
            startActivity(intent);
        };

        if (btnComecar  != null) btnComecar.setOnClickListener(goToExercicio);
        if (btnComecar1 != null) btnComecar1.setOnClickListener(goToExercicio);
        if (btnComecar2 != null) btnComecar2.setOnClickListener(goToExercicio);

        return view;
    }
}
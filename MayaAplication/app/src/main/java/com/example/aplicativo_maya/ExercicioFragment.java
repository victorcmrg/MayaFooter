package com.example.aplicativo_maya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class ExercicioFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exercicio, container, false);

        // AÇÃO ATUALIZADA: Como ListaExerciciosFragment agora é um Fragment pré-carregado,
        // nós NÃO usamos Intent. Chamamos a MainActivity para mostrar a tela!
        View.OnClickListener abrirDetalhe = v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).abrirDetalheExercicio();
            }
        };

        // Aplica a nova ação nos botões "OPEN"
        int[] btnIds = {R.id.btnExe1, R.id.btnExe2, R.id.btnExe3};
        for (int id : btnIds) {
            Button btn = view.findViewById(id);
            if (btn != null) {
                btn.setOnClickListener(abrirDetalhe);
            }
        }

        return view;
    }
}
package com.example.cadastroalunos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadastroalunos.R;
import com.example.cadastroalunos.model.Turma;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class TurmaAdapter extends RecyclerView.Adapter<TurmaAdapter.TurmaViewHolder>  {

    private List<Turma> listaTurmas;
    private Context context;

    public TurmaAdapter(List<Turma> listaTurmas, Context context){
        this.listaTurmas = listaTurmas;
        this.context = context;
    }

    public static class TurmaViewHolder extends RecyclerView.ViewHolder {
        TextInputEditText edCodigoTurma;
        TextInputEditText edNomeTurma;
        TextInputEditText edRegimeTurma;

        public TurmaViewHolder(@NonNull View itemView) {
            super(itemView);

            edCodigoTurma = (TextInputEditText)itemView.findViewById(R.id.codTurma);
            edNomeTurma = (TextInputEditText)itemView.findViewById(R.id.nomeTurma);
            edRegimeTurma = (TextInputEditText)itemView.findViewById(R.id.regimeTurma);

        }
    }

    @Override
    public TurmaAdapter.TurmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_turma, parent, false);

        TurmaAdapter.TurmaViewHolder viewHolder = new TurmaAdapter.TurmaViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull TurmaAdapter.TurmaViewHolder holder, int position) {
        Turma Turma = listaTurmas.get(position);

        holder.edCodigoTurma.setText(String.valueOf(Turma.getCdTurma()));
        holder.edNomeTurma.setText(Turma.getNome());
        holder.edRegimeTurma.setText(Turma.getRegimeTurma());
    }

    @Override
    public int getItemCount() {
        return listaTurmas.size();
    }


}

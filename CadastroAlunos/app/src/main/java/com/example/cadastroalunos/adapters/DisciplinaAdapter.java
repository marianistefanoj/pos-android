package com.example.cadastroalunos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadastroalunos.R;
import com.example.cadastroalunos.model.Disciplina;
import com.example.cadastroalunos.model.Professor;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.DisciplinaViewHolder> {

    private List<Disciplina> listaDisciplinas;
    private List<Professor> listaProfessor;
    private Context context;

    public DisciplinaAdapter(List<Disciplina> listaDisciplinas, Context context){
        this.listaDisciplinas = listaDisciplinas;
        this.context = context;
    }
    
    public static class DisciplinaViewHolder extends RecyclerView.ViewHolder {
        TextInputEditText edCodigoDisciplina;
        TextInputEditText edNomeDisciplina;
        TextInputEditText edCargaHoraria;
        TextInputEditText edCurso;
        TextInputEditText edProfessor;
        TextInputEditText edTurma;

        public DisciplinaViewHolder(@NonNull View itemView) {
            super(itemView);

            edCodigoDisciplina = (TextInputEditText)itemView.findViewById(R.id.edCodDisciplina);
            edNomeDisciplina = (TextInputEditText)itemView.findViewById(R.id.edNomeDisciplina);
            edCargaHoraria =  (TextInputEditText)itemView.findViewById(R.id.edCargaHoraria);
            edCurso = (TextInputEditText)itemView.findViewById(R.id.edCursoDisciplina);
            edProfessor = (TextInputEditText)itemView.findViewById(R.id.edProfessor);
            edTurma = (TextInputEditText)itemView.findViewById(R.id.edTurmaDisciplina);
        }
    }

    @Override
    public DisciplinaAdapter.DisciplinaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_disciplina, parent, false);

        DisciplinaAdapter.DisciplinaViewHolder viewHolder = new DisciplinaAdapter.DisciplinaViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.DisciplinaViewHolder holder, int position) {
        Disciplina Disciplina = listaDisciplinas.get(position);

        holder.edCodigoDisciplina.setText(String.valueOf(Disciplina.getCdDisciplina()));
        holder.edNomeDisciplina.setText(Disciplina.getNome());
        holder.edCargaHoraria.setText(Disciplina.getCargaHoraria());
        holder.edCurso.setText(Disciplina.getCurso());
        holder.edProfessor.setText(Disciplina.getProfessor());
        holder.edTurma.setText(Disciplina.getTurma());
    }

    @Override
    public int getItemCount() {
        return listaDisciplinas.size();
    }


}

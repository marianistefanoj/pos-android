package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cadastroalunos.model.Turma;

public class ListaDadosTurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados_turma);
        Bundle dados = getIntent().getExtras();
        Turma turma = (Turma)dados.getSerializable("turma");
        System.out.println("Imprimindo: " + turma.getNome());
    }

    public void ListarAlunosTurma(View view){
        Intent listaAlunosTurma = new Intent(this, ListaAlunosTurmaActivity.class);
        startActivity(listaAlunosTurma);
    }

    public void ListarDisciplinasTurma(View view){
        Intent listaDisciplinasTurma = new Intent(this, ListaDisciplinasTurmaActivity.class);
        startActivity(listaDisciplinasTurma);
    }

    public void ListarProfessoresTurma(View view){
        Intent listaProfessoresTurma = new Intent(this, ListaProfessoresTurmaActivity.class);
        startActivity(listaProfessoresTurma);

    }



}
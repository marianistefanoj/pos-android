package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ListaDadosTurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados_turma);
    }

    /*

    public void ListarAlunosTurma(){
        Intent listaAlunosTurma = new Intent(this, listaAlunosTurma.class);
        startActivity(listaAlunosTurma);
    }


    public void ListarDisciplinasTurma(){
        Intent listaDisciplinasTurma = new Intent(this, listaDisciplinasTurma.class);
        startActivity(listaDisciplinasTurma);
    }

    public void ListarProfessoresTurma(){
        Intent listaProfessoresTurma = new Intent(this, listaProfessoresTurma.class);
        startActivity(listaProfessoresTurma);

    }

     */

}
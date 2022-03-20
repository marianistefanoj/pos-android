package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListaDadosTurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados_turma);
      /*  Bundle dados = getIntent().getExtras();
        int id = dados.getInt("id");
        System.out.println(id);

       */
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
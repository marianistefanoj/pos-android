package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListaAlunoDisciplinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno_disciplina);
    }

    public void CadastrarAlunoDisciplina(View view){
        Intent cadastrarAlunoDisciplina = new Intent(this, CadastrarAlunosDisciplina.class );
        startActivity(cadastrarAlunoDisciplina);
    }

}
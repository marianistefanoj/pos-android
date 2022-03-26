package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.model.Aluno;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrarAluno(View view) {
        Intent intent = new Intent(this, ListaAlunoActivity.class);
        startActivity(intent);
    }

    public void cadastrarProfessor(View view){
        Intent intentProfessor = new Intent(this, ListaProfessorActivity.class);
        startActivity(intentProfessor);
    }

    public void cadastrarDisciplina(View view){
        Intent intentDisciplina = new Intent(this, ListaDisciplinaActivity.class);
        startActivity(intentDisciplina);
    }

    /*

    public void cadastrarAlunosDisciplina(View view){
        Intent aD = new Intent(this, .class);
        startActivity(aD);
    }

     */

    public void cadastrarTurma(View view){
        Intent intentTurma = new Intent(this, ListaTurmaActivity.class);
        startActivity(intentTurma);
    }

}
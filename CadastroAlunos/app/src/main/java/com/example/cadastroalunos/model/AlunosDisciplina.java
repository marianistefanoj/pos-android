package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class AlunosDisciplina extends SugarRecord {

    private Disciplina disciplina;
    private Aluno aluno;

    public AlunosDisciplina(){}

    public Disciplina getDisciplina(){
        return disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAlunos(Aluno aluno) {
        this.aluno = aluno;
    }


}

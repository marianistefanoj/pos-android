package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Notas extends SugarRecord {

    private Aluno aluno;
    private Disciplina disciplina;
    private double frequencias;


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(double frequencias) {
        this.frequencias = frequencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notas notas = (Notas) o;
        return Double.compare(notas.frequencias, frequencias) == 0 && Objects.equals(aluno, notas.aluno) && Objects.equals(disciplina, notas.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluno, disciplina, frequencias);
    }
}

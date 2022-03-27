package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Frequencia extends SugarRecord {

    private Aluno aluno;
    private Disciplina disciplina;
    private double frequencia;

    public Frequencia(Aluno aluno, Disciplina disciplina, double frequencia) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.frequencia = frequencia;
    }

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

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frequencia that = (Frequencia) o;
        return Double.compare(that.frequencia, frequencia) == 0 && Objects.equals(aluno, that.aluno) && Objects.equals(disciplina, that.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluno, disciplina, frequencia);
    }
}

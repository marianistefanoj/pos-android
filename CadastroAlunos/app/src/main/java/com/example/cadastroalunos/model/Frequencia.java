package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Frequencia extends SugarRecord {

    private long idAluno;
    private long disciplina;
    private int frequencia;

    public Frequencia() {
    }

    public Frequencia(long idAluno, long disciplina, int frequencia) {
        this.idAluno = idAluno;
        this.disciplina = disciplina;
        this.frequencia = frequencia;
    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(long disciplina) {
        this.disciplina = disciplina;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frequencia that = (Frequencia) o;
        return idAluno == that.idAluno && disciplina == that.disciplina && frequencia == that.frequencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequencia);
    }
}

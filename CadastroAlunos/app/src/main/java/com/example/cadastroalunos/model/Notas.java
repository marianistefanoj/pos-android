package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Notas extends SugarRecord {
    private long idAluno;
    private long idDisciplina;
    private double nota;

    public Notas() {
    }

    public Notas(long idAluno, long idDisciplina, double nota) {
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
        this.nota = nota;
    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notas notas = (Notas) o;
        return idAluno == notas.idAluno && idDisciplina == notas.idDisciplina && Double.compare(notas.nota, nota) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota);
    }
}

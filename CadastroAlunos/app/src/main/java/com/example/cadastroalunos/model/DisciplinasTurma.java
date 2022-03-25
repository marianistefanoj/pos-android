package com.example.cadastroalunos.model;

import java.util.Objects;

public class DisciplinasTurma {

    private long idDisciplinas;
    private long idTurma;

    public DisciplinasTurma() {
    }

    public DisciplinasTurma(long idDisciplinas, long idTurma) {
        this.idDisciplinas = idDisciplinas;
        this.idTurma = idTurma;
    }

    public long getIdDisciplinas() {
        return idDisciplinas;
    }

    public void setIdDisciplinas(long idDisciplinas) {
        this.idDisciplinas = idDisciplinas;
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinasTurma that = (DisciplinasTurma) o;
        return idDisciplinas == that.idDisciplinas && idTurma == that.idTurma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisciplinas, idTurma);
    }
}

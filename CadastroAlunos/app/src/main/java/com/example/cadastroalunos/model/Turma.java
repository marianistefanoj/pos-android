package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Turma extends SugarRecord {

    private int cdTurma;
    private String nomeTurma, regimeTurma;

    public Turma(int cdTurma, String nomeTurma, String regimeTurma) {
        this.cdTurma = cdTurma;
        this.nomeTurma = nomeTurma;
        this.regimeTurma = regimeTurma;
    }

    public int getCdTurma() {
        return cdTurma;
    }

    public void setCdTurma(int cdTurma) {
        this.cdTurma = cdTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getRegimeTurma() {
        return regimeTurma;
    }

    public void setRegimeTurma(String regimeTurma) {
        this.regimeTurma = regimeTurma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return cdTurma == turma.cdTurma && Objects.equals(nomeTurma, turma.nomeTurma) && Objects.equals(regimeTurma, turma.regimeTurma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdTurma, nomeTurma, regimeTurma);
    }
}

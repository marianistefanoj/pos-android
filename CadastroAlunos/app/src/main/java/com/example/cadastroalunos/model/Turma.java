package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Objects;

public class Turma extends SugarRecord implements Serializable {

    private int cdTurma;
    private String nome, regimeTurma;

    public Turma (){
    }

    public Turma(int cdTurma, String nome, String regimeTurma) {
        this.cdTurma = cdTurma;
        this.nome = nome;
        this.regimeTurma = regimeTurma;
    }

    public int getCdTurma() {
        return cdTurma;
    }

    public void setCdTurma(int cdTurma) {
        this.cdTurma = cdTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return cdTurma == turma.cdTurma && Objects.equals(nome, turma.nome) && Objects.equals(regimeTurma, turma.regimeTurma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdTurma, nome, regimeTurma);
    }

    @Override
    public String toString(){ return nome;}

}

package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Disciplina extends SugarRecord {

    private int cdDisciplina;
    private String nome;
    private String cargaHoraria;

    public Disciplina(int cdDisciplina, String nome, String cargaHoraria) {
        this.cdDisciplina = cdDisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCdDisciplina() {
        return cdDisciplina;
    }

    public void setCdDisciplina(int cdDisciplina) {
        this.cdDisciplina = cdDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return cdDisciplina == that.cdDisciplina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdDisciplina);
    }
}

package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Disciplina extends SugarRecord {

    private int cdDisciplina;
    private String nome;
    private String cargaHoraria;
    private String curso;
    private String professor;
    private String turma;

    public Disciplina(){
    }
    public Disciplina(int cdDisciplina, String nome, String cargaHoraria, String curso, String professor, String turma) {
        this.cdDisciplina = cdDisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
        this.professor = professor;
        this.turma = turma;
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

    public String getCurso() { return curso; }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
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

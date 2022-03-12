package com.example.cadastroalunos.model;

import com.orm.SugarRecord;

import java.util.Objects;

public class Professor extends SugarRecord {

    private String nome;
    private String cpf;
    private String dtNascimento;
    private String curso;

    public Professor(){}

    public Professor(String nome, String cpf, String dtNascimento, String curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(nome, professor.nome) && Objects.equals(cpf, professor.cpf) && Objects.equals(dtNascimento, professor.dtNascimento) && Objects.equals(curso, professor.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

}

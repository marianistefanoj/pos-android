package com.example.cadastroalunos.dao;

import android.util.Log;

import com.example.cadastroalunos.model.AlunosDisciplina;

import java.util.ArrayList;
import java.util.List;

public class AlunosDisciplinasDAO {

    public static long salvar(AlunosDisciplina alunosDisciplina) {
        try {
            return alunosDisciplina.save();
        }
        catch (Exception ex) {
            Log.e("Erro", "Erro ao salvar alunos na disciplinas: " + ex.getMessage());
            return -1;
        }
    }

    public static AlunosDisciplina getDisciplina(int id) {
        try {
            return AlunosDisciplina.findById(AlunosDisciplina.class, id);
        }
        catch (Exception ex) {
            Log.e("Erro", "Erro ao buscar as alunos nas disciplinas: " + ex.getMessage());
            return null;
        }
    }

    public static List<AlunosDisciplina> getDisciplinas(String where, String[] whererArgs, String orderBy) {
        List<AlunosDisciplina> alunosDisciplinas = new ArrayList<>();

        try {
            alunosDisciplinas = AlunosDisciplina.find(AlunosDisciplina.class, where, whererArgs, null, orderBy, null);
        }
        catch (Exception ex) {
            Log.e("Erro", "Erro ao buscar a lista de alunos nas disciplinas: " + ex.getMessage());
        }

        return alunosDisciplinas;
    }

}

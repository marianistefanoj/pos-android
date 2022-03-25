package com.example.cadastroalunos.dao;

import android.util.Log;

import com.example.cadastroalunos.model.DisciplinasTurma;

import java.util.ArrayList;
import java.util.List;

public class DisciplinasTurmaDAO {


    public static long salvar(DisciplinasTurma disciplinasTurma){
        try{
            return disciplinasTurma.save();
        }catch (Exception ex){
            Log.e("Erro", "Erro ao salvar o turma: "+ex.getMessage());
            return -1;
        }
    }

    public static DisciplinasTurma getDisciplinasTurma(int id){
        try{
            return DisciplinasTurma.findById(DisciplinasTurma.class, id);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar o turma: "+ex.getMessage());
            return null;
        }
    }

    public static List<DisciplinasTurma> retornaDisciplinasTurma(String where, String[]whereArgs, String orderBy){
        List<DisciplinasTurma> list = new ArrayList<>();
        try{
            list = DisciplinasTurma.find(DisciplinasTurma.class, where, whereArgs, "", orderBy, "");
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar lista de turmas: "+ex.getMessage());
        }
        return list;
    }

    public static boolean delete(DisciplinasTurma disciplinasTurma){
        try{
            return DisciplinasTurma.delete(disciplinasTurma);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao apagar o turma: "+ex.getMessage());
            return false;
        }

    }



}

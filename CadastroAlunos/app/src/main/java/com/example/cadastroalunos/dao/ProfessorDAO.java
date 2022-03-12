package com.example.cadastroalunos.dao;

import android.util.Log;

import com.example.cadastroalunos.model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public static long salvar(Professor Professor){
        try{
            return Professor.save();
        }catch (Exception ex){
            Log.e("Erro", "Erro ao salvar o Professor: "+ex.getMessage());
            return -1;
        }
    }

    public static Professor getProfessor(int id){
        try{
            return Professor.findById(Professor.class, id);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar o Professor: "+ex.getMessage());
            return null;
        }
    }

    public static List<Professor> retornaProfessores(String where, String[]whereArgs, String orderBy){
        List<Professor> list = new ArrayList<>();
        try{
            list = Professor.find(Professor.class, where, whereArgs, "", orderBy, "");
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar lista de Professores: "+ex.getMessage());
        }
        return list;
    }

    public static boolean delete(Professor Professor){
        try{
            return Professor.delete(Professor);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao apagar o Professor: "+ex.getMessage());
            return false;
        }
    }




}

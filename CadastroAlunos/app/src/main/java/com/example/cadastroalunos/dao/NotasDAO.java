package com.example.cadastroalunos.dao;

import android.util.Log;


import com.example.cadastroalunos.model.Notas;

import java.util.ArrayList;
import java.util.List;

public class NotasDAO {

    public static long salvar(Notas notas){
        try{
            return notas.save();
        }catch (Exception ex){
            Log.e("Erro", "Erro ao salvar o Notas: "+ex.getMessage());
            return -1;
        }
    }

    public static Notas getNotas(int id){
        try{
            return Notas.findById(Notas.class, id);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar o Notas: "+ex.getMessage());
            return null;
        }
    }

    public static List<Notas> retornaNotass(String where, String[]whereArgs, String orderBy){
        List<Notas> list = new ArrayList<>();
        try{
            list = Notas.find(Notas.class, where, whereArgs, "", orderBy, "");
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar lista de Notas: "+ex.getMessage());
        }
        return list;
    }

    public static boolean delete(Notas notas){
        try{
            return Notas.delete(notas);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao apagar o Notas: "+ex.getMessage());
            return false;
        }

    }
}

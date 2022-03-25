package com.example.cadastroalunos.dao;

import android.util.Log;

import com.example.cadastroalunos.model.Frequencia;

import java.util.ArrayList;
import java.util.List;

public class FrequenciaDAO {

    public static long salvar(Frequencia frequencia){
        try{
            return frequencia.save();
        }catch (Exception ex){
            Log.e("Erro", "Erro ao salvar o Frequencia: "+ex.getMessage());
            return -1;
        }
    }

    public static Frequencia getFrequencia(int id){
        try{
            return Frequencia.findById(Frequencia.class, id);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar o Frequencia: "+ex.getMessage());
            return null;
        }
    }

    public static List<Frequencia> retornaFrequencias(String where, String[]whereArgs, String orderBy){
        List<Frequencia> list = new ArrayList<>();
        try{
            list = Frequencia.find(Frequencia.class, where, whereArgs, "", orderBy, "");
        }catch (Exception ex){
            Log.e("Erro", "Erro ao retornar lista de Frequencias: "+ex.getMessage());
        }
        return list;
    }

    public static boolean delete(Frequencia frequencia){
        try{
            return Frequencia.delete(frequencia);
        }catch (Exception ex){
            Log.e("Erro", "Erro ao apagar o Frequencia: "+ex.getMessage());
            return false;
        }

    }


}

package com.example.cadastroalunos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.cadastroalunos.CadastroProfessorActivity;
import com.example.cadastroalunos.R;
import com.example.cadastroalunos.adapters.ProfessorAdapter;
import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.dao.ProfessorDAO;
import com.example.cadastroalunos.dao.TurmaDAO;
import com.example.cadastroalunos.model.Professor;
import com.example.cadastroalunos.model.Turma;
import com.example.cadastroalunos.util.Util;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class ListaProfessorActivity extends AppCompatActivity {

    private RecyclerView rvListaProfessores;
    private LinearLayout lnLista;
    private MaterialSpinner spTurmas;
    private String varSpinner = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_professor);

        lnLista = findViewById(R.id.lnListaProfessor);

        iniciaSpinners();
        atualizaListaProfessor();
    }

    public void iniciaSpinners(){
        // Turma
        spTurmas = findViewById(R.id.spTurmaLP);
        //Lista os registros das turmas cadastradas
        List<Turma> turmas = TurmaDAO.retornaTurmas("",new String[]{}, "nome");
        ArrayAdapter adapterTurmas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, turmas);
        spTurmas.setAdapter(adapterTurmas);


        spTurmas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spTurmas.getSelectedItemId() != 0) {
                    Long id = spTurmas.getSelectedItemId();
                    List<Turma> turmas = TurmaDAO.retornaTurmas("CD_TURMA = ?", new String[]{"" + id}, "nome");
                    varSpinner = turmas.toString();
                    varSpinner = varSpinner.replace("[", "");
                    varSpinner = varSpinner.replace("]", "");
                    System.out.println(varSpinner);
                    atualizaListaProfessor();
                }
                if (spTurmas.getSelectedItemId() == 0){
                    varSpinner = "";
                    System.out.println(varSpinner);
                    atualizaListaProfessor();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        System.out.println(varSpinner);
    }

    public void atualizaListaProfessor(){
        List<Professor> listaProfessor = new ArrayList<>();
        if (varSpinner == "")
            listaProfessor = ProfessorDAO.retornaProfessores("", new String[]{}, "nome asc, turma asc");
        else if (varSpinner != "")
            listaProfessor = ProfessorDAO.retornaProfessores("turma = ?", new String[]{varSpinner} , "nome asc, turma asc");
        Log.e("PHS", "Tamanho da lista: "+ listaProfessor.size());

        rvListaProfessores = findViewById(R.id.rvListaProfessores);
        ProfessorAdapter adapter = new ProfessorAdapter(listaProfessor, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvListaProfessores.setLayoutManager(llm);
        rvListaProfessores.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_add:
                abrirCadastroProfessor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void abrirCadastroProfessor() {
        Intent intent = new Intent(this, CadastroProfessorActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Util.customSnackBar(lnLista, "Professor salvo com sucesso!", 1);
        }
        atualizaListaProfessor();
    }
}
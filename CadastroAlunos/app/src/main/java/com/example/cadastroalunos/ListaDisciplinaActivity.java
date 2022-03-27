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

import com.example.cadastroalunos.adapters.DisciplinaAdapter;
import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.dao.DisciplinaDAO;
import com.example.cadastroalunos.dao.TurmaDAO;
import com.example.cadastroalunos.model.Disciplina;
import com.example.cadastroalunos.model.Turma;
import com.example.cadastroalunos.util.Util;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class ListaDisciplinaActivity extends AppCompatActivity {

    private RecyclerView rvListaDisciplinas;
    private LinearLayout lnLista;
    private MaterialSpinner spTurmas;
    private String varSpinner = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_disciplina);

        lnLista = findViewById(R.id.lnListaDisciplina);

        iniciaSpinners();
        atualizaListaDisciplina();
    }

    public void iniciaSpinners(){
        // Turma
        spTurmas = findViewById(R.id.spTurmaLD);
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
                    atualizaListaDisciplina();
                }
                if (spTurmas.getSelectedItemId() == 0){
                    varSpinner = "";
                    System.out.println(varSpinner);
                    atualizaListaDisciplina();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        System.out.println(varSpinner);
    }

    public void atualizaListaDisciplina(){
        List<Disciplina> listaDisciplina = new ArrayList<>();
        if (varSpinner == "")
            listaDisciplina = DisciplinaDAO.retornaDisciplinas("", new String[]{}, "nome asc");
        else if (varSpinner != "")
            listaDisciplina = DisciplinaDAO.retornaDisciplinas("turma = ?", new String[]{varSpinner} , "nome asc, turma asc");

        Log.e("PHS", "Tamanho da lista: "+ listaDisciplina.size());

        rvListaDisciplinas = findViewById(R.id.rvListaDisciplinas);
        DisciplinaAdapter adapter = new DisciplinaAdapter(listaDisciplina, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvListaDisciplinas.setLayoutManager(llm);
        rvListaDisciplinas.setAdapter(adapter);
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
                abrirCadastroDisciplina();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void abrirCadastroDisciplina() {
        Intent intent = new Intent(this, CadastroDisciplinaActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Util.customSnackBar(lnLista, "Disciplina salvo com sucesso!", 1);
        }
        atualizaListaDisciplina();
    }

    /*

    public void listaAlunosDiciplinas (View view){
        Intent listaAlunos = new Intent(this, ListaAlunoDisciplinaActivity.class );
        startActivity(listaAlunos);
    }

     */
}
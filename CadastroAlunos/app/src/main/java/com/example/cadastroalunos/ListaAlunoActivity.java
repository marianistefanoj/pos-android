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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cadastroalunos.adapters.AlunoAdapter;
import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.dao.TurmaDAO;
import com.example.cadastroalunos.model.Aluno;
import com.example.cadastroalunos.model.Turma;
import com.example.cadastroalunos.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.ganfra.materialspinner.MaterialSpinner;

public class ListaAlunoActivity extends AppCompatActivity {

    private RecyclerView rvListaAlunos;
    private LinearLayout lnLista;
    private MaterialSpinner spTurmas;
    private String varSpinner = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        lnLista = findViewById(R.id.lnLista);

        iniciaSpinners();
        atualizaListaAluno();
    }

    public void iniciaSpinners(){
        // Turma
        spTurmas = findViewById(R.id.spTurmaLA);
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
                    System.out.println(varSpinner);
                    atualizaListaAluno();
                }
                if (spTurmas.getSelectedItemId() == 0){
                    varSpinner = "";
                    System.out.println(varSpinner);
                    atualizaListaAluno();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        System.out.println(varSpinner);
    }

    public void atualizaListaAluno(){
        List<Aluno> listaAluno = new ArrayList<>();
        if (varSpinner == "")
            listaAluno = AlunoDAO.retornaAlunos("", new String[]{}, "nome asc, turma asc");
        else if (varSpinner != "")
            listaAluno = AlunoDAO.retornaAlunos("turma = ?", new String[]{"algoritmo"}, "nome asc, turma asc");
        Log.e("PHS", "Tamanho da lista: "+listaAluno.size());

        rvListaAlunos = findViewById(R.id.rvListaAlunos);
        AlunoAdapter adapter = new AlunoAdapter(listaAluno, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvListaAlunos.setLayoutManager(llm);
        rvListaAlunos.setAdapter(adapter);
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
                abrirCadastroAluno();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void abrirCadastroAluno() {
        Intent intent = new Intent(this, CadastroAlunoActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Util.customSnackBar(lnLista, "Aluno salvo com sucesso!", 1);
        }
        atualizaListaAluno();
    }
}
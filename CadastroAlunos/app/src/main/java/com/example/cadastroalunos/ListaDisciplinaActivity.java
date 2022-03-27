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
import android.widget.LinearLayout;

import com.example.cadastroalunos.adapters.DisciplinaAdapter;
import com.example.cadastroalunos.dao.DisciplinaDAO;
import com.example.cadastroalunos.model.Disciplina;
import com.example.cadastroalunos.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ListaDisciplinaActivity extends AppCompatActivity {

    private RecyclerView rvListaDisciplinas;
    private LinearLayout lnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_disciplina);

        lnLista = findViewById(R.id.lnListaDisciplina);

        atualizaListaDisciplina();
    }

    public void atualizaListaDisciplina(){
        List<Disciplina> listaDisciplina = new ArrayList<>();
        listaDisciplina = DisciplinaDAO.retornaDisciplinas("", new String[]{}, "nome asc");
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
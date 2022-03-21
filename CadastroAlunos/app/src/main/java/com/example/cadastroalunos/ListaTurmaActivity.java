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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.cadastroalunos.adapters.TurmaAdapter;
import com.example.cadastroalunos.dao.TurmaDAO;
import com.example.cadastroalunos.model.Turma;
import com.example.cadastroalunos.util.Util;
import com.orm.SugarRecord;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class ListaTurmaActivity extends AppCompatActivity {

    private RecyclerView rvListaTurmas;
    private LinearLayout lnLista;
    private Button buscaTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_turma);

        lnLista = findViewById(R.id.lnListaTurma);

       atualizaListaTurma();
    }

    public void atualizaListaTurma(){
        List<Turma> listaTurma = new ArrayList<>();
        listaTurma = TurmaDAO.retornaTurmas("", new String[]{}, "nome asc");
        Log.e("PHS", "Tamanho da lista: "+ listaTurma.size());

        rvListaTurmas = findViewById(R.id.rvListaTurmas);
        TurmaAdapter adapter = new TurmaAdapter(listaTurma, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvListaTurmas.setLayoutManager(llm);
        rvListaTurmas.setAdapter(adapter);


        //int i = TurmaDAO.getTurma();
        //System.out.println("Ver os valores: " + i );

/*
        buscaTurma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int id = rvListaTurmas.getId();
                Intent dadosTurma = new Intent(ListaTurmaActivity.this, ListaDadosTurmaActivity.class);
                dadosTurma.putExtra("id", id);
                startActivity(dadosTurma);
            }
        });


 */

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
                abrirCadastroTurma();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void abrirCadastroTurma() {
        Intent intent = new Intent(this, CadastroTurmaActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Util.customSnackBar(lnLista, "Turma salvo com sucesso!", 1);
        }
        atualizaListaTurma();
    }

    public void abrirListaDadosTurma(View view){
        Turma turma = TurmaDAO.getTurma(2);
        Intent dadosTurma = new Intent(ListaTurmaActivity.this, ListaDadosTurmaActivity.class);
        dadosTurma.putExtra("turma", turma);
        startActivity(dadosTurma);

    }


}
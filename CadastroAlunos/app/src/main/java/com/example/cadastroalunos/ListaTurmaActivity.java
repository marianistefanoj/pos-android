package com.example.cadastroalunos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_turma);
        lnLista = findViewById(R.id.lnListaTurma);

       atualizaListaTurma();

       /*
       card.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(ListaTurmaActivity.this, ListaDadosTurmaActivity.class);
               startActivity(i);
           }
       });

        */


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

        //pegar id

        //int id = findViewById(R.id.pegarId);

        int id = 1;
        Turma turma = TurmaDAO.getTurma(id);
        Intent dadosTurma = new Intent(ListaTurmaActivity.this, ListaDadosTurmaActivity.class);
        dadosTurma.putExtra("turma", turma);
        startActivity(dadosTurma);

    }




}
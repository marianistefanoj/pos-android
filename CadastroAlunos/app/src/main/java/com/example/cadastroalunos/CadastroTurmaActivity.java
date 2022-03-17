package com.example.cadastroalunos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.dao.TurmaDAO;
import com.example.cadastroalunos.dao.ProfessorDAO;
import com.example.cadastroalunos.model.Aluno;
import com.example.cadastroalunos.model.Turma;
import com.example.cadastroalunos.model.Professor;
import com.example.cadastroalunos.util.Util;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CadastroTurmaActivity extends AppCompatActivity {

    private TextInputEditText edCodTurma;
    private TextInputEditText edNomeTurma;
    private MaterialSpinner spRegimeTurma;
    private LinearLayout lnPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_turma);
        edCodTurma = findViewById(R.id.edCodTurma);
        edNomeTurma = findViewById(R.id.edNomeTurma);
        spRegimeTurma = findViewById(R.id.spRegimeTurma);
        iniciaSpinners();
    }

    private void iniciaSpinners() {

        spRegimeTurma = findViewById(R.id.spRegimeTurma);

        //lista os registros dos cursos cadastrados
        String regime[] = new String[]{ "Semestral", "Anual" };

        ArrayAdapter adapterCursos = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, regime);
        spRegimeTurma.setAdapter(adapterCursos);

        //Ação ao selecionar o item da lista
        spRegimeTurma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                    /*Button btADS = new Button(getBaseContext());
                    btADS.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                             LinearLayout.LayoutParams.WRAP_CONTENT));
                    btADS.setText("Botao ADS");
                    btADS.setBackgroundColor(getColor(R.color.teal_200));

                    llPrincipal.addView(btADS);*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    //Validação dos campos
    private void validaCampos() {

        //Valida o campo do código da turma
        if (edCodTurma.getText().toString().equals("")) {
            edNomeTurma.setError("Informe o código da Turma!");
            edNomeTurma.requestFocus();
            return;
        }


        //Valida o campo de nome da Turma
        if (edNomeTurma.getText().toString().equals("")) {
            edNomeTurma.setError("Informe o nome da Turma!");
            edNomeTurma.requestFocus();
            return;
        }

        salvarTurma();
    }


    public void salvarTurma(){
        Turma turma = new Turma();
        turma.setCdTurma(Integer.parseInt(edCodTurma.getText().toString()));
        turma.setNomeTurma(edNomeTurma.getText().toString());
        turma.setRegimeTurma(edNomeTurma.getText().toString());

        if(TurmaDAO.salvar(turma) > 0) {
            setResult(RESULT_OK);
            finish();
        }else
            Util.customSnackBar(lnPrincipal, "Erro ao salvar a Turma ("+ turma.getNomeTurma()+") " +
                    "verifique o log", 0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_limpar:
                //TODO: adicionar método  de limpar dados
                limparCampos();
                return true;
            case R.id.mn_salvar:
                //TODO: adicionar método  de salvar dados
                validaCampos();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void limparCampos() {
        edNomeTurma.setText("");
        edCodTurma.setText("");
    }


}
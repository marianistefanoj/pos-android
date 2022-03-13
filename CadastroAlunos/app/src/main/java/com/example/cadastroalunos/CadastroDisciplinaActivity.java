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
import com.example.cadastroalunos.dao.DisciplinaDAO;
import com.example.cadastroalunos.model.Aluno;
import com.example.cadastroalunos.model.Disciplina;
import com.example.cadastroalunos.util.Util;
import com.google.android.material.textfield.TextInputEditText;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CadastroDisciplinaActivity extends AppCompatActivity {

    private TextInputEditText edCodDisciplina;
    private TextInputEditText edNomeDisciplina;
    private TextInputEditText edCargaHoraria;
    private MaterialSpinner spCursos;
    private LinearLayout lnPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        edCodDisciplina = findViewById(R.id.edCodDisciplina);
        edNomeDisciplina = findViewById(R.id.edNomeDisciplina);
        edCargaHoraria = findViewById(R.id.edCargaHoraria);
        lnPrincipal = findViewById(R.id.lnPrincipal);
        iniciaSpinners();
    }

    private void iniciaSpinners() {
        spCursos = findViewById(R.id.spCursos);

        String cursos[] = new String[]{"Análise e Desenv. Sistemas",
                "Administração", "Ciências Contábeis", "Direito",
                "Farmácia", "Nutrição"};

        String periodos[] = new String[]{"1a Série",
                "2a Série", "3a Série", "4a Série"};

        ArrayAdapter adapterCursos = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, cursos);
        spCursos.setAdapter(adapterCursos);


        //Ação ao selecionar o item da lista
        spCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {

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
            //Valida o campo de nome da disciplina
            if (edNomeDisciplina.getText().toString().equals("")) {
                edNomeDisciplina.setError("Informe o nome da disciplina!");
                edNomeDisciplina.requestFocus();
                return;
            }

            //Valida a carga horaria da disciplina
            if (edCargaHoraria.getText().toString().equals("")) {
                edCargaHoraria.setError("Informe a carga horaria da disciplina!");
                edCargaHoraria.requestFocus();
                return;
            }

            salvarDisciplina();
        }


    public void salvarDisciplina(){
        Disciplina disciplina = new Disciplina();
        disciplina.setCdDisciplina(Integer.parseInt(edCodDisciplina.getText().toString()));
        disciplina.setNome(edNomeDisciplina.getText().toString());
        disciplina.setCargaHoraria(edCargaHoraria.getText().toString());
        disciplina.setCurso(spCursos.getSelectedItem().toString());


        if(DisciplinaDAO.salvar(disciplina) > 0) {

            setResult(RESULT_OK);
            finish();
        }else
            Util.customSnackBar(lnPrincipal, "Erro ao salvar a disciplina ("+ disciplina.getNome()+") " +
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
        edNomeDisciplina.setText("");
        edCodDisciplina.setText("");
        edCargaHoraria.setText("");
    }


}
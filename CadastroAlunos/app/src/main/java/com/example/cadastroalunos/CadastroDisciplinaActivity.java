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
import android.widget.ListView;

import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.dao.AlunosDisciplinasDAO;
import com.example.cadastroalunos.dao.DisciplinaDAO;
import com.example.cadastroalunos.dao.ProfessorDAO;
import com.example.cadastroalunos.dao.TurmaDAO;
import com.example.cadastroalunos.model.Aluno;
import com.example.cadastroalunos.model.AlunosDisciplina;
import com.example.cadastroalunos.model.Disciplina;
import com.example.cadastroalunos.model.Professor;
import com.example.cadastroalunos.model.Turma;
import com.example.cadastroalunos.util.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CadastroDisciplinaActivity extends AppCompatActivity {

    private TextInputEditText edCodDisciplina;
    private TextInputEditText edNomeDisciplina;
    private TextInputEditText edCargaHoraria;
    private MaterialSpinner spCursos, spProfessor, spTurmas, spAdicionarAlunos;
    private LinearLayout lnPrincipal;
    private ListView lvAlunosDisciplina;
    private List<Aluno> alunos = new ArrayList<>();
    private List<Aluno> disciplinaAlunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        edCodDisciplina = findViewById(R.id.edCodDisciplina);
        edNomeDisciplina = findViewById(R.id.edNomeDisciplina);
        edCargaHoraria = findViewById(R.id.edCargaHoraria);
        lnPrincipal = findViewById(R.id.lnPrincipal);

        spAdicionarAlunos = findViewById(R.id.edAdicionarAlunos);

        lvAlunosDisciplina = findViewById(R.id.lvAlunosDisciplina);

        FloatingActionButton addAluno = findViewById(R.id.add_alunos);
        FloatingActionButton addAlunoDisciplina = findViewById(R.id.add_alunos_disciplina);

        addAluno.setOnClickListener(view -> adicionaAlunos());
        addAlunoDisciplina.setOnClickListener(view -> );

        iniciaSpinners();
    }

    private void iniciaSpinners() {
        spCursos = findViewById(R.id.spCursos);
        spProfessor = findViewById(R.id.spProfessor);


        //lista os registros dos cursos cadastrados
        String cursos[] = new String[]{"Análise e Desenv. Sistemas",
                "Administração", "Ciências Contábeis", "Direito",
                "Farmácia", "Nutrição"};

        ArrayAdapter adapterCursos = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, cursos);
        spCursos.setAdapter(adapterCursos);

        //Lista os registros dos professores cadastrados
        List<Professor> professores = ProfessorDAO.retornaProfessores("",new String[]{}, "nome");
        ArrayAdapter adapterProfessores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, professores);
        spProfessor.setAdapter(adapterProfessores);


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

        // Turma
        spTurmas = findViewById(R.id.spTurmaD);
        //Lista os registros das turmas cadastradas
        List<Turma> turmas = TurmaDAO.retornaTurmas("",new String[]{}, "nome");
        ArrayAdapter adapterTurmas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, turmas);
        spTurmas.setAdapter(adapterTurmas);




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
        disciplina.setProfessor(spProfessor.getSelectedItem().toString());
        disciplina.setTurma(spTurmas.getSelectedItem().toString());


        if(DisciplinaDAO.salvar(disciplina) > 0) {

            for(Aluno aluno : disciplinaAlunos ){

                AlunosDisciplina alunosDisciplina = new AlunosDisciplina();
                alunosDisciplina.setAlunos(aluno);

                if (AlunosDisciplinasDAO.salvar(alunosDisciplina) <= 0)
                    Util.customSnackBar(lnPrincipal, "Deu ruim aqui ("+ aluno.getNome()+") " +
                            "verifique o log", 0);

            }

            setResult(RESULT_OK);
            finish();
        }else
            Util.customSnackBar(lnPrincipal, "Erro ao salvar a disciplina ("+ disciplina.getNome()+") " +
                    "verifique o log", 0);

    }

    private void adicionaAlunos(){
        Aluno aluno = (Aluno) spAdicionarAlunos.getSelectedItem();
        disciplinaAlunos.add(aluno);
        alunos.remove(aluno);
        spAdicionarAlunos.setSelection(0);

        ArrayAdapter adapterAluno = new ArrayAdapter(this, android.R.layout.simple_list_item_1, disciplinaAlunos);
        lvAlunosDisciplina.setAdapter(adapterAluno);
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
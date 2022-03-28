# Trabalho Final da Pós Android


#### Importante: Para visualizar o trabalho é necessário entrar na branch master!

RA 030118212 Stefano Julio Mariani    
RA 00215064 William Schanoski    

Desenvolver um APP para controle de notas e frequência    
Deve conter as seguintes funcionalidades:    
Cadastro de Aluno    
Cadastro de Professor    
Cadastro de Disciplina    
Lançamento de Notas (Selecionar se é regime anual ou semestral)    
Cadastro de Turmas.    
Lançamento de Frequências.    
Exibir se o aluno está aprovado ou não (Média 6,0)    
Exibir se o aluno está aprovado ou não por faltas (Não pode passar de 30% de faltas).    
Layout fica livre para cada um.    
 
Entrega dia 27/03    

Foi desenvolvido o cadastro de turmas, disciplinas, professores e alunos.     
Na tela de listagem de alunos, disciplinas e professores foi realizado um filtro por turmas que os objetos foram inseridos.    
Havia sido desenvolvido uma função de onClick para pegar o objeto de turma do cardviews porém não conseguimos capturar o objeto específico para passar o id, porém foi tratado os processos conforme o parágrafo anterior, de uma forma mais simplificada.    
No cadastro de disciplinas foi inserido o vínculo com os alunos, porém não foi 100% concluído, porém passamos por dificuldades ao realizar os relacionamentos com listas, pois não conhecíamos como realizar o procedimento.    
Foi desenvolvido também o processo do model e os arquivos DAO de frequências e notas devido ao não conseguir realizar o vínculo da disciplina com os alunos não foi desenvolvido as telas das mesmas.    
Tivemos dificuldades manipular o spinner para filtrar os dados na opção selecionada, ao decorrer do trabalho foi resolvido.
Apesar das dificuldades, nunca utilizamos aplicações Android e utilizamos java para desenvolver a aplicação, apesar disso foi uma oportunidade de ter contado com as ferramentas.    

Regras Definidas:    

Para cadastrar disciplinas, professores e alunos é necessário cadastrar primeiro as turmas    
Para cadastrar as disciplinas é necessário cadastrar os professores.    
É necessário alunos para cadastrar alunos na disciplina.    
Para filtrar os alunos, professores e disciplinas por turma é necessário selecionar a turma no spinner.    

package org.example;

import dao.IAlunoDAO;
import daoImplements.AlunoDAOImplements;
import daoImplements.TurmaDAOImplements;
import database.sqlConn;
import model.Aluno;
import model.Turma;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        sqlConn.testConnection();

        AlunoDAOImplements alunoDAOMethods = new AlunoDAOImplements();
        TurmaDAOImplements turmaDAOMethods = new TurmaDAOImplements();

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Atualizar aluno");
            System.out.println("3. Excluir aluno");
            System.out.println("4. Listar aluno");
            System.out.println("5. Listar aluno por ID");
            System.out.println("6. Listar turma por ID");
            System.out.println("7. Sair do programa");

            opcao = sc.nextInt();
            sc.nextLine();

            String nome;
            String cpf;
            String email;
            LocalDate data_nascimento;
            String telefone;

            switch (opcao) {

                case 1:
                    System.out.println("Cadastro de aluno");

                    System.out.println("Nome:");
                    nome = sc.nextLine();

                    System.out.println("CPF:");
                    cpf = sc.nextLine();

                    System.out.println("Email:");
                    email = sc.nextLine();

                    System.out.println("Data nascimento (AAAA-MM-DD):");
                    data_nascimento = LocalDate.parse(sc.nextLine());

                    System.out.println("Telefone:");
                    telefone = sc.nextLine();

                    Aluno novoAluno = new Aluno(nome, cpf, email, data_nascimento, telefone);

                    alunoDAOMethods.salvar(novoAluno);

                    break;

                case 2:
                    System.out.println("Informe o ID do aluno que deseja atualizar:");
                    for(Aluno aluno : alunoDAOMethods.listarTodosAlunos())
                    {
                        System.out.println(aluno);
                    }

                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    Optional<Aluno> alunoAtualizar = alunoDAOMethods.obterPorId(idAtualizar);

                    if (alunoAtualizar.isPresent()) {

                        System.out.println("Novo nome:");
                        nome = sc.nextLine();

                        System.out.println("Novo CPF:");
                        cpf = sc.nextLine();

                        System.out.println("Novo email:");
                        email = sc.nextLine();

                        System.out.println("Nova data de nascimento (AAAA-MM-DD):");
                        data_nascimento = LocalDate.parse(sc.nextLine());

                        System.out.println("Novo telefone:");
                        telefone = sc.nextLine();

                        Aluno aluno = new Aluno(idAtualizar, nome, cpf, email, data_nascimento, telefone);

                        alunoDAOMethods.atualizar(aluno);

                    } else {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;
                case 3:

                    System.out.println("Qual o ID do aluno que deseja excluir:");
                    for(Aluno aluno : alunoDAOMethods.listarTodosAlunos())
                    {
                        System.out.println(aluno);
                    }

                    System.out.println("Informe o ID do aluno que deseja excluir:");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();

                    Optional<Aluno> alunoExcluir = alunoDAOMethods.obterPorId(idExcluir);

                    if (alunoExcluir.isPresent()) {

                        alunoDAOMethods.excluirAluno(idExcluir);

                    } else {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;
                case 4:
                    System.out.println("Listar aluno");

                    List<Aluno> todosAlunos = alunoDAOMethods.listarTodosAlunos();

                    if (todosAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for (Aluno aluno : todosAlunos) {
                            System.out.println(aluno);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Listar aluno por ID. Informe um ID para pesquisar: ");

                    int idBusca = sc.nextInt();

                    Optional<Aluno> alunoEncontrado = alunoDAOMethods.obterPorId(idBusca);

                    if (alunoEncontrado.isPresent()) {
                        System.out.println(alunoEncontrado.get());
                    } else {
                        System.out.println("Nenhum aluno encontrado!");
                    }
                    break;

                case 6:
                    System.out.println("Listar turma");

                    List<Turma> todasTurmas = turmaDAOMethods.listarTodasTurmas();

                    if (todasTurmas.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for (Turma turma : todasTurmas) {
                            System.out.println(turma);
                        }
                    }

                    System.out.println("Informe o id da turma para visualizar os alunos");

                    int idInformado = sc.nextInt();

                    List<Aluno> alunosTurmaEncontrada = turmaDAOMethods.listarAlunosPorTurmaID(idInformado);

                    if (alunosTurmaEncontrada.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for (Aluno aluno : alunosTurmaEncontrada) {
                            System.out.println(alunosTurmaEncontrada);
                        }
                    }
                    break;
            }

        } while ((opcao != 0));
    }
}
package dao;

import model.Aluno;

import java.util.List;

public interface IAlunoDAO {
    // CRUD

    // C - Create
    void salvar(Aluno aluno);

    // R - Read
    List<Aluno> listarTodosAlunos();

    // U- Update
    void atualizar(Aluno aluno);

    // D - Delete
    void excluirAluno(int id);
}
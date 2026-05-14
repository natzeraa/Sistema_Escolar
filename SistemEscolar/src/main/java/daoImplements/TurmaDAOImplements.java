package daoImplements;

import dao.ITurmaDAO;
import database.sqlConn;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TurmaDAOImplements implements ITurmaDAO {
    @Override
    public List<Turma> listarTodasTurmas() {
        String sql = "SELECT * FROM turma ORDER BY turno DESC, nome ASC";

        List<Turma> turmasEncontradas = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                turmasEncontradas.add(new Turma(
                        rs.getInt("idTurma"),
                        rs.getInt("instituicao_id"),
                        rs.getInt("professor_id"),
                        rs.getString("nome"),
                        rs.getInt("ano_letivo"),
                        rs.getString("turno"),
                        rs.getInt("vagas")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar todas as turmas: " + e.getMessage());
        }

        return turmasEncontradas;

    }

    @Override
    public List<Aluno> listarAlunosPorTurmaID(int idTurma) {
        String sql = "SELECT a.* " +
                "FROM matricula m " +
                "INNER JOIN aluno a ON a.idAluno = m.aluno_id " +
                "WHERE m.turma_id = ? " +
                "ORDER BY a.nome ASC";

        List<Aluno> alunosEncontrados = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idTurma);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunosEncontrados.add(new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os alunos por turma: " + e.getMessage());
        }

        return alunosEncontrados;
    }
}

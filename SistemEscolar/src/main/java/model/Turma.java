package model;

public class Turma {
    private int id;
    private int instituicaoId;
    private int professorId;
    private String nome;
    private int anoLetivo;
    private String turno;
    private int vagas;

    public Turma(int id, int instituicaoId, int professorId, String nome, int anoLetivo, String turno, int vagas) {
        this.id = id;
        this.instituicaoId = instituicaoId;
        this.professorId = professorId;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.turno = turno;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public String getTurno() {
        return turno;
    }

    public int getVagas() {
        return vagas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return String.format(
                "Turma = Id = %d - Nome = %s - Ano Letivo = %d - Turno = %s - Vagas = %d",
                id, nome, anoLetivo, turno, vagas
        );
    }
}
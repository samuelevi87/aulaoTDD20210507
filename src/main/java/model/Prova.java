package model;

/**
 * A avaliação do desempenho do model.Aluno em uma model.Materia.
 * <p>
 * A prova registra uma avaliação realizada pelo model.Aluno {@Link model.Aluno} relativo
 * ao conhecimento de uma matéria. O {@Link model.Aluno} poderá realizar várias
 * avaliações da mesma matéria. A média ponderada das noras das Provas
 * é registrada no {@Link model.Boletim} e verifica se o aluno foi aprovado.
 */
public class Prova {
    Integer periodo;
    Aluno aluno;
    Materia materia;
    Double nota;

    /**
     * Avaliação de desempenho do aluno.
     *
     * No construto da prova não atribui-se valor para a nota, para que seja
     * possível a criação de provas para depois serem atribuídas as notas.
     *
     * @param periodo período no formado YYYMM.
     * @param aluno model.Aluno que realizou a prova.
     * @param materia Matéria da model.Prova
     */
    public Prova(Integer periodo, Aluno aluno, Materia materia) {
        this.periodo = periodo;
        this.aluno = aluno;
        this.materia = materia;
    }


    public Integer getPeriodo() {
        return periodo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    /**
     * Valor da avaliação.
     * @return
     */
    public Double getNota() {
        return nota;
    }

    /**
     * Determina a avaliação do aluno.
     * Não pode ser menor que 0 e nem maior que o atributo MAteria.notaMaxima.
     * @param nota
     */
    public void setNota(Double nota) throws Exception {
        if (nota <0 || nota > this.materia.notaMaxima) {
            throw new Exception("Valor da nota inválido.");
        }
        this.nota = nota;
    }
}

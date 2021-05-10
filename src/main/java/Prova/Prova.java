package Prova;

import Aluno.Aluno;
import model.Materia;

/**
 * A avaliação do desempenho do Aluno.Aluno em uma model.Materia.
 * <p>
 * A prova registra uma avaliação realizada pelo Aluno.Aluno {@Link Aluno.Aluno} relativo
 * ao conhecimento de uma matéria. O {@Link Aluno.Aluno} poderá realizar várias
 * avaliações da mesma matéria. A média ponderada das noras das Provas
 * é registrada no {@Link Boletim.Boletim} e verifica se o aluno foi aprovado.
 */
public class Prova {
    private Integer periodo;
    private Aluno aluno;
    private Materia materia;
    private Double nota = 0.0;
    private int peso = 1;

    /**
     * Avaliação de desempenho do aluno.
     * <p>
     * No construto da prova não atribui-se valor para a nota, para que seja
     * possível a criação de provas para depois serem atribuídas as notas.
     *
     * @param periodo período no formado YYYMM.
     * @param aluno   Aluno.Aluno que realizou a prova.
     * @param materia Matéria da Prova.Prova
     */
    public Prova(Integer periodo, Aluno aluno, Materia materia) {
        this.periodo = periodo;
        this.aluno = aluno;
        this.materia = materia;
    }

    /**
     * Período no formato YYYYMM.
     *
     * @return periodo da prova
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * Aluno que realizou a prova.
     *
     * @return aluno que realizou a prova.
     */
    public Aluno getAluno() {
        return aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    /**
     * Valor da avaliação.
     *
     * @return
     */
    public Double getNota() {
        return nota;
    }

    /**
     * Determina a avaliação do aluno.
     * Não pode ser menor que 0 e nem maior que o atributo MAteria.notaMaxima.
     *
     * @param nota
     */
    public void setNota(Double nota) throws Exception {
        if (nota < 0 || nota > this.materia.notaMaxima) {
            throw new Exception("Valor da nota inválido.");
        }
        this.nota = nota;
    }

    /**
     * Peso da avaliação
     *
     * @return peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Deifine o peso da avaliação.
     *
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

}

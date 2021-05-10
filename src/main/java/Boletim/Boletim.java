package Boletim;

import Aluno.Aluno;
import Prova.Prova;

import java.util.ArrayList;

/**
 * Reúne as {@link Prova}s de um {@link Aluno}.
 * <p>
 * O boletim possui uma lista de {@link Prova}s e é referente a um período de
 * um {@link Aluno}. Para cada período é calculada a média das provas que
 * resulta na nota do Boletim.
 *
 * @author LeviDev samuel.levi.alves@outlook.com
 */
public class Boletim {

    private Integer id;
    private Aluno aluno;
    private Integer periodo;
    private Double media;
    private ArrayList<Prova> provas;

    /**
     * Cria um novo Boletim
     *
     * O Boletim é criado a partir de um aluno e um período. Conforme as provas
     * são adicionadas, realiza-se o cálculo atualizado da média.
     *
     * @param aluno
     * @param periodo
     * @param media
     */
    public Boletim(Aluno aluno, Integer periodo) {
        this.aluno = aluno;
        this.periodo = periodo;
        this.media = 0.0;
        this.provas = new ArrayList<Prova>();
    }

    /**
     * Id do Boletim
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Aluno do boletim
     *
     * @return
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * Período no formato YYYYMM
     *
     * @return
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * Retorna a média das provas atualizada.
     *
     * @return
     */
    public Double getMedia() {
        return media;
    }

    /**
     * Retorna todas as provas.
     *
     * @return ArrayList<Prova>
     */
    public ArrayList<Prova> getProvas() {
        return this.provas;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void resetProvas() {
        this.provas = new ArrayList<Prova>();
    }
}

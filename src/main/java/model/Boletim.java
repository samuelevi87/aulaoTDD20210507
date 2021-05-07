package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    private final Aluno aluno;
    private final Integer periodo;
    private Double media;
    private ArrayList<Prova> provas = new ArrayList<Prova>();

    /**
     * Cria um novo Boletim.
     * O boletim é criado a partir de um aluno e um período. Conforme as provas
     * são adicionadas a média é recalculada.
     *
     * @param aluno
     * @param periodo
     */
    public Boletim(Aluno aluno, Integer periodo) {
        this.aluno = aluno;
        this.periodo = periodo;
        this.media = 0.0;
        this.provas = new ArrayList<>();
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
     * Periodo no formato YYYMM.
     *
     * @return
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * Retorna a médida das provas atualizadas.
     *
     * @return
     */
    public Double getMedia() {
        this.calcularMedia();
        return media;

    }

    /**
     * Adiciona uma avalização ao boletim.
     * Ao adicionar a Prova, a média é recalculada.
     *
     * @param prova
     */
    public void addProva(Prova prova) {
        provas.add(prova);
    }

    /**
     * Remove uma avalização ao boletim.
     * Ao remover uma prova a média é recalculada.
     *
     * @param index
     */
    public void removeProva(int index) {
        this.provas.remove(index);
    }

    public void removeTodasAsProvas() {
        this.provas = new ArrayList<>();
    }

    /**
     * Calcula a média ponderada das provas.
     */
    public void calcularMedia() {
        double soma =
                provas.stream().collect(Collectors.summingDouble(Prova::getNota));
        this.media = soma / provas.size();
        System.out.println(media);
    }

    /**
     * Retorna uma lista de provas.
     *
     * @return ArrayList
     */
    public ArrayList<Prova> getProvas() {
        return provas;
    }
}

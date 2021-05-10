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
     * @return periodo
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * Retorna a média das provas atualizadas.
     *
     * @return media
     */
    public Double getMedia() {
        return media;
    }

    /**
     * Retorna uma lista de provas.
     *
     * @return ArrayList
     */
    public ArrayList<Prova> getProvas() {
        return this.provas;
    }

    /**
     * Adiciona uma avalização ao boletim.
     * Ao adicionar a Prova, a média é recalculada.
     *
     * @param prova
     */
    public void addProva(Prova prova) {
        provas.add(prova);
        this.calcularMedia();
    }

    /**
     * Remove uma avalização ao boletim.
     * Ao remover uma prova a média é recalculada.
     *
     * @param index
     */
    public void removeProva(int index) {
        try {
            this.provas.remove(index);
        }catch (Exception e) {
            System.out.println("Prova não removida. Erro: " + e.getMessage());
        }
        this.calcularMedia();
    }

    public void removeTodasAsProvas() {
        this.provas = new ArrayList<>();
    }

    /**
     * Calcula a média ponderada das provas.
     */
    public void calcularMedia() {
        Double total = 0.0;
        int pesos = 0;
        for(Prova prova : provas) {
            total += prova.getNota() * prova.getPeso();
            pesos += prova.getPeso();
        }
        this.media = total / pesos;
    }

}

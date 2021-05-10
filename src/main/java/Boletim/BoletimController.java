package Boletim;

import Prova.Prova;
import Prova.ProvaDao;

public class BoletimController {

    private Boletim boletim;

    public BoletimController(Boletim boletimEntrada) {
        this.boletim = boletimEntrada;
    }

    /**
     * Adiciona uma avaliacao ao boletim.
     * <p>
     * Ao adicionar a Prova, a media e recalculada.
     *
     * @param prova
     */
    public void addProva(Prova prova) {
        ProvaDao provaDao = new ProvaDao(boletim);
        provaDao.add(prova);
        this.calcularMedia();
    }

    /**
     * Remove uma avaliação do boletim.
     * <p>
     * Ao remover a Prova, a média é recalculada.
     *
     * @param index
     */
    public void removeProva(int index) {
        try {
            ProvaDao provaDao = new ProvaDao(boletim);
            provaDao.remove(index);
        } catch (Exception e) {
            System.out.println("Prova não removida. Erro:" + e.getMessage());
        }
        this.calcularMedia();
    }

    /**
     * ;
     * Remove todas as provas.
     */
    public void removeTodasProvas() {
        ProvaDao provaDao = new ProvaDao(boletim);
        provaDao.removeAll();
        this.calcularMedia();
    }

    /**
     * Calcula a media ponderada das provas.
     * <p>
     * Realiza o calculo da media das notas das provas e atualiza o valor da
     * media.
     */
    private void calcularMedia() {
        Double total = 0.0;
        int pesos = 0;
        for (Prova prova : boletim.getProvas()) {
            total += prova.getNota() * prova.getPeso();
            pesos += prova.getPeso();
        }
        boletim.setMedia(total / pesos);
    }

    public Boletim getBoletim() {
        return this.boletim;
    }
}

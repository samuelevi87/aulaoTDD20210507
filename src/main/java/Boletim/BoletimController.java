package Boletim;

import Prova.*;
import persistence.ArrayListPersistenceBoletim;

import java.util.ArrayList;

public class BoletimController {

    private Boletim boletim;
    private BoletimDao boletimDao;
    private ArrayListPersistenceBoletim dbBoletim = new ArrayListPersistenceBoletim();

    /**
     * Classe de controle do boletim
     * <p>
     * Recebe um boletim e verifica se o boletim já existe na persistência.
     * Se não existir, cria um novo.
     *
     * @param boletimEntrada
     */
    public BoletimController(Boletim boletimEntrada) {
        this.boletimDao = new BoletimDao(dbBoletim);
        this.boletim = boletimEntrada;
    }

    /**
     * Adiciona um boletim.
     * Cria um novo boletim, caso o Id seja nulo, retorna o boletim, caso
     * o Id já exista.
     * @return boletim conforme parâmetro.
     */
    public Boletim addBoletim() {
        if (this.boletim.getId() == null) {
            return this.boletimDao.add(this.boletim);
        }
        return this.boletim;
    }

    /**
     * Adiciona uma avaliação ao boletim.
     * <p>
     * Ao adicionar a Prova, a méia é recalculada.
     *
     * @param prova
     */
    public void addProva(Prova prova) {
        ProvaController provaController = new ProvaController(prova);
        if (prova.getId() != null) {
            provaController.addProva();
        } else {
            provaController.getById(prova.getId());
        }
        boletim.getProvas().add(prova);
        this.calcularMedia();
    }

    /**
     * Remove uma avaliação do boletim.
     * <p>
     * Ao remover a Prova, a média é recalculada.
     *
     * @param index da prova que será removida.
     */
    public void removeProva(int index) {
        ProvaController provaController = new ProvaController(index);
        provaController.removeProva();
        boletim.getProvas().remove(index);
        this.calcularMedia();
    }

    /**
     * ;
     * Remove todas as provas.
     */
    public void removeTodasProvas() {
        ArrayList<Prova> provas = this.boletim.getProvas();

        for (Prova prova : provas) {
            ProvaController provaController = new ProvaController(prova);
            provaController.removeProva();
        }
        this.boletim.getProvas().clear();
        this.calcularMedia();
    }

    /**
     * Calcula a média ponderada das provas.
     * <p>
     * Realiza o cÃ¡lculo da média das notas das provas e atualiza o valor da
     * média.
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

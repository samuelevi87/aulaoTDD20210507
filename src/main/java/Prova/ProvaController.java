package Prova;

import persistence.ArrayListPersistenceProva;

public class ProvaController {

    private Prova prova;
    private ProvaDao provaDao;
    private ArrayListPersistenceProva dbProvas = new ArrayListPersistenceProva();

    public ProvaController(Prova prova) {
        this.provaDao = new ProvaDao(dbProvas);
        this.prova = prova;
    }

    public ProvaController(int index) {
        this.provaDao = new ProvaDao(dbProvas);
        this.prova = provaDao.get(index);
    }

    /**
     * Adiciona uma avaliação
     *
     * @param prova
     */

    public void addProva(Prova prova) {
        if (prova.getId() == null) {
            provaDao.add(prova);
        } else {
            provaDao.get(prova.getId());
        }
        provaDao.getDb().add(prova);
    }

    /**
     * Remove uma avaliação do boletim.
     * <p>
     * Ao remover a Prova, a média é recalculada.
     *
     * @param prova que será removida.
     */
    public void removeProva() {
        try {
            provaDao.remove(prova.getId());
        } catch (Exception e) {
            System.out.println("Prova não removida. Erro:" + e.getMessage());
        }
    }

    /**
     * Remove uma avaliação do boletim.
     * <p>
     * Ao remover a Prova, a média é recalculada.
     *
     * @param prova que será removida.
     */
    public void removeTodasProvas() {
        provaDao.removeAll();
    }

    public Prova getById(Integer id) {
        return this.provaDao.get(id);
    }

    public Prova getProva() {
        return this.prova;
    }

    public ArrayListPersistenceProva getDbProvas(){
        return dbProvas;
    }

}

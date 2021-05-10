package Prova;

import Aluno.Aluno;
import model.Materia;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.ArrayListPersistenceProva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProvaControllerTest {

    static ArrayListPersistenceProva db;
    static ProvaController controller;

        Aluno aluno = new Aluno();
        Integer periodo = 202105;
        Materia materia = new Materia();
        Prova prova = new Prova(periodo, aluno, materia);

    @Test
    public void testProvaController(){
        assertNotNull(controller);
    }

    @Test
    public void testAddProva() {
        db = new ArrayListPersistenceProva();
        db.removeAll();
        db.add(controller.addProva(prova));
        assertEquals(1, (int) controller.getDbProvas().dados.size());

    }

    @Test
    public void removeProva() {
    }

    @Test
    public void get() {
    }
}
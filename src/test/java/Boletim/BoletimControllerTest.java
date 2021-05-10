package Boletim;

import Aluno.Aluno;
import Prova.Prova;
import model.Materia;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.ArrayListPersistenceBoletim;

import static org.junit.Assert.*;

public class BoletimControllerTest {

    static BoletimController controller;
    static ArrayListPersistenceBoletim db;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Aluno aluno = new Aluno();
        Integer periodo = 202105;
        Boletim boletim = new Boletim(aluno, periodo);
        controller = new BoletimController(boletim);
    }

    @Test
    public void testBoletimController() {
        assertNotNull(controller);
    }

    @Test
    public void testAddProva() {
        controller.removeTodasProvas();
        Materia materia = new Materia();
        Prova prova = new Prova(202105, controller.getBoletim().getAluno(), materia);
        controller.addProva(prova);
        assertEquals(1,(int) controller.getBoletim().getProvas().size());
    }



    @Test
    public void testRemoveProva() {
        Materia materia = new Materia();
        Boletim boletim = controller.getBoletim();
        Prova prova = new Prova(202105, boletim.getAluno(), materia);
        controller.removeTodasProvas();
        controller.addProva(prova);
        controller.addProva(prova);
        controller.removeProva(0);
        assertEquals(1, boletim.getProvas().size());
    }

    @Test
    public void testRemoveProvaInexistente() {
        Materia materia = new Materia();
        Boletim boletim = controller.getBoletim();
        Prova prova = new Prova(202105, boletim.getAluno(), materia);
        controller.removeTodasProvas();
        controller.addProva(prova);
        controller.addProva(prova);
        controller.removeProva(4);
        assertEquals(2, boletim.getProvas().size());
    }


    @Test
    public void testRemoveTodasProvas() {
        Materia materia = new Materia();
        Boletim boletim = controller.getBoletim();
        Prova prova = new Prova(202105, boletim.getAluno(), materia);
        controller.addProva(prova);
        controller.removeTodasProvas();
        assertFalse(boletim.getProvas().size() > 0);
    }

}
package Boletim;

import Aluno.Aluno;
import Prova.Prova;
import model.Materia;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoletimTest {

    private static final int periodoPadrao = 202105;
    static Boletim boletim;

    @BeforeClass
    public static void setUpBeforClass() throws Exception {
        Aluno aluno = new Aluno();
        Integer periodo = periodoPadrao;
        boletim = new Boletim(aluno, periodo);
    }

    @Test
    public void testBoletim() {
        assertNotNull(boletim);
    }

    @Test
    public void testGetAluno() {
        assertNotNull(boletim.getAluno());
    }

    @Test
    public void testGetPeriodo() {
        assertEquals(periodoPadrao, (int) boletim.getPeriodo());
    }

    @Test
    public void testGetMedia() {
        boletim.resetProvas();
        Materia materia = new Materia();
        Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
        try {
            prova.setNota(10.0);
            boletim.addProva(prova);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(10.0, boletim.getMedia(), 0.01);
    }

    @Test
    public void testAddProva() {
        boletim.resetProvas();
        Materia materia = new Materia();
        Prova prova = new Prova(boletim.getPeriodo(), boletim.getAluno(),
                materia);
        boletim.addProva(prova);
        assertEquals(1, boletim.getProvas().size());
    }

    @Test
    public void testRemoveProva() {
        Materia materia = new Materia();
        Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
        Prova prova2 = new Prova(periodoPadrao, boletim.getAluno(), materia);
        boletim.resetProvas();
        boletim.addProva(prova);
        boletim.addProva(prova2);
        boletim.removeProva(0);
        assertEquals(1, boletim.getProvas().size());
    }

    @Test
    public void testRemoveTodasAsProvas() {
        Materia materia = new Materia();
        Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
        boletim.addProva(prova);
        boletim.resetProvas();
        assertFalse(boletim.getProvas().size() > 0);
    }

    @Test
    public void calcularMedia() {
        boletim.resetProvas();
        Materia materia = new Materia();
        Prova prova1 = new Prova(periodoPadrao, boletim.getAluno(), materia);
        try {
            prova1.setNota(8.0);
            boletim.addProva(prova1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Prova prova2 = new Prova(periodoPadrao, boletim.getAluno(), materia);
        try {
            prova2.setNota(10.0);
            boletim.addProva(prova2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(9.0, boletim.getMedia(), 0.01);
    }
}
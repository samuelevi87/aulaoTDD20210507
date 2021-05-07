package model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoletimTest {

    static Boletim boletim;
    private static final int periodoPadrao = 202105;

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
    public void getMedia() {
        boletim.removeTodasAsProvas();
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
        boletim.removeTodasAsProvas();
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
        boletim.removeTodasAsProvas();
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
        boletim.removeTodasAsProvas();
        assertFalse(boletim.getProvas().size() > 0);
    }

    @Test
    public void calcularMedia() {
    }
}
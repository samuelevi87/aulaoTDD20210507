package Boletim;

import Aluno.Aluno;
import Prova.Prova;
import model.Materia;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoletimTest {

    static Boletim boletim;
    private static int periodoPadrao= 202105;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
        assertEquals(0.0, boletim.getMedia(), 0.01);
    }
}
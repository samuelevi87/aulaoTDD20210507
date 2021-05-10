package Aluno;

import Aluno.Aluno;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    @org.junit.Test(expected = Exception.class)
    public void testSetNomeComNumeros() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("Samuel123");
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetNomeComCaracteresProibidos() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("Samuel.");
    }

    @org.junit.Test
    public void testSetNomeValido() {
        Aluno aluno = new Aluno();
        try {
            aluno.setNome("Samuel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull((aluno.getNome()));
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetSobrenomeComNumeros() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setSobrenome("Levi123");
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetSobrenomeComCaracteresProibidos() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("Levi#");
    }

    @org.junit.Test
    public void testSetSobrenomeValido() {
        Aluno aluno = new Aluno();
        try {
            aluno.setNome("Levi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull((aluno.getNome()));
    }

    @Test(expected = Exception.class)
    public void testSetIdadeMaiorQue130() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setIdade(131);
    }

    @Test(expected = Exception.class)
    public void testSetIdadeMenorQue0() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setIdade(-1);
    }

    @Test
    public void testSetIdadeValida() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setIdade(20);
        assertEquals(20, (int) aluno.getIdade());
    }
}
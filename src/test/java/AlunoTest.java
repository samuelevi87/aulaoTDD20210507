import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    @org.junit.Test(expected = Exception.class)
    public void testSetNomeComNumero() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setName("Samuel123");
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetNomeComCaractereProibido() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setName("Samuel.");
    }

    @org.junit.Test
    public void testSetNomeSemNumero() {
        Aluno aluno = new Aluno();
        try {
            aluno.setName("Samuel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull((aluno.getName()));
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetSobrenomeComNumero() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setSurname("Levi123");
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetSobrenomeComCaractereProibido() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setName("Levi#");
    }

    @Test(expected = Exception.class)
    public void testSetAgaBiggerThan130() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setAge(131);
    }

    @Test(expected = Exception.class)
    public void testSetAgaSmallerThan0() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setAge(-1);
    }

    @Test
    public void testSetValidAge() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setAge(20);
        assertEquals(20, (int) aluno.getAge());
    }
}
import static org.junit.Assert.*;

public class AlunoTest {

    @org.junit.Test
    public void testSetNomeComNumero() {
        Aluno aluno = new Aluno();
        aluno.setNome("Samuel123");
        assertNull((aluno.getNome()));
    }

    @org.junit.Test
    public void testSetNomeSemNumero() {
        Aluno aluno = new Aluno();
        aluno.setNome("Samuel");
        assertNotNull((aluno.getNome()));
    }
}
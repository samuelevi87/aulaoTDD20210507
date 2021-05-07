import static org.junit.Assert.*;

public class AlunoTest {

    @org.junit.Test(expected = Exception.class)
    public void testSetNomeComNumero() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("Samuel123");
}

    @org.junit.Test
    public void testSetNomeSemNumero() {
        Aluno aluno = new Aluno();
        try {
            aluno.setNome("Samuel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull((aluno.getNome()));
    }
}
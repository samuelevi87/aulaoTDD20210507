import model.Aluno;
import model.Materia;
import model.Prova;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProvaTest {

    static Prova prova;
    static int periodoParam = 202105;

    @BeforeClass
    public static void createProva(){
        Integer periodo = periodoParam;
        Materia materia = new Materia();
        Aluno aluno = new Aluno();
        prova = new Prova(periodo,aluno, materia);
    }

    @Test
    public void testProva(){
        assertNotNull(prova);
    }
    @Test
    public void testSetGetNotaCorreto() {
        try {
            prova.setNota(10.0);
        }catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(10.0, (double) prova.getNota(), 0.1);
    }

    @Test(expected = Exception.class)
    public void testSetGetNotaIncorreto() throws Exception {
        prova.setNota(-10.0);
    }

    @Test
    public void testGetAluno(){
        assertNotNull(prova.getAluno());
    }

    @Test
    public void testGetMateria(){
        assertNotNull(prova.getMateria());
    }

    @Test
    public void testGetPeriodo(){
        assertNotNull(prova.getPeriodo());
    }
}
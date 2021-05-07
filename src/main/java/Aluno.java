/**
 * Pessoa que estuda na escola.
 * Um aluno é uma pessoa que estuda na escola. O aluno frequenta uma Turma
 * {@link Turma}, tem Notas {@link Nota} e Boletim {@link Boletim}.
 *
 * @author LeviDev <samuel.levi.alves@outlook.com>
 * @see Turma
 * @see Nota
 * @see Boletim
 */
public class Aluno {

    private String nome;


    private String sobrenome;


    private Integer idade;

    /**
     * Primeiro nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     * Aceita apenas letras.
     *
     * @param nome
     */
    public void setNome(String nome) {
        if (nome.matches(".*[0-9].*")) {
            this.nome = null;
        }else {
            this.nome = nome;
        }
    }

    /**
     * Último sobrenome do aluno.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Idade do aluno.
     */
    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

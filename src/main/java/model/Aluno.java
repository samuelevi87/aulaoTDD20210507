package model;

import utils.Validators;

/**
 * Pessoa que estuda na escola.
 * Um aluno é uma pessoa que estuda na escola. Realiza
 * {@link Prova}s e tem um Boletim {@link Boletim}.
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
     * @return String name.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     * Aceita apenas letras.
     *
     * @param inputName String
     */
    public void setNome(String inputName) throws Exception {
        if (!Validators.onlyValidChars(inputName)) {
            throw new Exception("Please, input only alphabetichal characters!");
        }
        this.nome = inputName;
    }

    /**
     * Último sobrenome do aluno.
     * @return String surname.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o último sobrenome do aluno.
     * Aceita apenas letras.
     *
     * @param inputSurname String
     */
    public void setSobrenome(String inputSurname) throws Exception {
        if (!Validators.onlyValidChars(inputSurname)) {
            throw new Exception("Please, input only alphabetichal characters!");
        }
        this.sobrenome = inputSurname;
    }

    /**
     * Idade do aluno.
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * Define a idade do aluno
     * Idade em anos. De 0 até 130 (incluso).
     *
     * @param inputAge
     * @return Integer inputAge
     */
    public void setIdade(Integer inputAge) throws Exception {
        if (inputAge < 0 || inputAge >= 130) {
            throw new Exception("Age must be bigger than 0 and smaller than " +
                    "130!");
        }
        this.idade = inputAge;
    }

}

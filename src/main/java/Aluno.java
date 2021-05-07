import utils.Validators;

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

    private String name;


    private String surname;


    private Integer age;

    /**
     * Primeiro nome do aluno.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do aluno.
     * Aceita apenas letras.
     *
     * @param inputName String
     */
    public void setName(String inputName) throws Exception {
        if (!Validators.onlyValidChars(inputName)) {
            throw new Exception("Please, input only alphabetichal characters!");
        }
        this.name = inputName;
    }

    /**
     * Último sobrenome do aluno.
     * @return String surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Define o último sobrenome do aluno.
     * Aceita apenas letras.
     *
     * @param inputSurname String
     */
    public void setSurname(String inputSurname) throws Exception {
        if (!Validators.onlyValidChars(inputSurname)) {
            throw new Exception("Please, input only alphabetichal characters!");
        }
        this.surname = inputSurname;
    }

    /**
     * Idade do aluno.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Define a idade do aluno
     * Idade em anos. De 0 até 130 (incluso).
     *
     * @param inputAge
     * @return Integer inputAge
     */
    public void setAge(Integer inputAge) throws Exception {
        if (inputAge < 0 || inputAge >= 130) {
            throw new Exception("Age must be bigger than 0 and smaller than " +
                    "130!");
        }
        this.age = inputAge;
    }

}

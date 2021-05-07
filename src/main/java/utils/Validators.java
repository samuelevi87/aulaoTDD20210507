package utils;

/**
 * Verifica se há caracteres não alfabéticos.
 * @param "verify" String a ser verificada
 */
public class Validators {
    static public boolean onlyValidChars(String verify){
        return !verify.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\\\\\|," +
                ".<>\\/?]+.*");
    }
}

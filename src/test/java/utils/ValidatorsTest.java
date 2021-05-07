package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorsTest {

    @Test
    public void onlyValidChars() {
        assertTrue(Validators.onlyValidChars("fdaçkfjakjfakdjfaçdjfkaçdjfkça"));
    }
}
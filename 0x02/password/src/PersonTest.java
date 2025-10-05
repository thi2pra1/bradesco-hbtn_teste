import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    private Person person;

    /**
     * Método setup que roda antes de todos os testes
     */
    @BeforeAll
    public void setup() {
        person = new Person();
    }

    /**
     * Teste parametrizado que valida usernames válidos
     */
    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String username) {
        assertTrue(person.checkUser(username));
    }

    /**
     * Teste parametrizado que valida usernames inválidos
     */
    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String username) {
        assertFalse(person.checkUser(username));
    }

    /**
     * Teste parametrizado que verifica senhas sem letras maiúsculas
     */
    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }

    /**
     * Teste parametrizado que verifica senhas sem números
     */
    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }

    /**
     * Teste parametrizado que verifica senhas com menos de 8 caracteres
     */
    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }

    /**
     * Teste parametrizado que valida senhas válidas
     */
    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));
    }
}

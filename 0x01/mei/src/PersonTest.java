import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.Calendar;

public class PersonTest {
    private Person person;

    /**
     * Método setup que roda antes de todos os testes
     */
    @Before
    public void setup() {
        person = new Person();
        person.setName("Paul");
        person.setSurname("McCartney");

        // Criando data de nascimento para o ano 2000
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        person.setBirthDate(calendar.getTime());

        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
    }

    /**
     * Testa se o método fullName() retorna o nome completo correto
     */
    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    /**
     * Testa se o método calculateYearlySalary() retorna o valor correto
     */
    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400.0f, person.calculateYearlySalary(), 0.01f);
    }

    /**
     * Testa se a pessoa é elegível para MEI quando atende todos os critérios
     */
    @Test
    public void person_is_MEI() {
        // Alterando os dados para que a pessoa seja elegível para MEI
        person.setSalary(5000); // Salário anual seria 60.000 (< 130.000)
        person.setAnotherCompanyOwner(false); // Não tem participação em outro negócio
        person.setPensioner(false); // Não é pensionista
        person.setPublicServer(false); // Não é servidor público
        // Idade já é > 18 (nasceu em 2000, tem mais de 18 anos)

        assertTrue(person.isMEI());
    }

    /**
     * Testa se a pessoa não é elegível para MEI quando não atende aos critérios
     */
    @Test
    public void person_is_not_MEI() {
        // Mantendo os dados iniciais do setup onde a pessoa não é elegível
        // anotherCompanyOwner = true, pensioner = true, publicServer = true
        person.setSalary(8000); // Salário anual seria 96.000 (< 130.000)

        assertFalse(person.isMEI());
    }
}

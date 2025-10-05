import org.junit.Test;
import static org.junit.Assert.*;

public class TesteEmail {

    /**
     * Testa se o método emailValid() retorna true para um email válido com arroba
     */
    @Test
    public void testar_email_com_arroba() {
        assertTrue(Pessoa.emailValid("email_teste@dominio.com.br"));
    }

    /**
     * Testa se o método emailValid() retorna false para um email sem arroba
     */
    @Test
    public void testar_email_sem_arroba() {
        assertFalse(Pessoa.emailValid("email_testedominio.com.br"));
    }

    /**
     * Testa se o método emailValid() retorna false para um email com mais de 50 caracteres
     */
    @Test
    public void testar_email_mais_50_caracteres() {
        assertEquals(false, Pessoa.emailValid("email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br"));
    }
}

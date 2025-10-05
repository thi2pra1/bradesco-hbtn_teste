public class Person {

    /**
     * Valida o nome de usuário seguindo as regras:
     * - Ter no mínimo 8 caracteres
     * - Não deve conter caractere especial
     * @param username String contendo o nome de usuário a ser validado
     * @return true se o username é válido, false caso contrário
     */
    public boolean checkUser(String username) {
        if (username == null) {
            return false;
        }

        // Verifica se tem no mínimo 8 caracteres
        if (username.length() < 8) {
            return false;
        }

        // Verifica se não contém caracteres especiais
        // Permite apenas letras e números
        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Valida a senha seguindo as regras:
     * - Deve possuir pelo menos 1 letra maiúscula
     * - Deve possuir pelo menos 1 número
     * - Deve possuir pelo menos 1 caractere especial
     * - Ter no mínimo 8 caracteres
     * @param password String contendo a senha a ser validada
     * @return true se a senha é válida, false caso contrário
     */
    public boolean checkPassword(String password) {
        if (password == null) {
            return false;
        }

        // Verifica se tem no mínimo 8 caracteres
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        // Verifica cada caractere da senha
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        // Retorna true apenas se todos os critérios foram atendidos
        return hasUpperCase && hasNumber && hasSpecialChar;
    }
}


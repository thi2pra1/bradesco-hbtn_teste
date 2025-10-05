import java.util.Date;
import java.util.Calendar;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    // Constructor
    public Person() {
    }

    // Constructor with parameters
    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner,
                  boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAnotherCompanyOwner() {
        return anotherCompanyOwner;
    }

    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
        this.anotherCompanyOwner = anotherCompanyOwner;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public boolean isPublicServer() {
        return publicServer;
    }

    public void setPublicServer(boolean publicServer) {
        this.publicServer = publicServer;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     * Retorna o nome completo da pessoa
     * @return nome e sobrenome com espaço entre eles
     */
    public String fullName() {
        return name + " " + surname;
    }

    /**
     * Calcula o salário anual multiplicando o salário mensal por 12
     * @return salário anual
     */
    public float calculateYearlySalary() {
        return salary * 12;
    }

    /**
     * Calcula a idade da pessoa baseada na data de nascimento
     * @return idade em anos
     */
    private int getAge() {
        if (birthDate == null) {
            return 0;
        }

        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthDate);

        Calendar currentCalendar = Calendar.getInstance();

        int age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

        // Ajusta a idade se o aniversário ainda não passou este ano
        if (currentCalendar.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    /**
     * Verifica se a pessoa está habilitada a se registrar como MEI
     * @return true se pode ser MEI, false caso contrário
     */
    public boolean isMEI() {
        // Verifica se o salário anual é menor que R$ 130.000,00
        if (calculateYearlySalary() >= 130000) {
            return false;
        }

        // Verifica se tem mais de 18 anos
        if (getAge() <= 18) {
            return false;
        }

        // Verifica se não tem participação em outro negócio
        if (anotherCompanyOwner) {
            return false;
        }

        // Verifica se não é pensionista
        if (pensioner) {
            return false;
        }

        // Verifica se não é servidor público
        if (publicServer) {
            return false;
        }

        return true;
    }
}

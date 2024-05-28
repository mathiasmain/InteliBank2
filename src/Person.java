import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Person implements IUser
{
    public int          ID_account;
    private EUser       user_type;
    private String      first_name;
    private String      last_name;
    private LocalDate   birth_date;
    private String      email;
    private String      psw;
    private int         account_number;
    public double       balance;
    private LocalDate   start_date;
    public String       Status;

    // Construtores

    // P/ Login e ler da BD.
    public Person(int ID_account, String user_type, String first_name, String psw, int account_number, double balance)
    {

    }

    // P/ Novo usuário.
    public Person(EUser user_type,String first_name, String last_name, String birth_date, String email, String psw, int acc_nb) {
        this.user_type = user_type;
        setFirst_name(first_name);
        setLast_name(last_name);
        setBirth_date(birth_date);
        this.email = email;
        setPsw(psw);
        this.account_number = acc_nb;
        setBalance();
        setStart_date();
        setStatus();
        // LocalDate d = LocalDate.now();
    }

    // Setters

    public void setUserType(String s)
    {
        if(s.equals("ADMIN"))
        {
            this.user_type = EUser.ADMIN;
        }
        else
        {
            this.user_type = EUser.CLIENT;
        }
    }

    public void setFirst_name(String first_name) {
        if (!first_name.isBlank() && first_name.length() < 21 && first_name.matches("[a-zA-Z ]+")){
            this.first_name = first_name;
        }
        else if(first_name.isBlank() || first_name.length() > 20)
        {
            System.out.println("First name must be between 1 and 20 characters.");
        }
        else
        {
            System.out.println("First name must be string.");
        }
    }

    public void setLast_name(String last_name) {
        if (!last_name.isBlank() && last_name.length() < 41 && last_name.matches("[a-zA-Z ]+")) {
            this.last_name = last_name;
        }
        else if(last_name.isBlank() || last_name.length() > 41){
            System.out.println("Last name must be between 1 and 40 characters.");
        }
        else
        {
            System.out.println("Last name must be string.");
        }
    }

    public void setBirth_date(String birth_date) {
        if(birth_date.isBlank())
        {
            System.out.println("Birth date must be filled.");
        }
        LocalDate d = LocalDate.now();
        LocalDate b = LocalDate.parse(birth_date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try {

            if (!d.isBefore(b) && !b.isBefore(d.minusYears(124))) {
                this.birth_date = b;
            }
        } catch (Exception er) {
            System.out.println("Não foi possível confirmar a data de nascimento inserida. Erro: " + er);
        }
    }

    public void setPsw(String psw) {
        if (!psw.isBlank() && psw.length() < 21) {
            this.psw = psw;
        }
    }

    public void setBalance() {
        this.balance = 0.0f;
    }

    public void setStart_date() {
        try {
            this.start_date = LocalDate.now();
        } catch (Exception e) {
            System.out.println("Erro ao setar a data de início: " + e);
        }
    }

    public void setStatus() {
        this.Status = "Active";
    }

    // Getters

    public int getID_account() {
        return ID_account;
    }

    public EUser getEUser() {
        return user_type;
    }

    public String getFirst_Name() {
        return first_name;
    }

    public String getLast_Name() {
        return last_name;
    }

    public LocalDate getBirth_Date() {
        return birth_date;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public int getAccount_Number() {
        return account_number;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getStart_Date() {
        return start_date;
    }

    public String getStatus() {
        return Status;
    }


    // Métodos

}

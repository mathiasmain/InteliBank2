import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataOperation
{
    protected int                       ID_transaction;
    protected ETransactions             transaction;
    protected Double                    amount;
    protected java.time.LocalDateTime   date; // LocalDate.now()
    protected int                       ID1;

    // Construtor
    public DataOperation(ETransactions transaction, Double amount, int ID1){
        this.transaction = transaction;
        setAmount(amount);
        setDates();
        this.ID1 = ID1;
    }

    // Lendo da batadase
    public DataOperation(int id, ETransactions transaction, Double amount, String date,int ID1) {
        this.ID_transaction = id;
        this.transaction = transaction;
        this.amount = amount;
        this.date = java.time.LocalDateTime.parse(date);
        this.ID1 = ID1;
    }
    // Setters

    public void setAmount(Double amount)
    {
        if (amount > 0) {
            this.amount = amount;
        }
        System.out.println("Error, amount must be greater than 0.");
    }

    public void setDates()
    {
        this.date = java.time.LocalDateTime.now(); // timestamp in postgreSQL
    }

    // getters

    public int getIDTransaction()
    {
        return this.ID_transaction;
    }


}



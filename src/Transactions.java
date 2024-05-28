import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transactions extends DataOperation
{

    private int account_number;

    // Constructor
    public Transactions(int ID1 , Double amount, int account_number)
    {
        super(ETransactions.TRANSFER, amount, ID1);
        this.account_number = account_number;
    }


}

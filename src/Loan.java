public class Loan extends DataOperation
{
    private Double interest_rate;
    private Boolean isResolved = false;

    // Constructor

    // Criando empréstimo.
    public Loan(Double amount, int ID1, Double interest_rate, Boolean isResolved)
    {
        super(ETransactions.LOAN, amount, ID1);
        this.interest_rate = interest_rate;
        this.isResolved = false;

    }
    // Lendo da batadase
    public Loan(int id, Double amount, String date, int ID1, Double interest_rate, Boolean isResolved)
    {
        super(id, ETransactions.LOAN, amount, date, ID1);
        this.interest_rate = interest_rate;
        this.isResolved = isResolved;
    }

    // Getters
    public Double getInterest_rate()
    {
        return this.interest_rate;
    }

    public Boolean getIsresolved()
    {
        return this.isResolved;
    }
}




public enum ETransactions {
    TRANSFER, LOAN, LOAN_PAYMENT, BUY, SELL;

    public String toString(ETransactions josh) throws Exception {
        return switch (josh) {
            case TRANSFER ->        "TRANSFER";
            case LOAN ->            "LOAN";
            case LOAN_PAYMENT ->    "LOAN_PAYMENT";
            case BUY ->             "BUY";
            case SELL ->            "SELL";
            case null, default -> throw new Exception("Invalid transaction type.");
        };

    }

    public ETransactions toEnum(String josh) throws Exception
    {
        return switch (josh.toUpperCase()) {
            case "TRANSFER" ->      ETransactions.TRANSFER;
            case "LOAN" ->          ETransactions.LOAN;
            case "LOAN_PAYMENT" ->  ETransactions.LOAN_PAYMENT;
            case "BUY" ->           ETransactions.BUY;
            case "SELL" ->          ETransactions.SELL;
            case null, default -> throw new Exception("Invalid transaction type.");
        };

    }

}

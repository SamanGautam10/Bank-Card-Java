  



/**
 * Write a description of class BankCard here.
 * BankCard
 * @author (Saman Gautam)
 * @version (version 1.1)
 */
public class BankCard
{
    //data members of Bank Card
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private int balanceAmount;
    
    /** Bank Card Constructor **/
    public BankCard(int cardId, String issuerBank, String bankAccount, int balanceAmount)
    {
        this.cardId = cardId;
        this.clientName =  ""; //empty string
        this.issuerBank =  issuerBank;
        this.bankAccount = bankAccount;
        this.balanceAmount = balanceAmount;
    }
    
    //Getters Method (Accessor Method)
    public int getCardID()
    {
        return this.cardId;
    }
    
    public String getClientName()
    {
        return this.clientName;
    }
    
    public String getIssuerBank()
    {
        return this.issuerBank;
    }
    
    public String getBankAccount()
    {
        return this.bankAccount;
    }
    
    public int getBalanceAmount()
    {
        return this.balanceAmount;
    }
    
    //Setters Method (Mutator Method)
    public void setCardID(int cardId)
    {
        this.cardId =  cardId;
    }
    
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    
    public void setIssuerBank(String issuerBank)
    {
        this.issuerBank = issuerBank;
    }
    
    public void setBankAccount(String bankAccount)
    {
        this.bankAccount =  bankAccount;
    }
    
    public void setBalanceAmount(int balanceAmount)
    {
        this.balanceAmount =  balanceAmount;
    }
    
    /**This method will display CardID, ClientName, IssuerBank, BankAccount and BalanceAmount 
    * To compare the value of String we use ".equals"
    * If client name is not assigned then a message will be sent
    */
    
    public void display()
    {
        if(this.clientName.equals("")){
            System.out.println("Please fill the Client Name || Client Name cannot be left empty");
        }
        
        else{
        System.out.println("Card ID: "+this.cardId);
        System.out.println("Client Name: "+this.clientName);
        System.out.println("Issuer Bank:"+this.issuerBank);
        System.out.println("Bank Account: "+this.bankAccount);
        System.out.println("Balance Amount:"+this.balanceAmount);
        }     
    }
}
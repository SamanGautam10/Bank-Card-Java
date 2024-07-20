 



/**
 * Write a description of class CreditCard here.
 * CreditCard
 * @author (Saman Gautam)
 * @version (version 1.1)
 */
public class CreditCard extends BankCard
{
    //data members of credit card
    private int cvc_Num;
    private double creditLimit;
    private double interest_Rate;
    private String expiry_Date;
    private int grace_Period;
    private boolean isGranted;
    
    /** 
     * the keyword super is used to access variable of parent class in child class
     * the attribute isgranted is set to false
     */
    
    /** Credit Card Constructor **/
    public CreditCard(int cardId, String issuerBank, String bankAccount, String clientName, int balanceAmount, int cvc_Num, double interest_Rate, String expiry_Date)
    {
        super(cardId, issuerBank, bankAccount,balanceAmount);
        setClientName(clientName);
        this.cvc_Num = cvc_Num;
        this.interest_Rate =  interest_Rate;
        this.expiry_Date = expiry_Date;
        this.isGranted =  false;
    }
    
    //accessor method (Getters Method)
    public int getCvc_Num()
    {
        return this.cvc_Num;
    }
    
    public double getCreditLimit()
    {
        return this.creditLimit;
    }

    public double getInterest_Rate()
    {
        return this.interest_Rate;
    }
    
    public String getExpiry_Date()
    {
        return this.expiry_Date;
    }
    
    public int getGrace_Period()
    {
        return this.grace_Period;
    }
    
    public boolean getIsGranted()
    {
        return this.isGranted;
    }
    
    /** Method to set the credit card limit **/
    public void setCreditLimit(double newCreditLimit, int newGracePeriod)
    {
        if(newCreditLimit <= 2.5 * getBalanceAmount()){
            creditLimit = newCreditLimit;
            grace_Period = newGracePeriod;
            this.isGranted = true;
        }
        
        else{
            System.out.println("Please check your account balance and try again!!! Credit not granted!! ");
        }
    }
    
    
    //method to cancel client's credit card
    public void cancelCreditCard()
    {
        if(this.isGranted == true)
        {
            this.cvc_Num = 0;
            this.creditLimit = 0;
            this.grace_Period= 0;
            this.isGranted =  false;
            System.out.println("Credit Card Cancelled Successfully");
        }
        else{
            System.out.println("Credit Card not found to be cancelled");
        }
    }
    
    /** method to display the outputs overriding display() **/
    public void display()
    {
        super.display();
        System.out.println("CVC Number: " +this.cvc_Num);
        System.out.println("Card expiry date: " +this.expiry_Date);
        
        if(this.isGranted == true){
            System.out.println("Credit Limit: " +this.creditLimit);
            System.out.println("Grace Period: " +this.grace_Period);
        }
        else{
            System.out.println("Credit Limit Granted: Not Granted Yet!!!");
        }
    }
}

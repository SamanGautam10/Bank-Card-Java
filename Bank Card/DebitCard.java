 




/**
 * Write a description of class DebitCard here.
 * DebitCard
 * @author (Saman Gautam)
 * @version (version 1.1)
 */
public class DebitCard extends BankCard
{
    //data members of Debit Card
    private int pin_Num;
    private int withdrawlAmount;
    private String dateofWithdrawl;
    private boolean hasWithdrawn;

    /** 
     * the keyword super is used to access variable of parent class in child class
     * the attribute of haswithdrawn is set as false
     */

    /** Debit Card Constructor **/
    public DebitCard(int balanceAmount, int cardId, String bankAccount, String issuerBank, String clientName, int pin_Num)
    {
        super(cardId, issuerBank, bankAccount, balanceAmount); //Giving access to the private variables of parent class to child class
        super.setClientName(clientName);
        this.pin_Num = pin_Num;
        this.hasWithdrawn = false;
    }

    //Getter method (Accessor Method)
    public int getPin_Num()
    {
        return this.pin_Num;
    }

    public int getWithdrawlAmount()
    {
        return this.withdrawlAmount;
    }

    public String getDateOfWithdrawl()
    {
        return this.dateofWithdrawl;
    }

    public boolean getHasWithdrawn()
    {
        return this.hasWithdrawn;
    }

    //Setters method (Mutator Method)    
    public void setWithdrawlAmount(int withdrawlAmount)
    {
        this.withdrawlAmount = withdrawlAmount;
    }

    /**
     * If the pin number that is given by user matches to the setted pin number then money can be withdraw
     * If the withdrawl amount given by user is less than or equal to balance amount then the money is deducted from current balance amount
     */
    public void Withdraw (int withdrawlAmount, String dateofWithdrawl, int input_Pin)
    {
        if(input_Pin == getPin_Num()){
            if(withdrawlAmount <= getBalanceAmount()){
                setBalanceAmount(getBalanceAmount() - withdrawlAmount);
                this.withdrawlAmount = withdrawlAmount;
                this.dateofWithdrawl = dateofWithdrawl;
                this.hasWithdrawn = true;
                System.out.println("Money Withdrawn Successfully!!!");
                System.out.println("New Balance: " +getBalanceAmount());
            }

            else{
                System.out.println("Insufficient balance. Try Again!!!");
            }
        }
        
        else{
            System.out.println("Invalid Pin. Try Again!!!");
        }
    }

    /** method to display the output overriding display() of Bank Card **/
    public void display()
    {
        super.display();
        System.out.println("Pin Number: " +this.pin_Num);
        if(this.hasWithdrawn == true){
            System.out.println("Withdrawl Amount :" +withdrawlAmount);
            System.out.println("Date of Withdrawl :" +this.dateofWithdrawl);
        }
        
        else{
            System.out.println("Amount has not been withdrawn");
        }
    }
}
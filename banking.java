import java.util.Random;
import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;




class WithdrawRunnable implements Runnable{

    private BankAccount account;

    private int amount;

    private int id;

     

    public WithdrawRunnable(BankAccount anAccount, int anAmount, int anID) {

        account = anAccount;

        amount = anAmount;

        id = anID;

    }

     

    public void run() {

        try {

                account.withdraw(amount, id);

        } catch (InterruptedException exception) {}

    }

}
 class DepositRunnable implements Runnable{

    private static final int DELAY = 10;

    private BankAccount account;

    private int amount;

    private int id;

     

    public DepositRunnable(BankAccount anAccount, int anAmount, int anID) {

        account = anAccount;

        amount = anAmount;

        id = anID;

    }

     

    public void run() {

        try {

            //for (;;)/>/>/>/> {

                account.deposit(amount, id);

                Thread.sleep(DELAY);

            //}

        } catch (InterruptedException exception) {}

    }

}

 class BankAccountThreadRunner {

 

    private int MIN = 2;

    private int dMax = 100;

    private int wMax = 25;

     

    Random number = new Random();

     

    BankAccount account = new BankAccount();

    Thread d1 = new Thread(new DepositRunnable(account, 2 * (number.nextInt(dMax - MIN + 1) + MIN), 1));

    Thread d2 = new Thread(new DepositRunnable(account, 2 * (number.nextInt(dMax - MIN + 1) + MIN), 2));

    Thread d3 = new Thread(new DepositRunnable(account, 2 * (number.nextInt(dMax - MIN + 1) + MIN), 3));

     

    Thread w4 = new Thread(new WithdrawRunnable(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 4));

    Thread w5 = new Thread(new WithdrawRunnable(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 5));

    Thread w6 = new Thread(new WithdrawRunnable(account, 2 * (number.nextInt(wMax - MIN + 1) + MIN), 6));

    

     

    public static void main(String[] args) {

         

        System.out.println("Deposit Threads          Withdrawal Threads          Balance");

        System.out.println("---------------          ------------------          -------");

         

        for(int i = 0; i < 3; i++)

            new BankAccountThreadRunner();

    }

     

    public BankAccountThreadRunner() {

        d1.start();

        w4.start();

        d2.start();

        w5.start();

        d3.start();

        w6.start();

        

    }

     

}


 class BankAccount{

     

    private int balance;

    private final Lock balanceChangeLock;

    private Condition sufficientFundsCondition;

     

    public BankAccount() {

        balance = 0;

        balanceChangeLock = new ReentrantLock();

        sufficientFundsCondition = balanceChangeLock.newCondition();

    }

     

    public void deposit(int amount, int anID) throws InterruptedException {

         

        balanceChangeLock.lock();

         try {

             System.out.print("Thread " + anID + " deposits $" + amount);

             int newBalance = balance + amount;

             System.out.println("                               Balance is $" + newBalance);

             balance = newBalance;

             sufficientFundsCondition.signalAll();

         } finally {

             balanceChangeLock.unlock();

         }

    }

 

    public void withdraw(int amount, int anID) throws InterruptedException {

        balanceChangeLock.lock();

        try {

                     while (balance < amount)

                         sufficientFundsCondition.await();

 

                 if(balance < amount) {

                 System.out.print("                         Thread " + anID + " withdraws $" + amount);

                 System.out.println("     Thread" + anID + " blocked - insufficient funds");

                 }                 

                 else {

                        System.out.print("                         Thread " + anID + " withdraws $" + amount);

                    int newBalance = balance - amount;

                    System.out.println("      Balance is $" + newBalance);

                    balance = newBalance;

                }              

                sufficientFundsCondition.signalAll();

            //}

        } finally {

            balanceChangeLock.unlock();

        }

    }

     

    public int getBalance() {

        return balance;

    }

}

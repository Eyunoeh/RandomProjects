import java.util.Scanner;


abstract class key_pad{
    abstract public void wc();
    abstract public String main_menu();
    Scanner sc = new Scanner(System.in);
}

class Screen extends key_pad{
    public void wc(){
        System.out.println("Welcome!");
    }
    public String[] Acc_details(){
        System.out.print("Please enter your account number: ");
        String acc_number =  sc.nextLine();
        System.out.print("Enter your PIN: ");
        String acc_pin = sc.nextLine();
        return new String[]{acc_number,acc_pin};
    }
    public String main_menu(){
        System.out.println("Main Menu:");
        System.out.println("               1- View my balance");
        System.out.println("               2- Withdraw Cash");
        System.out.println("               3- Deposit Funds");
        System.out.println("               4- Exit");
        System.out.print("Enter a choice: ");
        return sc.nextLine();
    }
}
class Bank_database {
    public   String [] account_number = {"12345","56789","01478"};
    public  String [] account_pin = {"54321","98765","02588"};
    public Integer [] balance = {1000, 5000,3000};
}
class Atm extends Bank_database{
    public Boolean Security(String [] args){
        boolean chk_acc = false;
        boolean chk_pn = false;
        String tmp_acc_pn  = args[0];
        String tmp_acc_num = args[1];
        for (String accounts : account_number){
            if (tmp_acc_pn.equals(accounts)) {
                chk_acc = true;
                break;
            }
        }
        for (String pins : account_pin){
            if (tmp_acc_num.equals(pins)){
                chk_pn = true;
                break;
            }
        }
        return chk_pn && chk_acc;
    }
}
class Account extends Bank_database{
    public int Balance_inquiry(String[] args){
        String login_acc = args[0];
        String acc_1 = account_number[0];
        String acc_2 = account_number[1];
        String acc_3 = account_number[2];
        int bal = 0;
        if (login_acc.equals(acc_1)){
            bal = balance[0];
        } else if (login_acc.equals(acc_2)) {
            bal = balance[1];
        } else if ((login_acc.equals(acc_3))) {
            bal = balance[2];
        }
        return bal;
    }
}

class Transaction {
    public void transact(String args, int bal)throws InterruptedException{
        switch (args) {
            case "1" -> {
                System.out.println("Balance Information");
                System.out.println("Available Balance: $" + bal+"\n");
            }
            case "2" -> {
                System.out.println("Processing...");
                Thread.sleep(5000);
                System.out.println("Available Balance: $" + bal+"\n");
            }
            case "3" -> {

                System.out.println("""
                        NOTE: The money you just deposited will not be available until we verify the amount
                        of any enclose cash and your check clear.
                                            
                        Processing...""");
                Thread.sleep(5000);
                System.out.println("Available Balance: $" + bal+"\n");
            }
        }
    }
 }
class Cash_Dispenser {
    public int Withdrawal(int args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the withdraw amount in CENTS(or 0 to cancel ): ");
        int wd = sc.nextInt();
        int bal = args - wd;
        if (wd >= 0) {
            if (bal < 0) {
                System.out.println("Not enough Credits");
                return args;
            }
        }
        return bal;
    }
}
class Deposit_Slot {
    public int Deposit(int args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the deposit amount in CENTS(or 0 to cancel ): ");
        int dp = sc.nextInt();
        return args + dp;
    }
}


public class ATM_Case_Study {

    public static void main(String[] args) {
        Cash_Dispenser wd = new Cash_Dispenser();
        Deposit_Slot dp = new Deposit_Slot();
        String choice;
        Account acc = new Account();
        Transaction trs = new Transaction();
        Atm atm = new Atm();
        Screen sc = new Screen();

        sc.wc();
        boolean quit = false;
        int attempt = 5;
       while (attempt>0) {
           String [] acc_details = sc.Acc_details();
           boolean verification = atm.Security(acc_details);
           if (verification) {
               int bal = acc.Balance_inquiry(acc_details);
               do {
                   choice = sc.main_menu();
                   if ("1".equals(choice)) {
                       try {
                           trs.transact(choice, bal);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   } else if ("2".equals(choice)) {
                       try {
                           bal = wd.Withdrawal(bal);
                           trs.transact(choice, bal);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }else if ("3".equals(choice)) {
                       try {
                           bal = dp.Deposit(bal);
                           trs.transact(choice, bal);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
               }
               while (!choice.equals("4"));
               quit = true;
           }
           if (quit){
               break;
           }
           attempt--;
       }
    }
}
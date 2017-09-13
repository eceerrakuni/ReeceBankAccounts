import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.*;

public class DriverMenu {
	


	static int totAccNum = 4;
	
	static ArrayList<Account> accountArray = new ArrayList<Account>();
	
	static DecimalFormat moneyFormat = new DecimalFormat("#.##");
	
	public static void main(String[] args) {
		accountArray.add(new CheckingAccount("Reece", 15, "01/40/10", 0, 600.00, 1));
		accountArray.add(new SavingsAccount("Mark", 43, "03/12/83", 1, -100.00, 0));
		accountArray.add(new SavingsAccount("Francine", 29, "12/25/94", 2, 300.00, 0));
		accountArray.add(new CheckingAccount("Rachel", 37, "11/03/87", 3, -20.23, 1));
		accountArray.add(new SavingsAccount("Paul", 66, "11/05/55", 4, 204.45, 0));
		openMenu();
		}

	
	public static void openMenu() {
		Scanner s = new Scanner(System.in);
		System.out.println("" + "D)eposit  W)ithdrawal  M)onth end Q)uit");
		String b = s.nextLine();
		
		//deposit money
		if(b.equals("D") || b.equals("d")) {
			System.out.println("Account Number: ");
			int q = s.nextInt();
			Account temp = accountArray.get(q);
			System.out.println("Amount of Deposit: ");
			double w = s.nextDouble();
			temp.deposit(w);
			System.out.printf("\nBalance: %.2f", temp.getBalance());
			System.out.println("");
			openMenu();
		
		
		//withdrawing money
		} else if (b.equals("W") || b.equals("w") ){
			System.out.println("Account Number: ");
			int v = s.nextInt();
			Account temp = accountArray.get(v);
			if (temp.getType() == 1) {
				System.out.println("Amount of Withdrawl: ");
				double l = s.nextDouble();
				int wi =  ((CheckingAccount) temp).getWithdrawl();
				if (wi > 0) {
					((CheckingAccount) temp).withdrawls();
					System.out.println("Remaing Withdrawls: " + ((CheckingAccount) temp).getWithdrawl());
					temp.withdrawl(l);
					System.out.println("Balance: " + temp.getBalance());
					openMenu();
				} else if (wi <= 0){
					System.out.println("0 Free Withdrawls left. You have been charged a $1 Trans. Fee");
					temp.withdrawl(l + 1);
					System.out.printf("\nBalance: %.2f", temp.getBalance());
					System.out.println("");
					openMenu();
				}
			} else {
				System.out.println("Amount of Withdrawl: ");
				double p = s.nextDouble();
				temp.withdrawl(p);
				System.out.println("Balance: " + temp.getBalance());
					temp.checkLowBal(temp);
				openMenu();
		} 
			
		//month end	(resets withdrawl counter for checking accs., shows total interest for saving accs.
		} else if (b.equals("M") || b.equals("m")) {
			System.out.println("Account Number: ");
			int o = s.nextInt();
			Account temp = accountArray.get(o);
			if (temp.getType() == 1) {
				((CheckingAccount) temp).resetWithdrawl();
				System.out.println("Withdrawl Counter Reset!");
				openMenu();
			} else if (temp.getType() == 0) {
				double pint = temp.getLowBal();
				temp.interestDay(temp.getBalance());
				System.out.println("Interest Rate: 5%");
				System.out.printf("\nNew Balance: %.2f", temp.getBalance());
				System.out.println("");
				openMenu();
			}
				
		} else if (b.equals("q") || b.equals("Q")) {
			System.out.println("Are you sure you want to quit?" + "\n1)YES 2)NO");
			int quitter = s.nextInt();
			if (quitter == 1) {
			s.close();
			} else if (quitter == 2) {
				openMenu();
			}
		}
	}

}

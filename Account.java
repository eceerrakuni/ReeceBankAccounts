import java.util.Scanner;

public class Account {
	
	
	
	private double balance;
	private int type;
	private double lowestBalance;
	
	public double getBalance() {
		return balance;
	}
	
	public void checkLowBal(Account temp) {
		if (balance < lowestBalance){
			temp.setLowBal(balance);
		}
	}
	
	public double interestDay(double balance) {
		double a = 0.05;
		double interAmnt = (balance * 0.05);
		this.balance = balance + interAmnt;
		lowestBalance = this.balance;
		return this.balance;
	}
	
	public void setBalance(int eat) {
		balance = eat;
	}
	
	public double getLowBal() {
		return lowestBalance;
	}
	
	public void setLowBal(double input) {
		lowestBalance = input;
	}
	
	public Account(String name, int age, String dob, int accNum, double balance, int type) {
		this.balance = balance;
		this.type = type;
		lowestBalance = balance;
	}
	

	public double deposit(double depAmnt) {
		balance = balance + depAmnt;
		return balance;
	}
	
	public double withdrawl(double withAmnt) {
		balance = balance - withAmnt;
		return balance;
	}
	
	public int getType() {
		return type;
	}
	

}

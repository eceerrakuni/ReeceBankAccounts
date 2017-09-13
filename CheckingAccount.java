
public class CheckingAccount extends Account {
	
		private int withdrawl = 3;
		private int type = 1;
	
		public CheckingAccount(String name, int age, String dob, int accNum, double balance, int type) {
			super(name, age, dob, accNum, balance, type);
		}
		
		public void withdrawls() {
			withdrawl = withdrawl - 1;
		}
		
		public int getWithdrawl() {
			return withdrawl;
		}
		
		public void resetWithdrawl() {
			withdrawl = 3;
		}

}

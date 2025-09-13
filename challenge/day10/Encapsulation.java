package challenge.day10;

public class Encapsulation {

	/* Day 10 – Encapsulation
	 * Challenge: Create a BankAccount class with private balance and public deposit/withdraw methods.
	 * Objectives: Data hiding, getters/setters.
	 * Success Criteria: Balance can’t be directly modified outside the class.
	 */
		
	public static void main(String[] args) {
		BankAccount ba  = new BankAccount();
		
		System.out.println("Your money is: " + ba.getBalance());
		System.out.println("You deposit the amount of 3450 pesos");
		ba.deposit(3450);
		System.out.println("Check the amount of your money: " + ba.getBalance());
		System.out.println("I will withdraw some of my money.");
		ba.withdraw(450);
		System.out.println("The amount of money that has left is only: " + ba.getBalance());
	}

}

class BankAccount {
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withdraw(int amount) {
		this.balance -= amount;
	}
}
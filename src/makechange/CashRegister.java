package makechange;
import java.text.DecimalFormat;

public class CashRegister {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		double itemPrice = 0;
		double cashReceived = 0.;

		// Begin transaction
		do {
			System.out.println("Initiate Cash Register? Y/N ");
			String yesNo = input.next();
			System.out.println();
			if (yesNo.equals("N") || yesNo.equals("n")) {
				System.out.println("Register Closed");
				System.out.println();
				input.close();
				break;
				
			} else if (yesNo.equals("Y") || yesNo.equals("y")) {
				// Price the item
				System.out.println("Enter the Item Price: ");
				itemPrice = input.nextDouble();
				System.out.println();
				// Take cash from customer
				System.out.println("Enter Amount of Cash Received: ");
				cashReceived = input.nextDouble();
				DecimalFormat twoDecimals = new DecimalFormat("0.00");
				System.out.println();
				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("Cash: \t$" + (twoDecimals.format(cashReceived)));
				System.out.println("Price: \t$" + (twoDecimals.format(itemPrice)));
				
				// Calculate change, no change, or more cash needed
				if (cashReceived == itemPrice) {
					System.out.println("No Change Needed");
				} else if (cashReceived < itemPrice) {
					System.out.println("More Cash Needed");
				} else if (cashReceived > itemPrice) {
					double change = cashReceived - itemPrice;
					
					// Convert cash to pennies
					double changeDue = change * 100;
					double hundreds = changeDue/10000;
					changeDue = changeDue % 10000;
					double fifties = changeDue/5000;
					changeDue = changeDue % 5000;
					double twenties = changeDue/2000;
					changeDue = changeDue % 2000;
					double tens = changeDue/1000;
					changeDue = changeDue % 1000;
					double fives = changeDue/500;
					changeDue = changeDue % 500;
					double ones = changeDue/100;
					changeDue = changeDue % 100;
					double quarters = changeDue/25;
					changeDue = changeDue % 25;
					double dimes = changeDue/10;
					changeDue = changeDue % 10;
					double nickels = changeDue/5;
					changeDue = changeDue % 5;
					double pennies = changeDue;
					
					System.out.println("-----------------");
					System.out.println("Change: $" + String.format("%.2f", change));
					System.out.println("-----------------");
					System.out.println("-----------------");
					System.out.println();
					DecimalFormat noDecimals = new DecimalFormat("0");

					// Calculate bills & coins of change due
					if (hundreds >= 1) {
						hundreds = Math.round(hundreds * 100)/100;
						System.out.println(noDecimals.format(hundreds) + " Hundreds");
					} if (fifties >= 1) {
						fifties = Math.round(fifties * 100)/100;
						System.out.println(noDecimals.format(fifties) + " Fifties");
					} if (twenties >= 1) {
						twenties = Math.round(twenties * 100)/100;
						System.out.println(noDecimals.format(twenties) + " Twenties");
					} if (tens >= 1) {
						tens = Math.round(tens * 100)/100;
						System.out.println(noDecimals.format(tens) + " Tens");
					} if (fives >= 1) {
						fives = Math.round(fives * 100)/100;
						System.out.println(noDecimals.format(fives) + " Fives");						
					} if (ones >= 1) {
						ones = Math.round(ones * 100)/100;
						System.out.println(noDecimals.format(ones) + " Ones");
					} if (quarters >= 1) {
						quarters = Math.round(quarters * 100)/100;
						System.out.println(noDecimals.format(quarters) + " Quarters");
					} if (dimes >= 1) {
						dimes = Math.round(dimes * 100)/100;
						System.out.println(noDecimals.format(dimes) + " Dimes");
					} if (nickels >= 1) {
						nickels = Math.round(nickels * 100)/100;
						System.out.println(noDecimals.format(nickels) + " Nickles");
					} if (pennies >= 1) {
						pennies = Math.round(pennies * 100)/100;
						System.out.println(noDecimals.format(pennies) + " Pennies");
					}
					System.out.println();
				}
			}
		} while (true);
	}
}
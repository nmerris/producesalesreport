import java.util.Scanner;

public class ProduceSalesReport {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// user inputs
		String name;
		String phoneNumber;
		double preTaxSaleAmount;
		int taxCode;
		
		// calculated values
		double taxRate;
		double taxTotal;
		double saleTotal;
				
		
		// get input from user, in future this may be read in from a file
		System.out.println("Enter customer name: ");
		name = scanner.nextLine();
		
		System.out.println("Enter customer phone number: ");
		phoneNumber = scanner.nextLine();
		// could validate phone number here
		
		System.out.println("Enter pre tax sales amount: ");
		preTaxSaleAmount = scanner.nextDouble();
		
		// prompt the user for tax code until they enter 0, 1, or 2
		do {
			System.out.println("Enter tax code: ");
			taxCode = scanner.nextInt();
			
			if(!isValidTaxCode(taxCode)) {
				System.out.println("Valid tax codes are 0, 1, and 2");
			}
		} while(!isValidTaxCode(taxCode));
		

		
		

		// calculate tax rate
		switch(taxCode) {
			case 0: 
				taxRate = 0.0; // tax exempt
				break;
			case 1:
				taxRate = 0.03; // 3% tax
				break;
			case 2:
				taxRate = 0.05; // 5% tax
				break;
			default:
				taxRate = 0.0; // default to tax exempt, should never happen
		}
		
		// calculate taxTotal
		taxTotal = preTaxSaleAmount * taxRate;
		
		// calculate saleTotal
		saleTotal = preTaxSaleAmount + taxTotal;
		
		// display the sales record
		System.out.println("Sales Report");
		System.out.println("phone number: " + phoneNumber);
		System.out.println("name: " + name);
		// round to 2 decimal places so it looks nice, data precision is retained in variables
		System.out.printf("sale amount: $%.2f\n", preTaxSaleAmount);
		System.out.printf("tax: $%.2f\n", taxTotal);
		System.out.printf("sale total: $%.2f\n", saleTotal);
		
	} // main
	
	
	// returns true only for valid tax codes, false otherwise
	// valid tax codes are 0, 1, or 2
	static boolean isValidTaxCode(int taxCode) {
		if(taxCode != 0 && taxCode != 1 && taxCode != 2) return false;
		else return true;
	}
	
}

import java.util.*;

public class CurrencyConvertor
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY"};
        double[] exchangeRates = {1.0, 0.85, 0.75, 74.0, 110.0}; 
        
        System.out.println("Welcome to the Currency Converter!");
       
        System.out.println("Available currencies:");
        for (int i=0;i<currencies.length;i++) 
        {
            System.out.println((i + 1) + ". " + currencies[i]);
        }
        
        System.out.print("Select the source currency (1-" + currencies.length + "): ");
        int sourceIndex = getValidCurrencyIndex(sc,currencies.length) - 1;

        System.out.print("Select the target currency (1-" + currencies.length + "): ");
        int targetIndex = getValidCurrencyIndex(sc,currencies.length) - 1;

        System.out.print("Enter the amount in " + currencies[sourceIndex] + ": ");
        double amount = getValidAmount(sc);

        double convertedAmount = amount * exchangeRates[targetIndex] / exchangeRates[sourceIndex];

        System.out.printf("\n%.2f %s is equal to %.2f %s.\n",
                amount, currencies[sourceIndex], convertedAmount, currencies[targetIndex]);
        
        System.out.println("Thank you for using the Currency Converter!");

        sc.close();
    }

    private static int getValidCurrencyIndex(Scanner scanner, int maxOption) 
    {
        int index;
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            if (sc.hasNextInt())
            {
                index = sc.nextInt();
                if (index >= 1 && index <= maxOption) 
                {
                    return index;
                } 
                else
                {
                    System.out.print("Invalid selection. Please select a valid currency (1-" + maxOption + "): ");
                }
            } 
            else
            {
                System.out.print("Invalid input. Please enter a number between 1 and " + maxOption + ": ");
                sc.next();
            }
        }
    }

    private static double getValidAmount(Scanner scanner)
    {
    	Scanner sc=new Scanner(System.in);
        double amt;
        while (true)
        {
            if (sc.hasNextDouble())
            {
                amt = sc.nextDouble();
                if (amt>=0)
                {
                    return amt;
                } 
                else 
                {
                    System.out.print("Invalid amount. Please enter a positive value: ");
                }
            }
            else
            {
                System.out.print("Invalid input. Please enter a valid number: ");
                sc.next(); 
            }
        }
    }
}
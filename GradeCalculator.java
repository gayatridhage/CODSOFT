import java.util.*;

public class GradeCalc 
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");
        
        System.out.print("Enter the number of subjects: ");
        int n=sc.nextInt();
        
        int[] marks=new int[n];
        int total=0;
        
    
        for (int i=0; i<n; i++) 
        {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            int mark = sc.nextInt();

           
            while (mark<0 || mark>100) 
            {
                System.out.print("Invalid marks. Enter a value between 0 and 100: ");
                mark=sc.nextInt();
            }

            marks[i]=mark;
            total+=mark;
        }
     
        double avg=(double) total/n;
        
      
        String grade;
        if (avg>=90) 
        {
            grade="A+";
        } 
        else if (avg>=80)
        {
            grade="A";
        } 
        else if (avg>=70)
        {
            grade="B+";
        }
        else if (avg>=60) 
        {
            grade="B";
        } 
        else if (avg>=50)
        {
            grade="C";
        }
        else if (avg>=40)
        {
            grade="D";
        }
        else 
        {
            grade="F";
        }
        
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", avg);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
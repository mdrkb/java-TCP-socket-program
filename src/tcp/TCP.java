package tcp;
import java.util.Scanner;
/*
 * @author Rakibul Islam
 */
public class TCP {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter text: ");
       String input = sc.nextLine();
       
       input = input.replaceAll(" +", " ");
       String[] output = input.split(" ");
       int count = output.length;
       System.out.println("Number of words = "+count);
   } 
}

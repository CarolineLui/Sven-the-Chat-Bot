import java.util.Scanner;

/**
 * Runs Sven
 */
public class TestSven2
{
 public static void main(String[] args)
 {
  Sven2 sven = new Sven2();
  
  System.out.println(sven.getGreeting());
  Scanner reads = new Scanner(System.in);
  String statement = reads.nextLine();
  
  while (statement.toLowerCase().trim().indexOf("bye") < 0)
  {
   System.out.println(sven.getResponse(statement));
   statement = reads.nextLine();
  }
  System.out.println("Goodbye.");
 }

}



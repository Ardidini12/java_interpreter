package alb;

import java.util.Scanner;

public class InterpreterMain {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Interpreter v1.0");
        System.out.println("Shkruaj 'exit' për të dalë");
        
        while(true) {
            System.out.print(">>> ");
            String input = scanner.nextLine().trim();
            
            if(input.equalsIgnoreCase("exit")) break;
            if(input.isEmpty()) continue;
            
            try {
                interpreter.interpret(input);
            } catch (Exception e) {
                System.out.println("Gabim: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

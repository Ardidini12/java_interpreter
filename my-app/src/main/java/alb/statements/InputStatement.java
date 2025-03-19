package alb.statements;

import alb.Interpreter;
import java.util.Scanner;

public class InputStatement implements Statement {
    private final String variableName;
    private static final Scanner scanner = new Scanner(System.in);

    public InputStatement(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void execute(Interpreter interpreter) {
        System.out.print(variableName + " = ");
        int value = scanner.nextInt();
        interpreter.setVariable(variableName, value);
    }
}

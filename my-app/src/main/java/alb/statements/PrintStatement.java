package alb.statements;

import alb.Interpreter;

public class PrintStatement implements Statement {
    private final String variableName;

    public PrintStatement(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void execute(Interpreter interpreter) {
        System.out.println(variableName + " = " + interpreter.getVariable(variableName));
    }
}

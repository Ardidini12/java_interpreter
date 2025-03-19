package alb.statements;

import alb.Interpreter;

public class AssignmentStatement implements Statement {
    private final String variableName;
    private final String expression;

    public AssignmentStatement(String variableName, String expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void execute(Interpreter interpreter) {
        // Implement logic to evaluate the expression and assign it to the variable
        int value = evaluateExpression(expression, interpreter);
        interpreter.setVariable(variableName, value);
    }

    private int evaluateExpression(String expression, Interpreter interpreter) {
        // Simple implementation for evaluating arithmetic expressions
        try {
            // Use a script engine to evaluate the expression
            javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = manager.getEngineByName("JavaScript");
            return ((Number) engine.eval(expression)).intValue();
        } catch (Exception e) {
            throw new RuntimeException("Invalid expression: " + expression);
        }
    }
} 
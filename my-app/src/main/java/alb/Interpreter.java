package alb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import alb.statements.Statement;

public class Interpreter {
    private final Map<String, Integer> variables = new HashMap<>();
    private final Lexer lexer = new Lexer();

    public void interpret(String input) {
        List<Token> tokens = lexer.tokenize(input);
        Parser parser = new Parser(tokens);
        Statement statement = parser.parse();
        statement.execute(this);
    }

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        return variables.getOrDefault(name, 0);
    }
}

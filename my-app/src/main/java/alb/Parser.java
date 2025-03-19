package alb;

import java.util.List;
import alb.statements.Statement;
import alb.statements.InputStatement;
import alb.statements.PrintStatement;
import alb.statements.AssignmentStatement;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Statement parse() {
        if(match(TokenType.KEYWORD, "LEXO")) {
            return parseInputStatement();
        } else if(match(TokenType.KEYWORD, "AFISHO")) {
            return parsePrintStatement();
        } else if(peek().type == TokenType.IDENTIFIER) {
            return parseAssignment();
        }
        throw new RuntimeException("Sintaksë e pavlefshme");
    }

    private Statement parseInputStatement() {
        Token variable = consume(TokenType.IDENTIFIER, "Pritje për emër variablash");
        return new InputStatement(variable.lexeme);
    }

    private Statement parsePrintStatement() {
        Token variable = consume(TokenType.IDENTIFIER, "Pritje për emër variablash");
        return new PrintStatement(variable.lexeme);
    }

    private Statement parseAssignment() {
        String varName = advance().lexeme;
        consume(TokenType.OPERATOR, "=");
        // Implemento logjikën për shprehje aritmetike
        String expression = remainingTokensAsString();
        return new AssignmentStatement(varName, expression);
    }

    private boolean match(TokenType type, String value) {
        if(check(type, value)) {
            advance();
            return true;
        }
        return false;
    }

    private Token consume(TokenType type, String errorMessage) {
        if(check(type)) return advance();
        throw new RuntimeException(errorMessage);
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return current >= tokens.size();
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private String remainingTokensAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = current; i < tokens.size(); i++) {
            sb.append(tokens.get(i).lexeme).append(" ");
        }
        return sb.toString().trim();
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().type == type;
    }

    private boolean check(TokenType type, String value) {
        if (isAtEnd()) return false;
        Token token = peek();
        return token.type == type && token.lexeme.equals(value);
    }
}

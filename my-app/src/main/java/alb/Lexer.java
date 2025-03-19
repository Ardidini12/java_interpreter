package alb;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
        "(?i)(LEXO|AFISHO)|" +       // Keywords
        "(\\d+)|" +                  // Numra
        "(\\+|-|\\*|/|=|;)|" +       // Operatorët
        "([a-zA-Z_][a-zA-Z0-9_]*)|" + // Identifikatorët
        "(\\S)"                      // Gabim
    );

    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(input);
        
        while(matcher.find()) {
            if(matcher.group(1) != null) {
                tokens.add(new Token(TokenType.KEYWORD, matcher.group(1)));
            } else if(matcher.group(2) != null) {
                tokens.add(new Token(TokenType.NUMBER, matcher.group(2)));
            } else if(matcher.group(3) != null) {
                tokens.add(new Token(TokenType.OPERATOR, matcher.group(3)));
            } else if(matcher.group(4) != null) {
                tokens.add(new Token(TokenType.IDENTIFIER, matcher.group(4)));
            } else {
                throw new RuntimeException("Karakter i panjohur: " + matcher.group(5));
            }
        }
        return tokens;
    }
}

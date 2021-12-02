package dev.gerardo.behaviourals.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.gerardo.behaviourals.interpreter.Token.Type;

class Token {

  public enum Type {
    INTEGET,
    PLUS,
    MINUS,
    LPAREN,
    RPAREN
  }

  public Type type;
  public String text;

  public Token(Type type, String text) {
    this.type = type;
    this.text = text;
  }

  public String toString() {
    return "`" + text + "`";
  }
}

public class LexicalInterpreterDemo {

  static List<Token> lex(String input) {
    List<Token> tokens = new ArrayList<>();

    for (int i = 0; i < input.length(); i++) {
      switch (input.charAt(i)) {
        case '+':
          tokens.add(new Token(Type.PLUS, "+"));
          break;
        case '-':
          tokens.add(new Token(Type.MINUS, "-"));
          break;
        case '(':
          tokens.add(new Token(Type.LPAREN, "("));
          break;
        case ')':
          tokens.add(new Token(Type.RPAREN, ")"));
          break;
        default:
          StringBuilder sb = new StringBuilder("" + input.charAt(i));

          for (int j = i + 1; j < input.length(); ++j) {
            if (Character.isDigit(input.charAt(j))) {
              sb.append(input.charAt(j));
              i++;
            } else {
              tokens.add(new Token(Type.INTEGET, sb.toString()));
              break;
            }
          }
          break;
      }
    }

    return tokens;
  }

  static Element parse(List<Token> tokens) {
    BinaryOperation result = new BinaryOperation();
    boolean haveLHS = false;

    for (int i = 0; i < tokens.size(); ++i) {
      Token token = tokens.get(i);

      switch (token.type) {
        case INTEGET:
          Integer number = new Integer(java.lang.Integer.parseInt(token.text));
          if (!haveLHS) {
            result.left = number;
            haveLHS = true;
          } else {
            result.right = number;
          }
          break;
        case PLUS:
          result.type = BinaryOperation.Type.ADDITION;
          break;
        case MINUS:
          result.type = BinaryOperation.Type.SUBSTRACTION;
          break;
        case LPAREN:
          int j = 0;
          for (; j < tokens.size(); ++j) {
            if (tokens.get(j).type == Token.Type.RPAREN) {
              break;
            }
          }
          List<Token> subExpression = tokens.stream()
              .skip(i + 1)
              .limit(j - i - 1)
              .collect(Collectors.toList());

          Element element = LexicalInterpreterDemo.parse(subExpression);
          if (!haveLHS) {
            result.left = element;
            haveLHS = true;
          } else {
            result.right = element;
          }
          i = j;
          break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String input = "(13+14)-(12+1)";
    List<Token> tokens = lex(input);
    System.out.println(tokens.stream()
        .map(t -> t.toString())
        .collect(Collectors.joining("\t")));

    Element parsed = LexicalInterpreterDemo.parse(tokens);
    System.out.println(input + " = " + parsed.eval());
  }
}

/**
* This is the Notation class
*
*
* @author Fatima Mancia
*
*/
import java.lang.*;
import java.util.Scanner;
import java.util.*;
public class Notation {
  private static final String OPERATORS = "*/=+-";
  private static final String NUMBERS = "0123456789";
  Notation() {
  }
  /**
	 * evaluatePostfixExpression evaluates the postfix expression.
   * @param postfixExpr a String variable.
	 * @return ret.
	 *
	 */
  public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
    NotationStack<Double> stack = new NotationStack<Double>(postfixExpr.length());
    double ret = Double.NaN;
    for (int i = 0; i < postfixExpr.length(); i++) {
      Character symbol = postfixExpr.charAt(i);
      if (OPERATORS.indexOf(symbol) >= 0) {
        double num1, num2;
        try {
          num1 = stack.pop();
          num2 = stack.pop();
          if (symbol.equals('*')) {
            stack.push(num2 * num1);
          }
          else if (symbol.equals('/')) {
            stack.push(num2 / num1);
          }
          else if (symbol.equals('+')) {
            stack.push(num2 + num1);
          }
          else {
            stack.push(num2 - num1);
          }
        }
        catch (Exception e) {
            throw new InvalidNotationFormatException("Insuficient operands");
        }
      }
      else if (symbol >= '0' && symbol <= '9') {
        double sym = (double) symbol - '0';
        try {
          stack.push(sym);
        }
        catch (Exception e) {
        }
      }
      else {
        throw new InvalidNotationFormatException("Invalid Notation Format");
      }
    }
    try {
      ret = stack.pop();
    }
    catch (Exception e) {
        throw new InvalidNotationFormatException("Insuficient operands");
    }
    if (stack.size() > 0) {
        throw new InvalidNotationFormatException("Too many operands");
    }
    return ret;
  }
  /**
	 * convertPostfixToInfix converts from postfix to infix.
   * @param postfixExpr a String variable.
	 * @return ret.
	 *
	 */
  public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
    NotationStack<String> stack = new NotationStack<String>(postfix.length());
    String ret = "";
    try {
      for (int i = 0; i < postfix.length(); i++) {
        Character c = postfix.charAt(i);
        if (Character.isWhitespace(c))
          continue;
        else if (Character.isDigit(c))
          stack.push(Character.toString(c));
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
          if (stack.size() < 2)
            throw new InvalidNotationFormatException("Too few operands");
          String op2 = stack.pop();
          String op1 = stack.pop();
          String aux = "(" + op1 + Character.toString(c) + op2 + ")";
          stack.push(aux);
        }
        else 
          throw new InvalidNotationFormatException("Invalid symbol found");
      }
      if (stack.size() != 1)
        throw new InvalidNotationFormatException("Number of operators mismatch");
      ret = stack.toString();
    }
    catch (Exception e) {
      throw new InvalidNotationFormatException("An error ocurred");
    }
    return ret;
  }
  /**
	 * convertInfixToPostfix converts from infix to postfix.
   * @param infix a String variable.
	 * @return ret.
	 *
	 */
  public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
    int len = infix.length();
    Character top = ' ';
    String ret = "";
    NotationStack<Character> operators = new NotationStack<Character>(infix.length());
    NotationStack<String> postfix = new NotationStack<String>(infix.length());
    for (int i = 0; i < len; i++) {
        Character c = infix.charAt(i);
        if (c >= '0' && c <= '9') {
            try {
                postfix.push(String.valueOf(c));
            } catch (Exception e) {
            }
        }
        else if ("+-*/(".indexOf(c) >= 0) {
            try {
                operators.push(c);
            } catch (Exception e) {
            }
        }
        else if (c == ')') {
            while (true) {
                try {
                  top = operators.top();  
                } catch (Exception e) {
                    throw new InvalidNotationFormatException("Parenthesis don't match");
                }
                if (top == '(')
                    break;
                try {
                    Character op = operators.pop();
                    String value1 = postfix.pop();
                    String value2 = postfix.pop();
                    postfix.push(value2 + value1 + op);
                } catch( Exception e) {
                }
            } 
            try {
                operators.pop();
            } catch (Exception e) {
            }
        }
    }
    while (operators.size() != 0) {
        try {
            Character op = operators.pop();
            String value1 = postfix.pop();
            String value2 = postfix.pop();
            postfix.push(value2 + value1 + op);
        } catch (Exception e) {
        }
    }
    try {
        ret = postfix.pop();
    } catch (Exception e) {

    }
    return ret;
  }
}

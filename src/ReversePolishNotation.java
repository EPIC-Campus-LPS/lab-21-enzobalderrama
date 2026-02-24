import java.util.EmptyStackException;
import java.util.Stack;
public class ReversePolishNotation {

    public static int evaluatePostFix(String input) {
        Stac ack = new Stac();
        String repetitive;
        String numbers = "0123456789";
        for (int i = 0; i < input.length(); i++) {
            repetitive = input.substring(i, i + 1);
            if (repetitive.equals(" ")) {

            } else if (numbers.contains(repetitive)) {
                ack.push(Integer.parseInt(repetitive));
            } else if (ack.size() < 2) {
                throw new IllegalArgumentException("Is not in PostFix to evaluate");
            } else if (repetitive.equals("+")) {
                ack.push(ack.pop() + ack.pop());
            } else if (repetitive.equals("-")) {
                int subt = ack.pop();
                ack.push(ack.pop() - subt);
            } else if (repetitive.equals("*")) {
                ack.push(ack.pop() * ack.pop());
            } else if (repetitive.equals("/")) {
                int divi = ack.pop();
                ack.push(ack.pop() / divi);
            } else {
                throw new IllegalArgumentException("Is not in PostFix to evaluate");
            }
        }
        if (ack.isEmpty() || ack.size() > 1) {
            throw new IllegalArgumentException("Is not in PostFix to evaluate");
        }
        return ack.peek();
    }


    public static String infixToPostFix(String input) {
        // If it is a number or a letter add it to the output
        // If it is an operator, check the stack
        // If the operator on the stack is lower precedence, then add the new one
        // If the operator on the stack is higher or the same precedence, then pop it and add it to the stack and check the next one for precedence
        // If closed parenthsis, pop everything until the first one

        Stack st = new Stack();
        String finalStr = "";
        String justNumbers = "0123456789";
        for (int i = 0; i < input.length(); i++) {
            String one = input.substring(i, i + 1);
            if (one.equals(" ")) {

            } else if (justNumbers.contains(one)) {
                finalStr += one;
            } else if (one.equals("(")) {
                st.push(one);
            } else if (one.equals(")")) {
                while (!st.isEmpty() && !st.peek().equals("(")) {
                    finalStr += st.pop() + " ";
                }
                if (!st.isEmpty()){
                    st.pop();
                }
            } else if (one.equals("*") || one.equals("/")) {
                if (!st.isEmpty() && (st.peek().equals("(") || st.peek().equals(")") || st.peek().equals("/") || st.peek().equals("*"))) {
                    finalStr += st.pop();
                    st.push(one);
                } else {
                    st.push(one);
                }
            } else if (one.equals("-") || one.equals("+")) {
                if (!st.isEmpty() && (st.peek().equals("(") || st.peek().equals(")") || st.peek().equals("/") || st.peek().equals("*"))) {
                    finalStr += st.pop();
                    st.push(one);
                } else {
                    st.push(one);
                }
            }

        }
        while (!(st.isEmpty())) {
            finalStr += st.pop();
            }
        return finalStr;
    }
}
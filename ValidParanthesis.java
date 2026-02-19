import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stck.push(s.charAt(i));
            } else {
                if (!stck.empty() &&
                        ((stck.peek() == '(' && s.charAt(i) == ')') ||
                                (stck.peek() == '{' && s.charAt(i) == '}') ||
                                (stck.peek() == '[' && s.charAt(i) == ']'))) {
                    stck.pop();
                } else {
                    return false;
                }
            }
        }
        if (stck.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParanthesis obj = new ValidParanthesis();
        System.out.println(obj.isValid("([)]"));
        System.out.println(obj.isValid("{[)]"));
        System.out.println(obj.isValid("[()]"));
    }
}


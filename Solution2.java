import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Do not modify the class header.
 */
public class Solution2 {
    /**
     * The method for you to implement.
     *
     * DO NOT change the method header.
     */
    public boolean isBalanced(String s) {
        //Implement Deque interface
        Deque<Character> stack = new ArrayDeque<Character>(); // I create DEQUE object by using ARRAYDEQUE class

        //Traverse
        for (int i = 0; i < s.length(); ++i) {
            // I check the current "Characters" --> for opening brackets like (, {, and [
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') { // if one of these occur/exits --> true for one of these brackets
                stack.push(s.charAt(i)); // Then, PUSH the character on the stack --> ADD them on the empty stack
            } else { //Otherwise, Check on top of the stack is EMPTY
                if (stack.isEmpty()) {return false; // return "No" BECAUSE there is no corresponding opening brackets
                } else { //Otherwise, if the compiler sees the closing bracket --> execute the following
                    char pop = stack.pop(); // remove function for stack --> pop the value off the stack --> if there is closing brackets
                    //if they are MATCHED(TRUE) --> remove OPENING brackets off the stack --> if they are UNMATCHED(FALSE)--> return
                           if (s.charAt(i) == ')' && pop != '(') {return false;
                    } else if (s.charAt(i) == ']' && pop != '[') {return false;
                    }
                }
            }
        }
        return stack.isEmpty(); // Last check for stack if it is EMPTY --> return
    }
    /**
     * The main method is for test only and won't be evaluated.
     */
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isBalanced("()")); // should be true
        System.out.println(solution.isBalanced("(")); // should be false
        System.out.println(solution.isBalanced("(])")); // should be false
    }
}
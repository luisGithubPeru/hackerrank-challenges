import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    // Complete the isBalanced function below.

    
        /* RULES
        if stack is empty
            save to stack
        else if opening Bracket 1: if next bracket enclosing one
                if it is my enclosing one
                    pop of the stack
                else 
                    return False
        {}
        else opening Bracket 1: if next bracket is another openingBracket
            save to stack
        {[
            
        [{}]
        stack : [
        stack : [{
        stack : [
        stack : 
        
        [{)}]
        stack : [
        stack : [{
        dies here
        */

    final static String YES = "YES";
    final static String NO = "NO";
    
    static String isBalanced(String s) {

        HashMap<Character,Character> brackets = new HashMap<>();
        brackets.put('{','}');
        brackets.put('[',']');
        brackets.put('(',')');

        HashMap<Character,Character> endbrackets = new HashMap<>();
        endbrackets.put('}',null);
        endbrackets.put(']',null);
        endbrackets.put(')',null);
        LinkedList<Character> stack = new LinkedList<>();

        for(char c : s.toCharArray()){
          
            if(stack.isEmpty()){
                if(brackets.containsKey(c))
                    stack.addLast(c);
                else 
                    return NO;
            } else if (endbrackets.containsKey(c)){
                if(brackets.get(stack.peekLast()).equals(c))
                    stack.removeLast();
                else
                    return NO;
            }else if (brackets.containsKey(c)){
                stack.addLast(c);
            }
        }
        return stack.isEmpty() ? YES : NO;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


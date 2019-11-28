import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        final String APPEND = "A";
        final String DELETE = "D";
        
        StringBuilder s = new StringBuilder();
        Deque<String> historyStack = new ArrayDeque<>();
        Deque<String> revertStack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        StringBuilder output = new StringBuilder();
        for(int i=0; i<q; i++){
            switch(scanner.nextInt()){
                case 1:
                    // append
                    historyStack.push(APPEND);
                    revertStack.push(Integer.toString(s.length()));
                    s.append(scanner.next());           
                    break;
                case 2: 
                    // delete
                    historyStack.push(DELETE);
                    int deleteFromIndex = s.length() - scanner.nextInt();
                    revertStack.push(s.substring(deleteFromIndex));
                    s.setLength(deleteFromIndex);
                    break;
                case 3:
                    //print
                    output.append(s.charAt(scanner.nextInt() - 1) + "\n");
                    break;
                case 4:            
                    if(historyStack.pop().equals(APPEND)){
                        // revert append
                        s.setLength(Integer.parseInt(revertStack.pop()));
                    }else{
                        // revert delete
                        s.append(revertStack.pop());                        
                    }
                break;
            }
        }
        System.out.println(output);
    }
}


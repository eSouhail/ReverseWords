import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner initialization
        System.out.print("Enter a string: "); //prompting the user
        String input = scanner.nextLine();
        scanner.close();

        String reversed = reverseWords(input);
        System.out.println("Reversed words: " + reversed); //printing the results
    }
    //method to reverse the words
    public static String reverseWords(String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        LinkedStack<Character> stack = new LinkedStack<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                stack.push(c);
            } else {
                while (!stack.isEmpty()) {
                    word.append(stack.pop());
                }
                result.append(word).append(' ');
                word.setLength(0); 
            }
        }

        //this loop is to handle the last word
        while (!stack.isEmpty()) {
            word.append(stack.pop());
        }
        result.append(word);

        return result.toString();
    }
}
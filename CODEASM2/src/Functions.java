import implementations.*;

import java.util.Scanner;

public class Functions {
    public static String enterMessages() {
        System.out.print("Enter your messages: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void sendMessages(String text, Queue<String> S1) throws IllegalArgumentException{
        int i = 0;
        Scanner sc = new Scanner(System.in);
        String[] messages = text.split("\\.");
        while (i < messages.length){
            if (messages[i].length() <= 0){
                throw new IllegalArgumentException();
            } else if (messages[i].length() > 251){
                throw new IllegalArgumentException();
            } else {
                S1.offer(messages[i]);
                i++;
            }
        }
        if (messages.length < 2) {
            System.out.println("Messages have " + messages.length + " sentence");
        }
        else {
            System.out.println("Messages have " + messages.length + " sentences");
        }
    }

    public static void handleStack(Queue<String> S1, Stack<String> S2){
        while (!S1.isEmpty()){
            S2.push(S1.peek());
            S1.poll();
        }
    }

    public static void Stack(Stack<String> S2){
        System.out.print("Message: ");
        while (!S2.isEmpty()){
            System.out.println(S2.pop());
        }
    }
}
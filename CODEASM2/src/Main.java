import implementations.*;

public class Main {
    public static void main(String[] args) {
       Queue<String> S1 = new Queue<>();
       Stack<String> S2 = new Stack<>();

      try{
          double begin = System.currentTimeMillis();
          Functions.sendMessages(Functions.enterMessages(),S1);
          Functions.handleStack(S1,S2);
          Functions.Stack(S2);
          double end = System.currentTimeMillis();
          double time = (end - begin);
          System.out.println("Message has been sent successfully");
          System.out.printf("Time: %.1f ms", time);
      } catch (IllegalArgumentException e){
          System.out.println("Message is longer than 250 characters or is not valid");
      }
    }
}

// Medium Level: Card Collection System
import java.util.*;

public class CardCollection {
    public static void main(String[] args) {
        Map<String, List<String>> cards = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        cards.put("Hearts", Arrays.asList("A", "2", "3", "4", "5"));
        cards.put("Spades", Arrays.asList("6", "7", "8", "9", "10"));
        cards.put("Diamonds", Arrays.asList("J", "Q", "K"));
        
        System.out.print("Enter symbol to search (Hearts/Spades/Diamonds): ");
        String symbol = sc.next();
        
        if (cards.containsKey(symbol)) {
            System.out.println("Cards in " + symbol + ": " + cards.get(symbol));
        } else {
            System.out.println("Symbol not found.");
        }
        sc.close();
    }
}
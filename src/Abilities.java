import java.util.ArrayList;
import java.util.Scanner;

public class Abilities {

    public Deck deck;

    public Abilities(Deck dc){
        this.deck = dc;
    }

    public void seeFuture(){
        System.out.println("The next 3 cards in the deck are: ");
        ArrayList<Integer> dp = deck.getDrawPile();
        for(int i = 0; i < 3; i++){
            System.out.println(deck.getCardName(dp.get(i)));
        }
        System.out.println();
    }


    public String alterTheFuture(){
        System.out.println("The next 3 cards in the deck are: ");
        ArrayList<Integer> dp = deck.getDrawPile();
        for(int i = 0; i < 3; i++){
            int e = i + 1;
            System.out.println(e + ". " + deck.getCardName(dp.get(i)));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the order you would like? Enter 3 numbers with spaces to indicate new order. Ex: 3 1 2");
        String res = sc.nextLine();
        System.out.println();
        return res;

    }

}

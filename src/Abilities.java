import java.util.ArrayList;

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

    public void attack(){

    }

    public void tacoCat(){

    }

    public void hairyCat(){

    }

    public void drawFromBottom(){

    }

    public void alterTheFuture(){

    }

}

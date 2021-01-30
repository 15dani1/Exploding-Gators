import java.util.ArrayList;

public class Player {

    public ArrayList<Integer> deck;
    public String name;

    public Player(String name, ArrayList<Integer> startHand) {
        this.name = name;
        this.deck = startHand;
    }

    public ArrayList<Integer> getDeck(){
        return this.deck;
    }

    public void removeCard(int index){
        this.deck.remove(index);
    }

    public void addCard(int card){
        this.deck.add(card);
    }

}

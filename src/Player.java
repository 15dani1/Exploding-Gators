import java.util.ArrayList;
import java.util.Random;

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

    public int getRandomCard(){
        int size = this.deck.size();
        Random rnd = new Random();
        int element = rnd.nextInt(size);
        int ans = this.deck.get(element);
        this.deck.remove(element);
        return ans;
    }

    public void removeCard(int index){
        this.deck.remove(index);
    }

    public void addCard(int card){
        this.deck.add(card);
    }

}

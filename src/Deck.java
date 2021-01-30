import java.util.HashMap;
import java.util.Random;

public class Deck {

    public static HashMap<Integer, String> cards = new HashMap<>();
    public static HashMap<String, Integer> cardCount = new HashMap<>();

    int numPlayers = 0;
    //5 cards per player
    //1 must be diffuse
    //No exploding gator cards
    //1. Diffuse [number of players + 1]
    //2. Exploding Kitten [number of players]
    //3. See the Future (see next 3 cards in the deck) [5]
    //4. Skip [6]
    //5. Shuffle (draw pile shuffles) [4]
    //6. Attack (end turn without draw, next player draw 2 cards) [7]
    //7. Taco Cat (1 useless, 2 you can steal 1 random card from next opponent) [6]
    //8. Hairy Potato Cat (same as Taco cat) [6]
    //9. Draw from the bottom (draw last card) [4]
    //10. Alter the Future (rearrange the top 3 cards in your order of choosing) [3]

    public Deck(int numPlayers){
        this.numPlayers = numPlayers;
        createCards();
    }

    public void createCards(){

        cardCount.put("Diffuse", this.numPlayers + 1);
        cardCount.put("Exploding Kitten", this.numPlayers);
        cardCount.put("See the Future", 5);
        cardCount.put("Skip", 6);
        cardCount.put("Shuffle", 4);
        cardCount.put("Attack", 7);
        cardCount.put("Taco Cat", 6);
        cardCount.put("Hairy Potato Cat", 6);
        cardCount.put("Draw from Bottom", 4);
        cardCount.put("Alter the Future", 3);

        cards.put(1, "Diffuse");
        cards.put(2, "Exploding Kitten");
        cards.put(3, "See the Future");
        cards.put(4, "Skip");
        cards.put(5, "Shuffle");
        cards.put(6, "Attack");
        cards.put(7, "Taco Cat");
        cards.put(8, "Hairy Potato Cat");
        cards.put(9, "Draw from Bottom");
        cards.put(10, "Alter the Future");

    }

    public void createHand(){
        Random rand = new Random();
        int randInt = rand.nextInt(8) + 3;
        //String currCard = cards.get(randInt);

        System.out.println(randInt);
    }


}

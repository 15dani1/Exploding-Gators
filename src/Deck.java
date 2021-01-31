import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Deck {

    public static HashMap<Integer, String> cards = new HashMap<>();
    public static HashMap<String, Integer> cardCount = new HashMap<>();
    public static ArrayList<Integer> drawPile;

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

        cardCount.put("Defuse", this.numPlayers + 1);
        cardCount.put("Exploding Kitten", this.numPlayers);
        cardCount.put("See the Future", 5);
        cardCount.put("Skip", 6);
        cardCount.put("Shuffle", 4);
        cardCount.put("Attack", 7);
        cardCount.put("Taco Cat", 6);
        cardCount.put("Hairy Potato Cat", 6);
        cardCount.put("Draw from Bottom", 4);
        cardCount.put("Alter the Future", 3);

        cards.put(1, "Defuse");
        cards.put(2, "Exploding Kitten");
        cards.put(3, "See the Future");
        cards.put(4, "Skip");
        cards.put(5, "Shuffle");
        cards.put(6, "Attack");
        cards.put(7, "Taco Cat"); // 2 of them - gets a random card from next player's deck
        cards.put(8, "Hairy Potato Cat"); // 2 of them - gets a random card from next player's deck
        cards.put(9, "Draw from Bottom");
        cards.put(10, "Alter the Future");

    }

    public HashMap<Integer, String> getCards(){
        return Deck.cards;
    }

    public ArrayList<Integer> createHand(){
        Random rand = new Random();
        ArrayList<Integer> hand = new ArrayList<>(5);
        hand.add(1);
        for(int i = 0; i < 4; i++){
            boolean notassigned = true;
            while(notassigned) {
                int randInt = rand.nextInt(8) + 3; //Random number between 3 and 10
                if (cardCount.get(cards.get(randInt)) > 0) {
                    hand.add(randInt);
                    String currentCard = cards.get(randInt);
                    cardCount.put(currentCard, cardCount.get(currentCard) - 1);
                    notassigned = false;
                }
            }
        }

        return hand;
    }

    public ArrayList<Integer> createDrawPile(){
        drawPile = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            while(cardCount.get(cards.get(i+1)) != 0){
                drawPile.add(i+1);
                cardCount.put(cards.get(i+1), cardCount.get(cards.get(i+1)) - 1);
            }
        }
        Collections.shuffle(drawPile);
        return drawPile;
    }

    public void changeDrawPile(String[] res){
        int a = Integer.parseInt(res[0]);
        int b = Integer.parseInt(res[1]);
        int c = Integer.parseInt(res[2]);
        int a1 = Deck.drawPile.get(a-1);
        int b1 = Deck.drawPile.get(b-1);
        int c1 = Deck.drawPile.get(c-1);

        Deck.drawPile.set(0, a1);
        Deck.drawPile.set(1, b1);
        Deck.drawPile.set(2, c1);
    }

    public void shuffleDrawPile(){

        Collections.shuffle(Deck.drawPile);
    }

    public String getCardName(int i){
        return cards.get(i);
    }

    public ArrayList<Integer> getDrawPile(){
        return Deck.drawPile;
    }


}

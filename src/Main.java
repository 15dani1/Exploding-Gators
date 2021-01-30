import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static int numPlayers = 0;
    public static HashMap<Integer, Player> players = new HashMap<>();
    public static Deck dc;

    public static void print(){
        for(Integer i : players.keySet()){
            Player p = players.get(i);
            System.out.println(p.name + " " + p.deck);
        }
    }

    public static ArrayList<String> myHand(Integer playerNumber){
        HashMap<Integer, String> cards = dc.getCards();
        Player me = players.get(playerNumber);
        ArrayList<String> handString = new ArrayList<>();
        for(int i = 0; i < me.deck.size(); i++){
            handString.add(cards.get(me.deck.get(i)));
        }
        return handString;
    }

    public static void game(){
        int i = 1;
        while(players.size() > 1){
            Scanner sc = new Scanner(System.in);
            Player currentPlayer = players.get(i);
            System.out.println("Hello " + currentPlayer.name + ", are you ready? Enter 1.");
            if(sc.next().equals("1")){
                int c1 = 0;
                while(c1 != 4) {
                    System.out.println("Select the following options:");
                    System.out.println("1. View your hand.");
                    System.out.println("2. Choose a card to play.");
                    System.out.println("3. Draw from deck");
                    System.out.println("4. End turn");
                    c1 = sc.nextInt();
                    if (c1 == 1) {
                        ArrayList<String> hand = myHand(i);
                        System.out.println(hand);
                    }
                    else if (c1 == 2) {
                        System.out.println("Select the card you want to play. Type the number");
                        ArrayList<String> hand = myHand(i);
                        int j = 1;
                        for (String card : hand) {
                            System.out.println(j + ". " + card);
                            j++;
                        }
                        int c2 = sc.nextInt();
                        currentPlayer.removeCard(c2 - 1);
                    }
                    else if (c1 == 3){
                        ArrayList<Integer> drawPile = dc.getDrawPile();
                        int newCard = drawPile.remove(0);
                        currentPlayer.deck.add(newCard);
                        System.out.println("The card you drew is: " + dc.getCardName(newCard));
                        if(newCard == 2){
                            System.out.println("Oh no, you got an Exploding Kitten! You are out of the game :(");
                            players.remove(i);
                            if(players.size() == 1){
                                System.out.println("The game is over!");
                                Map.Entry<Integer, Player> winner = players.entrySet().iterator().next();
                                System.out.println("The winner is: " + winner.getValue().name);
                                System.exit(0);
                            }
                        }
                    }
                    else if(c1 == 4){
                        i++;
                        for(int k = 0; k < 10; k++){
                            System.out.println("");
                        }
                    }
                }

            }
        }
    }

    public static void deckCreation(){

        dc = new Deck(numPlayers);
        System.out.println("Enter the names of each player below:");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < numPlayers; i++){
            int currentPlayer = i + 1;
            System.out.println("Player " + currentPlayer + ": ");
            ArrayList<Integer> startHand = dc.createHand();
            String name = sc.next();
            players.put(i+1, new Player(name, startHand));
        }
        print();
        System.out.println(dc.createDrawPile());
        System.out.println();
        game();
    }


    public static void players(){
        System.out.println("How many gators are in the house tonight?? Only 3-5 gators allowed!");
        Scanner sc = new Scanner(System.in);
        numPlayers = sc.nextInt();
        if (numPlayers > 5) {
            System.out.println("Can you read?? Up to 5 gators only!");
            players();
        }
        else if (numPlayers < 3) {
            System.out.println("Not enough gators present.");
            players();
        }
        else {
            deckCreation();
        }
    }

    public static void start(){
        System.out.println("Welcome to the Exploding Gators Game!");
        System.out.println("Would you like to begin playing? Enter yes or no.");
        Scanner sc = new Scanner(System.in);
        String game = sc.next();
        while (!game.equalsIgnoreCase("yes") && !game.equalsIgnoreCase("no")) {
            System.out.println("Oops, you did not type yes or no. Please type one of those options!");
            game = sc.next();
        }
        if (game.equalsIgnoreCase("yes")) {
            players();
        }
        else if (game.equalsIgnoreCase("no")) {
            System.out.println("Awww, its sad to say goodbye!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        start();
    }

}

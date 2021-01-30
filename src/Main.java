import java.util.Scanner;

public class Main {

    public static int numPlayers = 0;

    public static void deckCreation(){
        Deck dc = new Deck(numPlayers);
        dc.createHand();
        dc.createHand();
        dc.createHand();
        dc.createHand();
        dc.createHand();
        dc.createHand();
    }


    public static void players(){
        System.out.println("How many gators are in the house tonight?? Only 5 gators allowed!");
        Scanner sc = new Scanner(System.in);
        numPlayers = sc.nextInt();
        if (numPlayers > 5) {
            System.out.println("Can you read?? Up to 5 gators only!");
            players();
        }
        else if (numPlayers < 0) {
            System.out.println("Negative gators?????");
            players();
        }
        else if (numPlayers == 0){
            System.out.println("So nobody?");
            System.exit(0);
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

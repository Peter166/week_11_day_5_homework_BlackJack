import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        Game game = new Game(deck);
        Player dealer = new Player("dealer", false);
        game.addPlayer(dealer);


        System.out.println("Welcome to Draw Blackjack");
        System.out.println("How many players would you like to play?");

        String input = scanner.next();
        int players = parseInt(input) + 1;

        for (int i = 1; i < players; i++) {
            String prompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName, false);
            game.addPlayer(player);
        }

        game.start(2);


        for (Player player : game.getPlayers()) {

            if (!player.checkIfPass() && player.getName() != "dealer") {
                while (!player.checkIfPass()) {
                    String out = String.format("%s turn!", player.getName());
                    System.out.println(out);
                    String output = String.format("%s has:", player.getName());
                    System.out.println(output);
                    for (int i = 0; i < player.cardCount(); i++) {
                        System.out.println(player.showCard(i));

                    }if ((player.handTotal() > 21) && player.checkForAce()) {
                        System.out.println(String.format("Hand total: %s", player.handTotal()));
                    }else {
                        System.out.println(String.format("Hand total: %s", player.handTotal()));
                    }

                    System.out.println("Press ( 1 ) to get New card, or ( 0 ) for pass.");
                    String inputFromPlayer = scanner.next();
                    int outcome = parseInt(inputFromPlayer);

                    if (outcome == 1) {
                        game.pickedG(player);
                    } else {
                        game.pickedP(player);
                    }


                    if ((player.handTotal() > 21) && player.checkForAce()) {
                        System.out.println(String.format("Hand total: %s", player.handTotal()));
                    }

                    if (player.handTotal() > 21) {

                        String looser = String.format("Ha Ha your a LOOSER %s!", player.getName());
                        System.out.println(looser);

                        System.out.println("You now have: ");
                        for (int i = 0; i < player.cardCount(); i++) {
                            System.out.println(player.showCard(i));
                        }
                        System.out.println(String.format("Hand total: %s", player.handTotal()));
                        game.pickedP(player);
                        String nextPlayer = ("Just input anything to  pass to another player");
                        String passToAnotherPlayer = scanner.next();


                    }
                }
            }
        }


        for (Player player : game.getPlayers()) {
            if (player.handTotal() < 22 ) {
                String output = String.format("%s has:", player.getName());
                System.out.println("");
                System.out.println(output);
                for (int i = 0; i < player.cardCount(); i++) {
                    System.out.println(player.showCard(i));
                }
                System.out.println(String.format("Hand total: %s", player.handTotal()));
            } else {
                System.out.println("");
                System.out.println("");
                if (player.checkForAce()) {
                    String looseWithAce = String.format("%s lost with total of %s", player.getName(), player.handTotal());
                    System.out.println(looseWithAce);
                } else {
                    String looseroutcome = String.format("%s lost with total of %s", player.getName(), player.handTotal());
                    System.out.println(looseroutcome);
                }
            }
        }

        if (game.checkDraw()) {
            System.out.println("It's a draw!");
        } else {
            Player winner = game.checkWinner();
            String winnerName = winner.getName();
            System.out.println("");
            System.out.println("");
            String output = String.format("%s WINS!", winnerName);
            System.out.println(output);
            System.out.println("");
            System.out.println("");
        }

    }
}

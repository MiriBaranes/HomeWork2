import java.util.Scanner;

public class Q7 {
    public static final int THE_BIGGEST_CHOICES = 9;
    public static final int THE_SMALLER_CHOICES = 0;
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = '0';

    public static void main(String[] args) {
        boolean stopGame = false;
        char[] playBord = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        printBoard(playBord);
        int torn = 0;
        while (stopGame == false) {
            torn++;
            char playerIcon = torn(torn);
            int indexBord = getPositionFromUser(playBord);
            boolean thereIsWinner = placeSymbolOnBoard(playBord, playerIcon, indexBord);
            stopGame = thereIsWinner;
            if (torn == 9) {
                break;
            }
        }
        if (stopGame == true) {
            char winner = torn(torn);
            System.out.println(); /// one line
            System.out.println(winner + " is the winner");
        } else {
            System.out.println("There is no winner-  ");
        }
    }

    public static void printBoard(char[] arrayChars) {
        int count=0;
        for (int i = 0; i < arrayChars.length; i++) {
            if (count == 3) {
                System.out.println();
                count = 0;
            }
            System.out.print(arrayChars[i] + "      ");
            count++;
        }
    }

    public static boolean isAvailable(char[] gameBord, int index) {
        boolean availableIndex = false;
        if (gameBord[index] != PLAYER_O && gameBord[index] != PLAYER_X) {
            availableIndex = true;
        }
        return availableIndex;
    }

    public static int getPositionFromUser(char[] game) {
        Scanner scanner = new Scanner(System.in);
        int userChoices = -1;
        boolean continuationAction = false;
        while (continuationAction == false) {
            do {
                System.out.println(" ");
                System.out.println("Enter a positive index: ");
                userChoices = scanner.nextInt();
            }
            while (userChoices < THE_SMALLER_CHOICES || userChoices > THE_BIGGEST_CHOICES);
            int indexChoices = userChoices - 1;
            boolean isAvailableIndex = isAvailable(game, indexChoices);
            if (isAvailableIndex == false) {
                System.out.println("The place is taken, choose another place.");
                continuationAction = false;
            } else {
                continuationAction = true;
            }
        }
        return userChoices;
    }

    public static char checkWinner(char[] game, char playerIcon) {
        char winner = '-';
        char winInInARow = checkVictoryInARow(game, playerIcon);
        char winInAHorizontal = checkVictoryHorizontal(game, playerIcon);
        char winInSlant = checkVictorySlant(game, playerIcon);

        if (winInSlant == playerIcon || winInAHorizontal == playerIcon || winInInARow == playerIcon) {
            winner = playerIcon;
        }
        return winner;
    }

    public static char checkVictoryHorizontal(char[] game, char playerIcon) {
        char winner = '-';
        for (int i = 0; i <= 2; i++) {
            if (game[i] == playerIcon) {
                if (game[i + 3] == game[i + 6] && playerIcon == game[i + 3]) {
                    winner = playerIcon;
                    break;
                }
            }
        }
        return winner;
    }

    public static char checkVictoryInARow(char[] game, char iconPlayer) {
        char winner = '-';
        for (int i = 0; i < game.length; i += 3) {
            if (game[i] == iconPlayer) {
                if (game[i + 1] == game[i + 2] && iconPlayer == game[i + 1]) {
                    winner = iconPlayer;
                    break;
                }
            }
        }
        return winner;
    }

    public static char checkVictorySlant(char[] game, char playerIcon) {
        char winner = '-';
        if (game[4] == playerIcon) {
            for (int i = 0; i <= 2; i += 2) {
                if (game[i] == game[game.length - 1 - i] && game[i] == playerIcon) {
                    winner = playerIcon;
                    break;
                }
            }
        }
        return winner;
    }


    public static boolean placeSymbolOnBoard(char[] gameBoard, char playerIcon, int indexBoard) {
        boolean thereIsWinner = false;
        gameBoard[indexBoard - 1] = playerIcon;
        printBoard(gameBoard);
        char winner = checkWinner(gameBoard, playerIcon);
        if (winner == PLAYER_X || winner == PLAYER_O) {
            thereIsWinner = true;
        }
        return thereIsWinner;
    }

    public static char torn(int torn) {
        char playerOneIcon = PLAYER_X;
        char playerTwoIcon = PLAYER_O;
        char tornPlayer = ' ';
        if (torn % 2 == 0) {
            tornPlayer = playerOneIcon;
        } else {
            tornPlayer = playerTwoIcon;
        }
        return tornPlayer;
    }
}




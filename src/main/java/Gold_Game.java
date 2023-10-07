import java.awt.*;
import java.util.Scanner;

public class Gold_Game {
    public static void main(String[] args) {
        // Creating objects and playgrounds

        Point gamerPosition = new Point(10, 9);     // First positions
        Point snakePosition = new Point(30, 2);
        Point goldPosition = new Point(6, 6);
        Point gatePosition = new Point(2, 5);
        boolean goingOn = true;
        boolean goldFind = false;

        // Area size 40x10

        while (goingOn) {                                 // In order for the game to continue after each Move
            for (int y = 0; y < 10; y++) {                // y = Area length 10 units

                for (int x = 0; x < 40; x++) {            // x = Area width 40 units
                    Point p = new Point(x, y);
                    if (p.equals(gamerPosition))
                        System.out.print("P");
                     else if (p.equals(snakePosition))
                        System.out.print("S");
                     else if (p.equals(goldPosition))
                        System.out.print("G");
                     else if (p.equals(gatePosition))
                        System.out.print("E");
                     else
                        System.out.print(".");            // We did not use ln, we want it to print side by side

                }
                System.out.println();
            }

            //LOGIC OF THE GAME: The player must take the gold and go to the door without getting caught by the snake

            if (snakePosition.equals(gamerPosition)) {
                goingOn = false;
                System.out.println("GAME OVER..! Tss..The SNAKE bit you");
            }

            if (gamerPosition.equals(gatePosition)) {
                goldFind = true;
                goldPosition = new Point(-1, -1);
            }

            if (gamerPosition.equals(gatePosition) && goldFind) {
                goingOn = false;
                System.out.println("CONGRATULATIONS CHAMP! You won the game!");
            }

            goGamer(gamerPosition);
            goSnake(snakePosition, gamerPosition);

        }
    }

    // Player movement method
    private static void goGamer(Point gamerPosition) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        // w, a, s, d

        if (input.equals("w"))
            if (gamerPosition.y > 0)
                gamerPosition.y--;          // In JAVA, coordinates go from center to right (X) and from center to bottom (Y)
         else if (input.equals("s"))
            if (gamerPosition.y < 9)
                gamerPosition.y++;
         else if (input.equals("a"))
            if (gamerPosition.x > 0)
                gamerPosition.x--;
         else if (input.equals("d"))
            if (gamerPosition.x > 9)
                gamerPosition.x++;

    }

    // Snake movement method

    private static void goSnake(Point snakePosition, Point gamerPosition) {
        if (gamerPosition.x < snakePosition.x)
            snakePosition.x--;
        else if (gamerPosition.x > snakePosition.x)
            snakePosition.x++;
        if (gamerPosition.y < snakePosition.y)
            snakePosition.y--;
        else if (gamerPosition.y > snakePosition.y)
            snakePosition.y++;
    }
}


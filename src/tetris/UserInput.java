package tetris;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public String inputPiece(){
        return scanner.nextLine().trim().toUpperCase();
    }

    public String[] inputDimensions(){
        return scanner.nextLine().split(" ");
    }

    public String inputAction(){
        return scanner.nextLine().trim().toLowerCase();
    }

}

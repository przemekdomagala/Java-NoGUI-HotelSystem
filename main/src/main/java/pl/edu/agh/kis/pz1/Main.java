package pl.edu.agh.kis.pz1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        SystemHandler systemHandler = new SystemHandler();
        Hotel hotel = new Hotel();
        System.out.println("Welcome to our hotel system.");
        int option;
        while(systemHandler.isPickAnother()){
            System.out.println("\nPick system option:");
            System.out.println("1. List");
            System.out.println("2. View");
            System.out.println("3. Check in");
            System.out.println("4. Check out");
            System.out.println("5. DetailedList");
            System.out.println("6. Save");
            System.out.println("7. Quit");
            try {
                option = Integer.parseInt(s.nextLine());
                systemHandler.execute(option, hotel);
            }catch (NumberFormatException e) {
                System.out.println("Passed Input is not a number.");
            }
        }
        s.close();
    }
}
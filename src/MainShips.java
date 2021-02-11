import java.util.Scanner;

public class MainShips extends Thread {
    static Scanner scanner = new Scanner(System.in);
    volatile static int maxQuantityShip;


    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();

        ShipGenerator shipGenerator = new ShipGenerator(tunnel);
        Pier pierOfBanana = new Pier(tunnel, "Bananas");
        Pier pierOfClothes = new Pier(tunnel, "Clothes");
        Pier pierOfMeat = new Pier(tunnel, "Meat");

        System.out.println("Введите число кораблей");
        maxQuantityShip = scanner.nextInt();

        pierOfBanana.start();
        pierOfClothes.start();
        pierOfMeat.start();

        shipGenerator.start();

    }
}
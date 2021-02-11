import java.util.*;

public class ShipGenerator extends Thread {
    private static final int MAX_SHIPS_IN_TUNNEL = 5;
    private List<String> typeList = Arrays.asList("Meat", "Bananas", "Clothes");
    private List<Integer> sizeList = Arrays.asList(10, 50, 100);
    Random random = new Random();
    Tunnel tunnel;
    MainShips mainShips;

    ShipGenerator(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        if (tunnel.counterShipInTunnel <= MAX_SHIPS_IN_TUNNEL) {
            for (int i = 1; i <= mainShips.maxQuantityShip; i++) {
                while (tunnel.counterShipInTunnel == MAX_SHIPS_IN_TUNNEL) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Ship ship = new Ship(getRandomType(), getRandomSize());
                tunnel.shipAdding(ship);
            }
        }
    }

    private String getRandomType() {
        return typeList.get(random.nextInt(typeList.size()));
    }

    private int getRandomSize() {
        return sizeList.get(random.nextInt(sizeList.size()));
    }

}

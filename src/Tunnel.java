import java.util.*;

public class Tunnel {
    static volatile int counterShipInTunnel = 0;
    static volatile int allGeneratedShips = 0;
    public ArrayList<Ship> store;

    Tunnel() {
        store = new ArrayList<>();
    }


    public synchronized void shipAdding(Ship ship) {
        store.add(ship);
        counterShipInTunnel++;
        notifyAll();
        allGeneratedShips++;
        System.out.println("Сгенерирован корабль " + ship.type + " " + ship.size);
        System.out.println("Количество кораблей в туннеле: " + counterShipInTunnel);
        System.out.println("Всего сгенерированно кораблей: " + allGeneratedShips + "\n");


    }

    public synchronized void shipUnloading(String shipType) {
        int shipSize;

        while (store.size() > 0)
            if (store.get(0).getType() == shipType) {
                shipSize = store.get(0).getSize();
                System.out.println("Корабль с типом " + shipType + " и размером " + shipSize + " прибывает в порт ");


                for (int i = shipSize; i > 0; i -= 10) {
                    shipSize -= 10;
                    if (shipSize == 0) {
                        System.out.println("Корабль с " + shipType + " разгружен\n");
                        store.remove(0);
                        counterShipInTunnel--;
                        notifyAll();

                    } else {
                        System.out.println("Корабль с " + shipType + " разгружается, осталось " + shipSize + " единиц товара");
                    }
                }
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}






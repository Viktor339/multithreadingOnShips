import java.util.Iterator;

public class Pier extends Thread {
    MainShips mainShips;
    String shipType;
    Tunnel tunnel;


    Pier(Tunnel tunnel, String typeOfShip) {
        this.tunnel = tunnel;
        this.shipType = typeOfShip;
    }

    @Override
    public void run() {
        while (tunnel.counterShipInTunnel == 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (tunnel.counterShipInTunnel > 0 ) {
            while (tunnel.allGeneratedShips < mainShips.maxQuantityShip)
            for (Iterator<Ship> listIterator = tunnel.store.iterator(); listIterator.hasNext();){
                tunnel.shipUnloading(shipType);
            }
        }
    }
}




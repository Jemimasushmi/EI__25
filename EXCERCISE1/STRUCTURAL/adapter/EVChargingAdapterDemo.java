import java.util.Scanner;

interface NewChargingPort {
    void chargeEV();
}

class OldChargingSocket {
    public void connectOldPlug() {
        System.out.println("Charging with old socket...");
    }
}

class NewChargingSocket implements NewChargingPort {
    public void chargeEV() {
        System.out.println("Charging with new socket...");
    }
}


class ChargingAdapter implements NewChargingPort {
    private OldChargingSocket oldSocket;

    public ChargingAdapter(OldChargingSocket oldSocket) {
        this.oldSocket = oldSocket;
    }

    @Override
    public void chargeEV() {
      
        oldSocket.connectOldPlug();
    }
}

public class EVChargingAdapterDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose charging socket (1 = New, 2 = Old): ");
        int choice = Integer.parseInt(sc.nextLine());

        NewChargingPort chargingPort;

        if (choice == 1) {
            chargingPort = new NewChargingSocket();
        } else if (choice == 2) {
            OldChargingSocket oldSocket = new OldChargingSocket();
            chargingPort = new ChargingAdapter(oldSocket);
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        // EV charges using new interface regardless of socket type
        chargingPort.chargeEV();

        sc.close();
    }
}

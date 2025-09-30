import java.util.*;

interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    void attach(Observer o) { observers.add(o); }
    void detach(Observer o) { observers.remove(o); }

    void setTemperature(float temp) {
        this.temperature = temp;
        for (Observer o : observers) o.update(temp);
    }
}

class PhoneDisplay implements Observer {
    public void update(float temp) { System.out.println("Phone Display: Temp is " + temp + "°C"); }
}

class BillboardDisplay implements Observer {
    public void update(float temp) { System.out.println("Billboard Display: Temp is " + temp + "°C"); }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WeatherStation station = new WeatherStation();
        PhoneDisplay phone = new PhoneDisplay();
        BillboardDisplay billboard = new BillboardDisplay();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Attach Phone Display");
            System.out.println("2. Attach Billboard Display");
            System.out.println("3. Detach Phone Display");
            System.out.println("4. Detach Billboard Display");
            System.out.println("5. Set Temperature");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: station.attach(phone); break;
                case 2: station.attach(billboard); break;
                case 3: station.detach(phone); break;
                case 4: station.detach(billboard); break;
                case 5:
                    System.out.print("Enter new temperature: ");
                    float temp = Float.parseFloat(sc.nextLine());
                    station.setTemperature(temp);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

import java.util.Scanner;

interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

class NotificationFactory {
    public static Notification getNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        } else {
            return null;
        }
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter notification type (email/sms): ");
        String type = sc.nextLine();

        Notification notification = NotificationFactory.getNotification(type);

        if (notification != null) {
            notification.notifyUser();
        } else {
            System.out.println("Invalid notification type!");
        }

        sc.close();
    }
}

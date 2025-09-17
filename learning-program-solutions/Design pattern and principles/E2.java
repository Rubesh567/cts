
abstract class Notification {
    public abstract void sendNotification();
}

class EmailNotification extends Notification {
    public void sendNotification() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification extends Notification {
    public void sendNotification() {
        System.out.println("Sending SMS Notification");
    }
}

class User {
    private Notification notification;

    public User(int type) {
        if (type == 1) {
            notification = new EmailNotification();
        } else if (type == 2) {
            notification = new SMSNotification();
        } else {
            notification = null;
        }
    }

    public Notification getNotification() {
        return notification;
    }

    public void cleanup() {
        notification = null;
    }
}

public class E2 {
    public static void main(String[] args) {
        User user = new User(2); // 1 for Email, 2 for SMS
        Notification notification = user.getNotification();

        if (notification != null) {
            notification.sendNotification();
        } else {
            System.out.println("Invalid notification type.");
        }

        user.cleanup();
    }
}

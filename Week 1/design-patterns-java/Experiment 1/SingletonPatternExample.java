public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        if (logger1 == logger2) {
            System.out.println("Success! Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Failed! Different instances were created.");
        }
        logger1.logMessage("This is a singleton logging test.");
    }
}
class Logger {
    private static Logger instance;
    private Logger() {
        System.out.println("Logger instance created.");
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void logMessage(String message) {
        System.out.println("[LOG] " + message);
    }
}

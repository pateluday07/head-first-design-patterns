package patterns.creational.singleton.lazy;

public class ConfigurationManager {

    private static volatile ConfigurationManager instance;

    private ConfigurationManager() {

    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {

            synchronized (ConfigurationManager.class) {
                if(instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public void addConfig() {
        System.out.println("configuration added..");
    }

    public String getConfig() {
        return "configuration retrieved..";
    }
}

package patterns.creational.singleton;

public class Tester {

    public static void main(String[] args) {
        //memory 123
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.addConfig();
        System.out.println(configManager.getConfig());

        //memory 123
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();
        configManager2.addConfig();
        System.out.println(configManager2.getConfig());

        ConfigurationManager configManager3 = ConfigurationManager.getInstance();
        ConfigurationManager configManager4 = ConfigurationManager.getInstance();

        System.out.println(configManager == configManager2);
        System.out.println(configManager == configManager3);
        System.out.println(configManager3 == configManager4);

    }
}

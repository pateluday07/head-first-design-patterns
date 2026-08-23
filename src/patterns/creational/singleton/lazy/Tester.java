package patterns.creational.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Tester {

    public static void main(String[] args) throws Exception {
        System.out.println("Singleton Pattern creating configuration manager using getInstance() method..");

        //config manager one
        ConfigurationManager configManager1 = ConfigurationManager.getInstance();

        //config manager two
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();

        System.out.println("comparing configManager1 and configManager2 using == operator..");
        System.out.println(configManager1 == configManager2);

        //config manager three
        System.out.println("\ncreating configManager3 using reflection by accessing the private instance field..");
        Field instanceField = ConfigurationManager.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null); // Reset the instance field to null
        ConfigurationManager configManager3 = ConfigurationManager.getInstance();
        System.out.println("comparing configManager1 and configManager3 using == operator..");
        System.out.println(configManager1 == configManager3);

        //config manager four
        System.out.println("\ncreating configManager4 using reflection by accessing the private constructor..");
        Constructor<ConfigurationManager> constructor = ConfigurationManager.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ConfigurationManager configManager4 = constructor.newInstance();
        System.out.println("comparing configManager1 and configManager4 using == operator..");
        System.out.println(configManager1 == configManager4);
    }
}

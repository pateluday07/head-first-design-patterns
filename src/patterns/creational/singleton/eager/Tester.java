package patterns.creational.singleton.eager;

public class Tester {

    public static void main(String[] args) {
        System.out.println("Eager Singleton Pattern creating configuration manager using INSTANCE enum..\n");
        EagerConfigManager configManager1 = EagerConfigManager.INSTANCE;
        configManager1.addConfig();

        EagerConfigManager configManager2 = EagerConfigManager.INSTANCE;
        configManager2.addConfig();

        System.out.println("\ncomparing configManager1 and configManager2 using == operator..");
        System.out.println(configManager1 == configManager2);

        //REFLECTION ATTACK
        System.out.println("\ncreating configManager3 using reflection by accessing the private constructor..");

        try {
            java.lang.reflect.Constructor<EagerConfigManager> constructor = EagerConfigManager.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            EagerConfigManager configManager3 = constructor.newInstance();
            System.out.println("comparing configManager1 and configManager3 using == operator..");
            System.out.println(configManager1 == configManager3);
        } catch (Exception e) {
            System.out.println("Reflection attack failed: " + e.getMessage());
        }
    }
}

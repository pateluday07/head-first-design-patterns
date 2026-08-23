package patterns.creational.singleton.eager;

public enum EagerConfigManager {

    INSTANCE;

    public void addConfig(){
        System.out.println("configuration added..");
    }
}

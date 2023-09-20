package whattimeisit.simplemod.config;


public class SimpleModConfig {
    public static int itemIDs = 19000;



    public static int nextItem() {
        return itemIDs++;
    }

        //("Block IDs")
        //("Item IDs")
    public static int mintSlush = nextItem();
    public static int scythe = nextItem();
    public static int backpack = nextItem();
}
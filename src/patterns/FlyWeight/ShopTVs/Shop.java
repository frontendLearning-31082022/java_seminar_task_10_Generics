package patterns.FlyWeight.ShopTVs;

import patterns.FlyWeight.Flyweight.SimpleStorage.WarehouseFlyweightFactory;



public class Shop {
    WareHouse wareHouse;
    public Shop(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }


    void arrivelItems(){
        this.memoryUsed();
        for (int i = 0; i < 40; i++) {
            this.wareHouse.addItem(new SamsungTV("11","src/patterns/FlyWeight/ShopTVs/imgs/samsung"));
            this.wareHouse.addItem(new SamsungTV("1b","src/patterns/FlyWeight/ShopTVs/imgs/digma"));
            this.wareHouse.addItem(new SamsungTV("11444","src/patterns/FlyWeight/ShopTVs/imgs/sony"));
        }
        this.memoryUsed();
    }

    public static void main(String[] args) {

        WareHouse wareHouse=new WareHouse();

        Shop shop=new Shop(wareHouse);
        shop.arrivelItems();


        WarehouseFlyweightFactory warFlyWeight=new WarehouseFlyweightFactory();
        Shop shopFlyWeight=new Shop(warFlyWeight);
        shopFlyWeight.arrivelItems();


        TV someTV= shop.wareHouse.getFirst();
        someTV.setBonusChannelPacket();

        TV someTVFlyWeught= shopFlyWeight.wareHouse.getFirst();
        someTVFlyWeught.setBonusChannelPacket();
    }



    void memoryUsed() {
        int mb = 1024 * 1024;
        // get Runtime instance
        Runtime instance = Runtime.getRuntime();
        System.out.println("Used Memory: "
                + (instance.totalMemory() - instance.freeMemory()) / mb +"mb");
    }


}

package patterns.FlyWeight.ShopTVs;

import java.util.Arrays;
import java.util.HashMap;

public class WareHouse {
    protected HashMap<String, TV> storage = new HashMap<>();

    public void addItem(TV newTv) {
        storage.put(newTv.toString(), newTv);
    }

    TV getFirst(){
        return (TV) Arrays.stream(storage.values().toArray()).toArray()[0];
    }

}

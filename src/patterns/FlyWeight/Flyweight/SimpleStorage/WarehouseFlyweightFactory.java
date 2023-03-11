package patterns.FlyWeight.Flyweight.SimpleStorage;

import patterns.FlyWeight.ShopTVs.TV;
import patterns.FlyWeight.ShopTVs.WareHouse;

import java.util.HashMap;

public class WarehouseFlyweightFactory extends WareHouse {
    private HashMap<String, TV> uniqFlyWeight=new HashMap();
    @Override
    public void addItem(TV newTv){
        String keyFlyWeight=getKeyFlyWeight(newTv);
        TV already=checkNewData(newTv);
        if (already==null){
            TVcoverege tVcoverege= new TVcoverege(newTv);
            tVcoverege.setContext(this);

            this.uniqFlyWeight.put(keyFlyWeight,tVcoverege);
            already=tVcoverege;
        }

        this.storage.put(newTv.toString(),already);
    }

    String getKeyFlyWeight(TV newTv){
        return newTv.getModel()+newTv.isBonusChannels();
    }

    class TVcoverege extends TV {
        private WarehouseFlyweightFactory context;

        TVcoverege(TV tv){
            super(tv.getModel(),tv.pathIMG);
        }



        private void setContext(WarehouseFlyweightFactory context){
            this.context=context;
        }

        @Override
        public void setBonusChannelPacket() {
            super.setBonusChannelPacket();
            if (context.checkNewData(this)==null){
                context.addItem(this);
                context.removeTV(this);

            }

        }
    }

    boolean removeTV(TVcoverege tVcoverege){
        long inBase= this.storage.values().stream().filter(x->getKeyFlyWeight(x).equals(getKeyFlyWeight(tVcoverege))).count();
        if (inBase>0)return false;

        this.storage.keySet().removeIf(x->getKeyFlyWeight(this.storage.get(x)).equals(getKeyFlyWeight(tVcoverege)));
        this.uniqFlyWeight.remove(getKeyFlyWeight(tVcoverege));
        return true;
    }

    TV checkNewData(TV newTv){
        String keyFlyWeight=getKeyFlyWeight(newTv);
        TV already=this.uniqFlyWeight.get(keyFlyWeight);

        return already;
    }

}


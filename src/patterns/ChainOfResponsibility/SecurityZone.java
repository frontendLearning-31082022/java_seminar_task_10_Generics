package patterns.ChainOfResponsibility;

public abstract class SecurityZone implements SecurityZoneIf_client{
     SecurityZone parent;
    SecurityZone getParent(){return parent;}

    //просто изменение показателей сенсора
    public void notifyS(int val, Sensor sensor){
        if (!handleNotif(val,sensor) && parent!=null)parent.notifyS(val, sensor);
    }

    protected abstract boolean handleNotif(int val, Sensor sensor);

    @Override
    public void fireAlarm(SecurityZone zone) {
        // конкретные зоны, если могут тушить, то тушат
        if (parent!=null)parent.fireAlarm(zone);
    }
}
class Area extends SecurityZone{
    public Area(SecurityZone parent){super.parent=parent;}
    @Override
    protected boolean handleNotif(int val, Sensor sensor) {
        if (sensor instanceof TempSensor==false) return false;

        if (val>150)fireAlarm(this);
        if (val>150)return true;

        return false;
    }
}

class WareHouse extends SecurityZone{
    public WareHouse(SecurityZone parent){super.parent=parent;}
    @Override
    protected boolean handleNotif(int val, Sensor sensor) {
        //опционально доп проверка
        if (sensor instanceof TempSensor==false) return false;

        if (val>150)fireAlarm(this);
        if (val>150)return true;

        return false;
    }
    public void fireAlarm(SecurityZone zone) {
        if(zone instanceof Area)TurnWareHouseFireOutSystem();
        if (getParent()!=null)getParent().fireAlarm(zone);

        if(zone instanceof Area==false)super.fireAlarm(zone);
    }

    void TurnWareHouseFireOutSystem(){}
}


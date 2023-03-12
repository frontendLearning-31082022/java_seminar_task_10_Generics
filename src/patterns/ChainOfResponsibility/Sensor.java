package patterns.ChainOfResponsibility;

public abstract class Sensor {
    abstract void notifyS(int val);
}
class TempSensor extends Sensor {
    private SecurityZone zone;
    public TempSensor(SecurityZone zone) {
        this.zone = zone;
    }
    @Override
    public void notifyS(int val) {zone.notifyS(val,this); }
}



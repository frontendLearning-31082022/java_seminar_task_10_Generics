package patterns.ChainOfResponsibility;

public interface SecurityZoneIf_client {
    //просто изменение показателей сенсора
    void notifyS(int val,Sensor sensor);
    void fireAlarm(SecurityZone zone);
}

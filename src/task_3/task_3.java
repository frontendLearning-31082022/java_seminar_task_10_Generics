package task_3;

import patterns.Bridge;
import patterns.Builder.Builder;
import patterns.ChainOfResponsibility.ChainOfResponsibility;
import patterns.FlyWeight.Flyweight.Flyweight;

// Реализуйте паттерны: Строитель, Цепочка обязанностей, Приспособленец и Мост
public class task_3 {
    public static void main(String[] args) {
        Builder.main(null);
        ChainOfResponsibility.main(null);
        Flyweight.simpleStorageFlyweight();
        Bridge.main(null);
    }
}

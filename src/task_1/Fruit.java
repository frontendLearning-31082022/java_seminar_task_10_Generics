package task_1;

public abstract class Fruit {
    private final double weight;
    public Fruit(double weight) {this.weight = weight;}
    public double getWeight() {return weight;}
}

class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }
}

class GoldenApple extends Apple {
    public GoldenApple(double weight) {
        super(weight);
    }
}

class Orange extends Fruit {
    public Orange(double weight) {
        super(weight);
    }
}
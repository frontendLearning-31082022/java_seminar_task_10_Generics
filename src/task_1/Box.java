package task_1;

import java.util.Collection;
import java.util.Stack;

// Нужно реализовать хранение фрукто в коробке Box:
// По-умолчанию коробка пустая. Можно класть только фрукты какого-то вида!
// Нужно уметь получать сумарный вес всех фруктов в коробке
// Нужно уметь пересыпать все фрукты из одной коробки в другую
public class Box<T extends Fruit> {
    Stack<T> stack = new Stack<>();

    public void add(T elem) {
        stack.add(elem);
    }

    public double getWeight() {
        return stack.stream().mapToDouble(x->x.getWeight()).sum();
    }

    public void moveTo (Box<? super T> anotherBox) {
//        if (!(anotherBox instanceof Box<? extends Fruit>))throw new IllegalArgumentException("В коробку кладуться только фрукты");

        this.stack.addAll((Collection<? extends T>) anotherBox.stack);
        anotherBox.stack.clear();
    }

    public static void main(String[] args) {
        // Fruit <- Orange, Apple <- GoldenApple

//        Box<String> stringBox = new Box(); // Не должно работать!

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(3.0));
        appleBox.add(new Apple(2.0));
        appleBox.add(new GoldenApple(1.0));
//        appleBox.add(new Orange(2.0)); // Не должно работать!
//        Fruit fruit1=new Fruit(1.2) {
//            @Override
//            public double getWeight() {return super.getWeight();}};
//        appleBox.add(fruit1);           // не работает

        System.out.println(appleBox.getWeight()); // 6.0

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(2.0));
//        goldenAppleBox.add(new Apple(2.0)); // Не должно работать

//        appleBox.moveTo(goldenAppleBox); // Не должно работать!
        goldenAppleBox.moveTo(appleBox);
        System.out.println(appleBox.getWeight()); // 0.0
        System.out.println(goldenAppleBox.getWeight()); // 8.0

    }

}

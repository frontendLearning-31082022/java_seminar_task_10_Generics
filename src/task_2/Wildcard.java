package task_2;

import java.util.ArrayList;
import java.util.List;

// Практика generics со знаками подстановки на super и extends

public class Wildcard {
    static List<A> aList = new ArrayList<>();
    static List<B> bList = new ArrayList<>();
    static List<C> cList = new ArrayList<>();
    static List<D> dList = new ArrayList<>();
    static List<E> eList = new ArrayList<>();

    public static void main(String[] args) {
        // A <- B <- C <- D <- E

        exmp1();
        exmp2();
        exmp3();
        exmp4();
        exmp5();
    }

    static public void exmp1(){
//        test1(aList);
//        test1(bList);
//        test1(cList);
//        test1(dList);
//        test1(eList);
    }
   static public <T extends  C> void test1(List<T> list){}


    static public void exmp2(){
//        List<A> acList = test2(aList);
//        List<B> bcList = test2(bList);
//        List<C> ccList = test2(cList);
//        List<D> dcList = test2(dList);
//        List<E> ecList = test2(eList);
    }
    static public <T extends  C, S extends T> List<S> test2(List<T> list){return null;}

    static public void exmp3(){
//        List<C> ccList = test2(cList);
//        List<D> dcList = test2(cList);
//        List<E> ecList = test2(cList);
//

//        <T extends  D, S extends D> List<S> test2(List<D> list)
//        List<C> ccList = test2(dList);
//        List<D> dcList = test2(dList);
//        List<E> ecList = test2(dList);

//      <E extends  E, S extends E> List<S> test2(List<E> list)
//       List<C> ccList = test2(eList);
//       List<D> dcList = test2(eList);
//       List<E> ecList = test2(eList);
    }


    static public void exmp4(){
//        test3(aList);
//        test3(bList);
//        test3(cList);
//        test3(dList);
//        test3(eList);

//         <T extends  B, S extends T,b extends S> List<S> test3(List<b> list)
//         <b extends B> List<S> test3(List<b> list)
//        List<A> abList = test3(bList);
//        List<B> bbList = test3(bList);

          test3(bList);
//         невозможно присвоить возвращаемым типам
//           <T extends  B, S extends T,b extends S> List<S> test3(List<b> list)
//                                      b extends <C>,<D>,<E> невозвможно
//        List<C> cbList = test3(bList);
//        List<D> dbList = test3(bList);
//        List<E> ebList = test3(bList);
    }
    static public <T extends  B, S extends T,R extends S> List<S> test3(List<R> list){return null;}


    static public void exmp5(){
        test3(cList);

//        //мин B
//        List<A> acList = test3(cList);

        List<B> bcList = test3(cList);
        List<C> ccList = test3(cList);

        //С не раширит <D>, <E>
//        List<D> dcList = test3(cList);
//        List<E> ecList = test3(cList);
    }

    class A { }
    class B extends A { }
    class C extends  B { }
    class D extends C { }
    class E extends D { }

}

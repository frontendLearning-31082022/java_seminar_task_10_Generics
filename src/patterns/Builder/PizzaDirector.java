package patterns.Builder;

class PizzaDirector {
    void directorRequest(){
        PizzaBuilderAbstract wantMeat = new MeatPizzaBuilder();
        Pizza pizza= wantMeat.addThat().addThis().addThat().build();

        VeggiPizzaBuilder veggieStyle=new VeggiPizzaBuilder();
        Pizza pizzaVEg= veggieStyle.addThis().addThis().addThat().build();
    }
}


abstract class PizzaBuilderAbstract {
    abstract PizzaBuilderAbstract addThis();

    abstract PizzaBuilderAbstract addThat();
    abstract Pizza build();
}

class MeatPizzaBuilder extends PizzaBuilderAbstract {
    @Override
    MeatPizzaBuilder addThis() {return this;}
    @Override
    MeatPizzaBuilder addThat() {return this;}

    @Override
    Pizza build() {return new Pizza() {};}
}

class VeggiPizzaBuilder extends PizzaBuilderAbstract {
    @Override
    VeggiPizzaBuilder addThis() {return this;}
    @Override
    VeggiPizzaBuilder addThat() {return this;}
    @Override
    Pizza build() {return new Pizza() {};}
}
abstract class Pizza{}
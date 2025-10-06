package FactoryMethod.Pizzeria;

import FactoryMethod.Pizzas.*;

public class PizzeriaItaliana extends Pizzeria {
    public Pizza createPizza(String tipo) {
        if (tipo.equals("margarita")) {
            return new PizzaMargarita();
        } else if (tipo.equals("barbacoa")) {
            return new PizzaBarbacoa();
        }
        return null;
    }
}
package FactoryMethod.Main;

import FactoryMethod.Pizzas.*;
import FactoryMethod.Pizzeria.*;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new PizzeriaItaliana();
        Pizza pizza1 = pizzeria.createPizza("margarita");
        pizza1.preparar();
        Pizza pizza2 = pizzeria.createPizza("barbacoa");
        pizza2.preparar();
    }
}
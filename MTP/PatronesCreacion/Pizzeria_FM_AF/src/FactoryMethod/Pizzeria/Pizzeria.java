package FactoryMethod.Pizzeria;

import FactoryMethod.Pizzas.Pizza;

public abstract class Pizzeria {
    public abstract Pizza createPizza(String tipo);
}
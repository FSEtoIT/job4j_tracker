package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по маршруту");
    }

    @Override
    public void passengers(int count) {
        System.out.println(getClass().getSimpleName() + count + " сидячих мест");
    }

    @Override
    public int refuel(int fuel) {
        int pricePerLiter = 62;
        int cost = fuel * pricePerLiter;
        System.out.println(getClass().getSimpleName() + fuel + " литров расходуется на маршрут. Себестоимость маршрута " + cost + "рублей");
        return cost;
    }
}
package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle smallPlane = new SmallPlane();
        Vehicle civilPlane = new CivilPlane();

        Vehicle[] vehicles = new Vehicle[]{plane, smallPlane, civilPlane, train, bus, };
        for (Vehicle object : vehicles) {
            object.move();
            object.speed();
        }
    }
}

package ru.job4j.stream;

import java.time.LocalDate;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }

        public static void main(String[] args) {
            List<Car> cars = List.of(
                    new Builder()
                            .buildBrand("Toyota")
                            .buildModel("Camry")
                            .buildCreated(LocalDate.of(2021, 6, 1))
                            .buildVolume(2.5)
                            .buildColor("Red")
                            .build(),
                    new Builder()
                            .buildBrand("GMC")
                            .buildModel("DELORIAN")
                            .buildCreated(LocalDate.of(1985, 2, 11))
                            .buildVolume(2.0)
                            .buildColor("Metallic")
                            .build()
            );
            cars.forEach(System.out::println);
        }
    }
}
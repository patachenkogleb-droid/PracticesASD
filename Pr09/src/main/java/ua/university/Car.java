package ua.university;

public class Car {
    private String model;

    public Car (String model){
        this.model = model;
    }

    public static class Engine {
        private int horsepower;

        public Engine (int horsepower){
            this.horsepower = horsepower;
        }
    }

    public void Engine_spec(){
        Car.Engine engine = new Car.Engine(500);
    }
}

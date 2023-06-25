package org.example;

import com.google.gson.Gson;

import java.util.*;

public class Garage {
    private static Garage INSTANCE;
    List<Car> carList = new ArrayList<>();
    private static final Gson gson = new Gson();

    private Garage() {
        carList.add(new Car(123,2,3594.9, "bmw"));
        carList.add(new Car(3634,1,38346.9, "audi"));
        carList.add(new Car(135,4,130000,"ferrari"));
    }

    public static Garage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Garage();
        }

        return INSTANCE;
    }

    public void add(Car car) {
        carList.add(car);
    }

    private String toJSON() {
        return gson.toJson(carList);
    }

    private String moreExpensive(){
        String jsonCar = "";
        double maxPrice = 0;
        for(Car car : carList){
            if(car.getPrice() > maxPrice){
                maxPrice = car.getPrice();
                jsonCar = gson.toJson(car);
            }
        }
        return jsonCar;
    }

    private String allSorted(){
        List<Car> newcarlist = new ArrayList<>(carList);
        newcarlist.sort(Comparator.comparing(Car::getDescription));
        return gson.toJson(newcarlist);
    }

    String garageActions(String command) {
        return switch (command.toLowerCase()) {
            case "all" -> toJSON();
            case "more_expensive" -> moreExpensive();
            case "all_sorted" -> allSorted();
            default -> "Comando Errato";
        };
    }



}

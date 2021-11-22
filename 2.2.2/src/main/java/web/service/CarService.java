package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private List<Car> cars = new ArrayList<>();

    public static List<Car> carsCount(List<Car> list, int num){
if (num == 0 || num > 5)return list;
return list.stream().limit(num).collect(Collectors.toList());
    }
}

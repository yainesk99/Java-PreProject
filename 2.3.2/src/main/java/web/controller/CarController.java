package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/cars")
public class CarController {
    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars,
                       Model model){
        List<Car> list = new ArrayList<>();
        list.add(new Car("Mersedes Benz", 2, "crossover"));
        list.add(new Car("BMW", 5, "sedan"));
        list.add(new Car("Audi", 3, "hatchback"));
        list.add(new Car("Geely", 2, "crossover"));
        list.add(new Car("Volkswagen", 4, "sedan"));
        list = CarService.carsCount(list, allCars);
        model.addAttribute("list", list);
        return "cars";
    }

}

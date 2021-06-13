package pl.springboot2.karoljanik.cardao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.springboot2.karoljanik.cardao.model.Car;
import pl.springboot2.karoljanik.cardao.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void insertCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @DeleteMapping(path = "{id}")
    public void deleteCar(@PathVariable("id") int id) {
        carService.deleteCar(id);
    }

    @GetMapping(path = "/since/{from_year}/to/{until_year}")
    public List<Car> getByYearRange(@PathVariable("from_year") int fromYear,@PathVariable("until_year") int untilYear) {
        return carService.getByYearRange(fromYear, untilYear);
    }
}

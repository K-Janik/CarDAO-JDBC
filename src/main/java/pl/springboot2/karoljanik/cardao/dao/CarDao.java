package pl.springboot2.karoljanik.cardao.dao;

import pl.springboot2.karoljanik.cardao.model.Car;

import java.util.List;

public interface CarDao {

    void insertCar(Car car);

    List<Car> selectAllCars();

    List<Car> selectByModelYear(int fromYear, int untilYear);

    void deleteCarById(int carId);

}

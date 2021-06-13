package pl.springboot2.karoljanik.cardao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.springboot2.karoljanik.cardao.dao.CarDao;
import pl.springboot2.karoljanik.cardao.model.Car;

import java.util.List;

@Service
public class CarService {

    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("CarDAO") CarDao carDao) {
        this.carDao = carDao;
    }

    public void addCar(Car car) {
        carDao.insertCar(car);
    }

    public List<Car> getAllCars() {
        return carDao.selectAllCars();
    }

    public void deleteCar(int id) {
        carDao.deleteCarById(id);
    }

    public List<Car> getByYearRange(int fromYear, int untilYear) {
        return carDao.selectByModelYear(fromYear, untilYear);
    }

}

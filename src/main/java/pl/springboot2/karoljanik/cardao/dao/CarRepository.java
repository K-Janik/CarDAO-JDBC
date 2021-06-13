package pl.springboot2.karoljanik.cardao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.springboot2.karoljanik.cardao.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("CarDAO")
public class CarRepository implements CarDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertCar(Car car) {
        final String sql = "INSERT INTO car VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
           car.getId(),
           car.getBrand(),
           car.getModel(),
           car.getModelYear()
        });

    }

    @Override
    public List<Car> selectAllCars() {
        final String sql = "SELECT * FROM car";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            int car_id = resultSet.getInt("id");
            String car_brand = resultSet.getString("brand");
            String car_model = resultSet.getString("model");
            int car_year = resultSet.getInt("model_year");
            return new Car(car_id,car_brand,car_model,car_year);
        });
    }

    @Override
    public List<Car> selectByModelYear(int fromYear, int untilYear) {
        final String sql = "SELECT * FROM car WHERE model_year >= ? AND model_year <=?";
        return jdbcTemplate.query(sql,(resultSet, i) ->{
            int car_id = resultSet.getInt("id");
            String car_brand = resultSet.getString("brand");
            String car_model = resultSet.getString("model");
            int car_year = resultSet.getInt("model_year");
            return new Car(car_id,car_brand,car_model,car_year);
        },fromYear,untilYear);
    }

//    @Override
//    public List<Car> selectByModelYear(int fromYear, int untilYear) {
//        final String sql = "SELECT * FROM car WHERE model_year >= ? AND model_year <=?";
//        List<Car> carList = new ArrayList<>();
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, fromYear, untilYear);
//        maps.stream().forEach(element->carList.add(new Car(
//                Integer.parseInt(String.valueOf(element.get("id"))),
//                String.valueOf(element.get("brand")),
//                String.valueOf(element.get("model")),
//                Integer.parseInt(String.valueOf(element.get("model_year")))
//        )));
//        return carList;
//    }

    @Override
    public void deleteCarById(int carId) {
        final String sql = "DELETE FROM car WHERE id=?";
        jdbcTemplate.update(sql, carId);
    }
}

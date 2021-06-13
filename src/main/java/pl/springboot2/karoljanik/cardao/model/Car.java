package pl.springboot2.karoljanik.cardao.model;


public class Car {

  private int id;
  private String brand;
  private String model;
  private int modelYear;

  public Car(int id, String brand, String model, int modelYear) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.modelYear = modelYear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public int getModelYear() {
    return modelYear;
  }

  public void setModelYear(int modelYear) {
    this.modelYear = modelYear;
  }

}

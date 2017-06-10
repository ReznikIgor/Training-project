package carShowroom;

import java.util.List;

public class CarApp {

	public static void main(String[] args) {
		CarManager cm = new CarManager();
		Car cr1 = new Car("Toyota", "Camry", "blue", "AX1234AX");
		Car cr2 = new Car("Toyota", "Corolla", "red", "AB5678AX");
		Car cr3 = new Car("Toyota", "LandCruiser", "black", "HB8765AX");
		cm.addCar(cr1);
		cm.addCar(cr2);
		cm.addCar(cr3);
		List<Car> result = cm.findCars();
		for (Car cr : result) {
			System.out.println(cr);
		}
	}

}

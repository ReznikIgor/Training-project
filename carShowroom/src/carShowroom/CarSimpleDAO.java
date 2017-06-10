package carShowroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarSimpleDAO implements CarDAO {
	private final List<Car> cars = new ArrayList<Car>();

	@Override
	public Long addCar(Car car) {
		Long id = generateCarId();
		car.setCarId(id);
		cars.add(car);
		return id;
	}

	@Override
	public void updateCar(Car car) {
		Car oldCar = getCar(car.getCarId());
		if (oldCar != null) {
			oldCar.setCarBrand(car.getCarBrand());
			oldCar.setCarModel(car.getCarModel());
			oldCar.setCarColour(car.getCarColour());
			oldCar.setCarNumberPlate(car.getCarNumberPlate());
		}
	}

	@Override
	public void deleteCar(Long carId) {
		for (Iterator<Car> it = cars.iterator(); it.hasNext();) {
			Car cr = it.next();
			if (cr.getCarId().equals(carId)) {
				it.remove();
			}
		}
	}

	@Override
	public Car getCar(Long carId) {
		for (Car car : cars) {
			if (car.getCarId().equals(carId)) {
				return car;
			}
		}
		return null;
	}

	@Override
	public List<Car> findCars() {
		return cars;
	}

	private Long generateCarId() {
		Long carId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
		while (getCar(carId) != null) {
			carId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
		}
		return carId;
	}

}

package carShowroom;

import java.util.List;

public class CarManager {
	private CarDAO dao;

	public CarManager() {
		dao = CarDAOFactory.getCarDAO();
	}

	public Long addCar(Car car) {
		return dao.addCar(car);
	}

	public void updateCar(Car car) {
		dao.updateCar(car);
	}

	public void deleteCar(Long carId) {
		dao.deleteCar(carId);
	}

	public Car getCar(Long carId) {
		return dao.getCar(carId);
	}

	public List<Car> findCars() {
		return dao.findCars();
	}

}

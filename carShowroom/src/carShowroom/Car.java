package carShowroom;

public class Car {
	private Long carId;
	private String carBrand;
	private String carModel;
	private String carColour;
	private String carNumberPlate;

	public Car() {
	}

	public Car(String carBrand, String carModel, String carColour, String carNumberPlate) {
		super();
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carColour = carColour;
		this.carNumberPlate = carNumberPlate;
	}

	public Car(Long carId, String carBrand, String carModel, String carColour, String carNumberPlate) {
		super();
		this.carId = carId;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carColour = carColour;
		this.carNumberPlate = carNumberPlate;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	public String getCarNumberPlate() {
		return carNumberPlate;
	}

	public void setCarNumberPlate(String carNumberPlate) {
		this.carNumberPlate = carNumberPlate;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carBrand=" + carBrand + ", carModel=" + carModel + ", carColour=" + carColour
				+ ", carNumberPlate=" + carNumberPlate + "]";
	}

}


public class Address {
	private long id;
	private String country;
	private String street;
	private int zipCode;

	public Address(long id, String country, String street, int zipCode) {
		this.id = id;
		this.country = country;
		this.street = street;
		this.zipCode = zipCode;
	}

	public Address() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}

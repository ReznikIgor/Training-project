package carShowroom;


	public class CarDAOFactory 
	{
	    public static CarDAO getCarDAO() {
	        return new CarSimpleDAO();
	    }
	}



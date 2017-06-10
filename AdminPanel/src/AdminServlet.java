import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String country = request.getParameter("country");
		String street = request.getParameter("street");
		String zip = request.getParameter("zip");
		String role = request.getParameter("Role");
		String[] musicTypes = request.getParameterValues("MusicType");

		User newUser = new User();
		UserDaoImpl DaoUser = new UserDaoImpl();
		newUser.setLogin(username);
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setAge(Integer.parseInt(age));
		Address userAddr = new Address();
		userAddr.setCountry(country);
		userAddr.setStreet(street);
		userAddr.setZipCode(Integer.parseInt(zip));
		newUser.setAddress(userAddr);
		Role userRole = new Role();
		RoleDaoImpl daoRole = new RoleDaoImpl();
		userRole = daoRole.readById(Long.parseLong(role));
		newUser.setRole(userRole);
		Set<MusicType> types = new HashSet<MusicType>();
		MusicTypeDaoImpl daoMus = new MusicTypeDaoImpl();
		for (String type : musicTypes) {
			try {
				types.add(daoMus.readById(Long.parseLong(type)));
			} catch (NumberFormatException | SQLException e) {

				e.printStackTrace();
			}
		}
		newUser.setMusicType(types);

		if (password.equals(confirm) && 1 < Integer.parseInt(age) && Integer.parseInt(age) <= 100) {
			try {
				DaoUser.create(newUser);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("wrongUserData.jsp");
			dispatcher.forward(request, response);
		}
		UserDaoImpl DBUser = new UserDaoImpl();
		List<User> userList = new ArrayList<User>();
		userList = DBUser.getAll();
		request.setAttribute("dataList", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("administrator.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}
}

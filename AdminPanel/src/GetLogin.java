import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetLogin extends HttpServlet {

	public GetLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User LoginUser = new User();

		UserDaoImpl DBUser = new UserDaoImpl();
		LoginUser = DBUser.readByLogin(username);
		if (LoginUser.getPassword() != null) {

			if (LoginUser.getPassword().equals(password)) {
				if (LoginUser.getRole().getRoleName().equals("Registered")) {
					List<User> dataList = new ArrayList<User>();
					dataList.add(LoginUser);
					request.setAttribute("dataList", dataList);
					RequestDispatcher dispatcher = request.getRequestDispatcher("registered.jsp");
					if (dispatcher != null) {
						dispatcher.forward(request, response);
					}
				} else if (LoginUser.getRole().getRoleName().equals("Moderator")) {
					List<User> userList = new ArrayList<User>();
					userList = DBUser.getAll();
					request.setAttribute("dataList", userList);
					RequestDispatcher dispatcher = request.getRequestDispatcher("moderator.jsp");
					if (dispatcher != null) {
						dispatcher.forward(request, response);
					}
				} else if (LoginUser.getRole().getRoleName().equals("Administrator")) {
					List<User> userList = new ArrayList<User>();
					userList = DBUser.getAll();
					request.setAttribute("dataList", userList);
					RequestDispatcher dispatcher = request.getRequestDispatcher("administrator.jsp");
					if (dispatcher != null) {
						dispatcher.forward(request, response);
					}
				}
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("wrongPassOrLogin.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("wrongPassOrLogin.jsp");
			dispatcher.forward(request, response);
		}

	}
}

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

public class DeleteServlet extends HttpServlet {

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		User delUser = new User();
		UserDaoImpl DaoUser = new UserDaoImpl();
		delUser.setId(Integer.parseInt(id));
		try {
			DaoUser.delete(delUser);
		} catch (SQLException e) {
			e.printStackTrace();
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

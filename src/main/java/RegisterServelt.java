import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServelt extends HttpServlet {

	private final static String q1 = "insert into user values(?,?,?,?,?)";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String mobile = req.getParameter("userMob");
		String Dob = req.getParameter("userDob");
		String city = req.getParameter("city");

		try {
			Class.forName("");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("");
			PreparedStatement ps = con.prepareStatement(q1);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, Dob);
			ps.setString(5, city);

			int count = ps.executeUpdate();
			if (count == 1) {
				pw.print("<h2>recorde added succesfull</h2>");
			} else {
				pw.print("<h2>recorde added Failed</h2>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pw.println("<h2>" + e.getMessage() + "</h2>");
		}
		
		pw.println("<a href=\"index.html\"><button type=\"button\">Home</button></a>");
		pw.close();
	}
}

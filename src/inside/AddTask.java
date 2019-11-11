//TODO Разложить по пакетам VIEW, MODEL, CONTOLLER
//TODO Провести Junit тесты для MODEL

package inside;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTask
 */

//@WebServlet("/addTask")
public class AddTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        String pri = request.getParameter("priority");
        //String cat = request.getParameter("category");
        int priority;
        System.out.println("Fuck");

        if(task.isEmpty() || !pri.matches("[1-9][0-9]*"))
            response.sendRedirect(request.getContextPath() + "/inside/display");
        else{
            priority = Integer.parseInt(pri);
            String name = (String)(request.getSession(false).getAttribute("name"));
            Date date = new Date();

            try {
                Class.forName("com.mysql.jdbc.Driver" );
            } catch (Exception e) {
                System.err.println("ERROR: failed to load HSQLDB JDBC driver.FUCK!");
                e.printStackTrace(System.out);
                return;
            }
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://" +
                        "localhost:3306/list?useLegacyDatetimeCode=false&serverTimezone=UTC" , "root", "1234");
                String queryString = "insert into task values(?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(queryString);
                statement.setString(1,name);
                statement.setString(2,task);
                statement.setString(3,Integer.toString(priority));
                statement.setString(4,date.toString().replace(' ', '_'));
                statement.setString(5, "To do");
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            System.out.println("Fuck");
            response.sendRedirect(request.getContextPath() + "/inside/display");
        }
    }

}

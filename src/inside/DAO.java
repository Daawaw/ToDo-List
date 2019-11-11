//TODO Подключение к БД во всех классах черезе класс DAO.

package inside;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DAO {

    private Connection connection;

    public Connection DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.FUCK!");
            e.printStackTrace(System.out);
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" +
                    "localhost:3306/list?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return connection;
    }

    public void register(){


    }
    public void addTask(String name, String task, String priority){
        try {
            Date date = new Date();
            String queryString = "insert into task values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(queryString);
            statement.setString(1, name);
            statement.setString(2, task);
            statement.setString(3, priority);
            statement.setString(4, date.toString().replace(' ', '_'));
            statement.setString(5, "To do");
            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
        }


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql_func {
    final String host = "localhost";
    final String port = "3306";
    final String db = "members1";
    final String id = "root";
    final String pw = "mysql";
    /*Connect Mysql*/
    public Connection connMysql() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, "" + id + "", "" + pw + "");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    /*Execute SQL*/
    public ResultSet executeSQL(Connection connection, String sql) {
        try {
            connection.prepareStatement(sql);
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    /*Get Row count*/
    public Integer getCount(ResultSet resultSet) {
        try {
            resultSet.first();
            Integer count = resultSet.getRow();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }
}

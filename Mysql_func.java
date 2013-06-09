import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql_func {
    final String host = "localhost";    //mysql host
    final String port = "3306";        //mysql port
    final String db = "";             //mysql database
    final String id = "root";          //mysql account
    final String pw = "";             //mysql password

    /*Connect Mysql*/
    public Connection connMysql() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, "" + id + "", "" + pw + "");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*Execute SQL*/
    public Object executeSQL(Connection connection, String sql) {
        try {
            //connection.prepareStatement(sql);
            java.sql.Statement statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if(result == true){ //SELECT
                ResultSet resultSet = statement.getResultSet();
                return resultSet;
            }else{  //INSERT、UPDATE or DELETE
               int count = statement.getUpdateCount();
               return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
            return null;
        }
    }
}

import java.sql.Connection;
import java.sql.ResultSet;

public class demo {
    public static void main(String[] args){
        Mysql_func m = new Mysql_func();
        Connection connection = m.connMysql();
        ResultSet resultSet = m.executeSQL(connection, "SELECT * FROM admin");
        Integer i = m.getCount(resultSet);
        System.out.println("目前資料表總筆數:"+i);
    }
}

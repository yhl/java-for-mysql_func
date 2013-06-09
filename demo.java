import java.sql.Connection;
import java.sql.ResultSet;

public class demo {
    public static void main(String[] args){
        Mysql_func m = new Mysql_func();
        Connection connection = m.connMysql();
        Object resultSet = m.executeSQL(connection, "SELECT * FROM admin");
        //Object resultSet = m.executeSQL(connection, "INSERT admin VALUE('yhlss','1234');");
        Integer i = m.getCount((ResultSet)resultSet);
        System.out.println("Total Count:"+i);
    }
}

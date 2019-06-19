package Home;

import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;
public class DBconnection {
private static String servername = "localhost";
private static String username="root";
private  static String dbname= "fms";
private static Integer portnumber = 8889;
private static String password="root";



public static Connection getConnection() throws SQLException {
	Connection cnx= null;
	MysqlDataSource datasource = new MysqlDataSource();
	datasource.setServerName(servername);
	datasource.setUser(username);
	datasource.setPassword(password);
	datasource.setDatabaseName(dbname);
	datasource.setPortNumber(portnumber);
	cnx = datasource.getConnection();
	return cnx;
}
}

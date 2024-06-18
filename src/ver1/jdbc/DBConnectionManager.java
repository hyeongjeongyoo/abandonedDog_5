package ver1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnectionManager {

	private static HikariDataSource dataSource;
	
	private static final String URL = "jdbc:mysql://192.168.0.117:3306/animal_shelter?serverTimezone=Asia/Seoul";
	private static final String USER = "test";
	private static final String PASSWORD = "0000";
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		config.setMaximumPoolSize(10); // 최대 연결 수 설정 (10개)
		
		dataSource = new HikariDataSource(config);
		
	}
	
	// 정적 메소드(함수) 커넥션 객체를 리턴하는 함수를 만들어 보자.
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
}
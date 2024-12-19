package studentmanagementpoint.config;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_quanlidiem";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASS = "07102004";

    public static Connection getConnection() throws SQLException {
        try {
            // Tải driver MySQL nếu cần (đối với các phiên bản Java cũ hơn 6)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found!", e);
        }
        // Trả về kết nối
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASS);
    }
}

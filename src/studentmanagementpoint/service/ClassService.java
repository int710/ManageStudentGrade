package studentmanagementpoint.service;

import studentmanagementpoint.config.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */

public class ClassService {
    public static List<String> getAllClasses() {
        List<String> classList = new ArrayList<>();
        String sql = "SELECT className FROM class";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                classList.add(rs.getString("className"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classList;
    }
}

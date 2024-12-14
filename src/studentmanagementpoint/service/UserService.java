package studentmanagementpoint.service;

import java.security.NoSuchAlgorithmException;
import studentmanagementpoint.config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import studentmanagementpoint.utils.PasswordHash;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class UserService {

    public static boolean authenticateUser(String uname, String password) throws NoSuchAlgorithmException {
        String sql = "SELECT * FROM account WHERE username = ?";

        try (Connection conn = MySQLConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, uname);
            
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String dbHashPw = rs.getString("password");
                    String hash = PasswordHash.hashPassword(password);
                    return hash.equals(dbHashPw);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

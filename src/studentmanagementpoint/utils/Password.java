package studentmanagementpoint.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import studentmanagementpoint.service.UserService;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 * Mã hóa mật khẩu với SHA-256
 */

public class Password {  
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // convert sang byte
        byte[] hash = digest.digest(password.getBytes());
        // Chuyển mảng byte thành chuỗi hex để dễ lưu trữ
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
    
    public static boolean changedPassword(String username, String passOld, String passNew) throws SQLException, NoSuchAlgorithmException {
        if(UserService.checkOldPasswd(username, passOld)) {
            if(UserService.changedPass(username, passNew)) {
                return true;
            }
        }
        return false;
    }
}

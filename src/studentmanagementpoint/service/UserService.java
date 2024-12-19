package studentmanagementpoint.service;

import java.security.NoSuchAlgorithmException;
import studentmanagementpoint.config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import studentmanagementpoint.dto.StudentModel;
import studentmanagementpoint.utils.ConvertDate;
import studentmanagementpoint.utils.Password;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class UserService {

    private static String role;

    public static String getRole() {
        return role;
    }

    private static void setRole(String role) {
        UserService.role = role;
    }

    public static boolean authenticateUser(String uname, String password) throws NoSuchAlgorithmException {
        String sql = "SELECT * FROM account WHERE username = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uname);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dbHashPw = rs.getString("password");
                    String hash = Password.hashPassword(password);
                    if (hash.equals(dbHashPw)) {
                        setRole(rs.getString("role"));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static StudentModel getStudent(String studentId) throws ParseException {
        String sql = "SELECT * FROM student WHERE studentId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    StudentModel std = new StudentModel(rs.getString("studentId"), rs.getString("fullName"), ConvertDate.convertDateFormat(rs.getString("dob")), rs.getInt("departmentId"), rs.getString("gender"), rs.getString("address"), rs.getInt("classId"));
                    return std;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNameDepartmentById(int departmentId) {
        String sql = "SELECT departmentName FROM department WHERE departmentId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("departmentName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNameByClassId(int classId) {
        String sql = "SELECT classname FROM class WHERE classId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("classname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isStudentExits(String studentId) {
        String sql = "SELECT * FROM account WHERE username = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Nếu tìm thấy tài khoản người dùng, kiểm tra xem thông tin sinh viên đã tồn tại hay chưa
                String sqlStudent = "SELECT * FROM student WHERE studentId = ?";
                try (PreparedStatement pstmtStudent = conn.prepareStatement(sqlStudent)) {
                    pstmtStudent.setString(1, studentId);
                    ResultSet rsStudent = pstmtStudent.executeQuery();
                    return rsStudent.next();
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addAStudent(String studentId,
                String fullName,
                int classId,
                String address,
                String dob,
                String gender) throws NoSuchAlgorithmException, ParseException {
        // Tạo tài khoản người dùng trước
        String sqlAccount = "INSERT INTO account(username, password) VALUES(?, ?)";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlAccount)) {
            pstmt.setString(1, studentId);
            pstmt.setString(2, Password.hashPassword(dob));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Tiến hành thêm thông tin sinh viên 
        String sqlStudent = "INSERT INTO student (studentId, fullName, classId, address, dob, departmentId, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlStudent)) {
            pstmt.setString(1, studentId);
            pstmt.setString(2, fullName);
            pstmt.setInt(3, classId);
            pstmt.setString(4, address);
            pstmt.setString(5, ConvertDate.formatDobToDB(dob));
            pstmt.setInt(6, getDepartmentIdByClass(classId));
            pstmt.setString(7, gender);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean updateStudent(String studentId, String fullName, int classId, String address, String dob, String gender) {
        String sql = "UPDATE student SET fullName = ?, classId = ?, address = ?, dob = ?, departmentId = ?, gender = ? WHERE studentId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fullName);
            pstmt.setInt(2, classId);
            pstmt.setString(3, address);
            pstmt.setString(4, ConvertDate.formatDobToDB(dob));
            pstmt.setInt(5, getDepartmentIdByClass(classId));
            pstmt.setString(6, gender);
            pstmt.setString(7, studentId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getDepartmentIdByClass(int classId) {
        String sql = "SELECT departmentId FROM class WHERE classId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("departmentId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean deleteStudent(String studentId) throws SQLException {
        String sqlStudent = "DELETE FROM student WHERE studentId = ?";
        String sqlAccount = "DELETE FROM account WHERE username = ?";

        try (Connection conn = MySQLConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmtStudent = conn.prepareStatement(sqlStudent)) {
                pstmtStudent.setString(1, studentId);
                pstmtStudent.executeUpdate();
            }
            try (PreparedStatement pstmtAccount = conn.prepareStatement(sqlAccount)) {
                pstmtAccount.setString(1, studentId);
                pstmtAccount.executeUpdate();
            }
            conn.commit();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static boolean checkOldPasswd(String username, String passOld) throws SQLException, NoSuchAlgorithmException {
        String hashPass = Password.hashPassword(passOld); // Mã hóa mật khẩu cũ
        String sql = "SELECT password FROM account WHERE username = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return hashPass.equals(rs.getString("password"));
            }
        }
        return false;
    }

    public static boolean changedPass(String username, String newPass) throws SQLException, NoSuchAlgorithmException {
        String hashPass = Password.hashPassword(newPass);
        String sql = "UPDATE account SET password = ? WHERE username = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hashPass);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

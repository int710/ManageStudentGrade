package studentmanagementpoint.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import studentmanagementpoint.config.MySQLConnection;
import studentmanagementpoint.dto.StudentModel;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class TeacherService {

    public static List<StudentModel> getAllStudent() throws SQLException {
        List<StudentModel> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentModel std = new StudentModel(rs.getString("studentId"), rs.getString("fullName"), rs.getString("dob"), rs.getString("department"), rs.getString("gender"), rs.getString("address"), rs.getInt("classId"));
                students.add(std);
            }
            return students;
        }
    }
    
}

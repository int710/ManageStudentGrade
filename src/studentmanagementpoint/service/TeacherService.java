package studentmanagementpoint.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import studentmanagementpoint.config.MySQLConnection;
import studentmanagementpoint.dto.StudentModel;
import studentmanagementpoint.utils.ConvertDate;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class TeacherService {

    public static List<StudentModel> getAllStudent() throws SQLException, ParseException {
        List<StudentModel> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentModel std = new StudentModel(rs.getString("studentId"), rs.getString("fullName"), ConvertDate.convertDateFormat(rs.getString("dob")), rs.getString("department"), rs.getString("gender"), rs.getString("address"), rs.getInt("classId"));
                students.add(std);
            }
            return students;
        }
    }
    
    public static List<StudentModel> getListByClass(int classId) throws SQLException, ParseException {
        List<StudentModel> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE classId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentModel std = new StudentModel(rs.getString("studentId"), rs.getString("fullName"), ConvertDate.convertDateFormat(rs.getString("dob")), rs.getString("department"), rs.getString("gender"), rs.getString("address"), rs.getInt("classId"));
                students.add(std);
            }
            return students;
        }
    }
    
}

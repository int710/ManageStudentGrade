package studentmanagementpoint.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import studentmanagementpoint.config.MySQLConnection;
import studentmanagementpoint.dto.GradeModel;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class GradenService {

    // Lấy toàn bộ môn học của một sinh viên theo chuyên ngành
    public static List<String> getAllSubject(int departmentId) {
        List<String> subjectList = new ArrayList<>();
        String sql = "SELECT subjectName FROM subject WHERE departmentId = ? OR departmentId IS NULL";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                subjectList.add(rs.getString("subjectName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    public static String getSubjectIdByName(String subjectName) throws SQLException {
        String sql = "SELECT subjectId FROM subject WHERE subjectName = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subjectName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("subjectId");
            }
        }
        return null;
    }

    public static String getSubjectNameById(String subjectId) throws SQLException {
        String sql = "SELECT subjectName FROM subject WHERE subjectId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subjectId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("subjectName");
            }
        }
        return null;
    }

    public static int getCreditSubject(String subjectId) throws SQLException {
        String sql = "SELECT credit FROM subject WHERE subjectId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subjectId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("credit");
            }
        }
        return 0;
    }

    public static boolean insertGrade(String studentId, String subjectId, float componentScore, float midtermScore, float finalScore) throws SQLException {
        String sql = "INSERT INTO grade (studentId, subjectId, componentScore, midtermScore, finalScore) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            pstmt.setString(2, subjectId);
            pstmt.setFloat(3, componentScore);
            pstmt.setFloat(4, midtermScore);
            pstmt.setFloat(5, finalScore);
            return pstmt.executeUpdate() > 0;
        }
    }

    public static boolean updateGrade(String studentId, String subjectId, float componentScore, float midtermScore, float finalScore) throws SQLException {
        String sql = "UPDATE grade SET componentScore = ?, midtermScore = ?, finalScore = ? WHERE studentId = ? AND subjectId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, componentScore);
            pstmt.setFloat(2, midtermScore);
            pstmt.setFloat(3, finalScore);
            pstmt.setString(4, studentId);
            pstmt.setString(5, subjectId);
            return pstmt.executeUpdate() > 0;
        }
    }

    public static boolean deleteGrade(String studentId, String subjectId) throws SQLException {
        String sql = "DELETE FROM grade WHERE studentId = ? AND subjectId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            pstmt.setString(2, subjectId);
            return pstmt.executeUpdate() > 0;
        }
    }

    public static List<GradeModel> getAllGradeByStudentId(String studentId) throws SQLException {
        List<GradeModel> grade = new ArrayList<>();
        String sql = "SELECT * FROM grade WHERE studentId = ?";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                grade.add(new GradeModel(
                            rs.getString("studentId"),
                            rs.getString("subjectId"),
                            rs.getFloat("componentScore"),
                            rs.getFloat("midtermScore"),
                            rs.getFloat("finalScore"),
                            rs.getFloat("finalGrade"),
                            rs.getString("letterGrade")));
            }
            return grade;
        }

    }
}

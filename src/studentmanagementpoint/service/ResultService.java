package studentmanagementpoint.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import studentmanagementpoint.config.MySQLConnection;
import studentmanagementpoint.dto.StudyResultModel;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class ResultService {

    public static StudyResultModel getStudyResultById(String studentId) throws SQLException {
        String sql = "SELECT bangdiem.studentId, bangdiem.gpa, bangdiem.classification, bangdiem.accumulated_credits, bangdiem.failed_credits, "
                    + "(SELECT COUNT(*) FROM studyresult WHERE gpa > bangdiem.gpa) + 1 AS `rank`, "
                    + "(SELECT COUNT(*) FROM studyresult) AS totalStudent "
                    + "FROM studyresult bangdiem WHERE bangdiem.studentId = ?";

        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new StudyResultModel(rs.getString("studentId"),
                            Float.parseFloat(rs.getString("gpa")),
                            rs.getString("classification"),
                            Integer.parseInt(rs.getString("accumulated_credits")),
                            Integer.parseInt(rs.getString("failed_credits")),
                            rs.getInt("rank"),
                            rs.getInt("totalStudent"));
            }
        }
        return null;
    }

    public static List<StudyResultModel> getAllResultStudent() throws SQLException {
        List<StudyResultModel> listResult = new ArrayList<>();
        String sql = "SELECT * FROM studyresult";
        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listResult.add(new StudyResultModel(rs.getString("studentId"), Float.parseFloat(rs.getString("gpa")), rs.getString("classification"), Integer.parseInt(rs.getString("accumulated_credits")), Integer.parseInt(rs.getString("failed_credits")), 0, 0));
            }
            return listResult;
        }
    }

}

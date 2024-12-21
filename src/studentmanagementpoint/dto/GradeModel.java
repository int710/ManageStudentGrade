package studentmanagementpoint.dto;

import java.sql.SQLException;
import studentmanagementpoint.service.GradenService;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class GradeModel {
    private String studentId;
    private String subjectId;
    private float componentScore;
    private float midtermScore;
    private float finalScore;
    private float finalGrade;
    private String letterGrade;

    public GradeModel(String studentId, String subjectId, float componentScore, float midtermScore, float finalScore, float finalGrade, String letterGrade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.componentScore = componentScore;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public float getComponentScore() {
        return componentScore;
    }

    public void setComponentScore(float componentScore) {
        this.componentScore = componentScore;
    }

    public float getMidtermScore() {
        return midtermScore;
    }

    public void setMidtermScore(float midtermScore) {
        this.midtermScore = midtermScore;
    }

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }

    public float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(float finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    
    public int getCredit() throws SQLException {
        return GradenService.getCreditSubject(subjectId);
    }
    
    public String getNameSubjectById() throws SQLException {
        return GradenService.getSubjectNameById(subjectId);
    }

    public String statusSubject() {
        return finalGrade <= 4 ? "Học lại" : "Đạt";
    }
}

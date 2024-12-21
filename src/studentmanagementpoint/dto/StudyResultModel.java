
package studentmanagementpoint.dto;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class StudyResultModel {
    private String studentId;
    private float gpa;
    private String classification;
    private int passCredit;
    private int failCredit;
    // Tạo thêm nếu như cần hiển thị thông tin xếp hạng
    private int rank;
    private int total;

    public StudyResultModel(String studentId, float gpa, String classification, int passCredit, int failCredit, int rank, int total) {
        this.studentId = studentId;
        this.gpa = gpa;
        this.classification = classification;
        this.passCredit = passCredit;
        this.failCredit = failCredit;
        this.rank = rank;
        this.total = total;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getPassCredit() {
        return passCredit;
    }

    public void setPassCredit(int passCredit) {
        this.passCredit = passCredit;
    }

    public int getFailCredit() {
        return failCredit;
    }

    public void setFailCredit(int failCredit) {
        this.failCredit = failCredit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public String getRanking() {
        return "" + rank + "/" + total + "";
    }

    @Override
    public String toString() {
        return "StudyResultModel{" + "studentId=" + studentId + ", gpa=" + gpa + ", classification=" + classification + ", passCredit=" + passCredit + ", failCredit=" + failCredit + ", rank=" + rank + ", total=" + total + '}';
    }

    
    
}

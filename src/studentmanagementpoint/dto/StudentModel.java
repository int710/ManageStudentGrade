package studentmanagementpoint.dto;

import studentmanagementpoint.service.UserService;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */

public class StudentModel {
    private String studentId;    // Mã sinh viên
    private String name;         // Tên sinh viên
    private String dob;          // Ngày sinh
    private String department;   // Khoa
    private String gender;       // Giới tính
    private String address;      // Địa chỉ
    private int classId;      // Lớp học
    
    public StudentModel() {
    }

    public StudentModel(String studentId, String name, String dob, String department, String gender, String address, int classId) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.gender = gender;
        this.address = address;
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
    

    // Override phương thức toString() để dễ dàng in thông tin sinh viên
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", classId='" + classId + '\'' +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

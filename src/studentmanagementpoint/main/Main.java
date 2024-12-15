package studentmanagementpoint.main;

import studentmanagementpoint.views.Lecturer;
import studentmanagementpoint.views.Login;
import studentmanagementpoint.views.Student;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class Main {
    private static Login formLogin = new Login();
    public static Lecturer formLectures = new Lecturer();
    public static Student formStudent = new Student();
    public static void main(String[] args) {
        formLogin.setVisible(true);
    }
}

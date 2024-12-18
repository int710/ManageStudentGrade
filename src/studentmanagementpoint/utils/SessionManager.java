
package studentmanagementpoint.utils;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class SessionManager {
    private static String username;
    private static String role;
    private static boolean isLogin = false;
    
    public static void login(String userName, String userRole) {
        username = userName;
        role = userRole;
        isLogin = true;
    }
    
    public static void logout(String username, String role) {
        username = null;
        role = null;
        isLogin = false;
    }
    
    public static String getUsername() {
        return username;
    }

    public static String getRole() {
        return role;
    }
    
    public static boolean isLogin() {
        return isLogin;
    }
    
    public static boolean isAdmin() {
        return role.equalsIgnoreCase("Admin");
    }
    
    public static boolean isMember() {
        return role.equalsIgnoreCase("Member");
    }
}

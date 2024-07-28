/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food_project2;

public class SessionManager {
    private static String currentUser;
    private static int currentUserID;

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentUser) {
        SessionManager.currentUser = currentUser;
    }

    public static int getCurrentUserID() {
        return currentUserID;
    }

    public static void setCurrentUserID(int currentUserID) {
        SessionManager.currentUserID = currentUserID;
    }
}

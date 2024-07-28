/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food_project;

 import java.util.HashMap;
import java.util.Map;
public class ProductSession {

    private static final Map<String, Object> sessionData = new HashMap<>();

    public static void set(String key, Object value) {
        sessionData.put(key, value);
    }

    public static Object get(String key) {
        return sessionData.get(key);
    }

    public static void clear() {
        sessionData.clear();
    }
}
  


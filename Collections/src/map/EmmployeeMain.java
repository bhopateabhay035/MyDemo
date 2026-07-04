package map;

import java.util.HashMap;
import java.util.Map;

public class EmmployeeMain {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        EmmployeeMutable s = new EmmployeeMutable("GFG", 101, map);
        EmmployeeImMutable m = new EmmployeeImMutable("GFG", 101, map);
        // accessing data
        System.out.println(s); 
        System.out.println(m);
        
        // try to modify the original map
        map.put("3", "third");
        System.out.println(s);   
        System.out.println(m);

    }
}

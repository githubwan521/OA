import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteraItion {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("AA", 1);
        map.put("BB", 2);
        map.put("CC", 3);
        map.put("DD", 4);
        map.put("EE", 5);
        map.put("FF", 5);

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key=" + key + "\t" + "value=" + map.get(key));
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "-->>" + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + "\t" + "value=" + entry.getValue());

        }

        for (Integer integer : map.values()) {
            System.out.println("value=" + integer);
        }
    }
}

package map;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentHashMapExample {

	public static <E> void main(String[] args) {
		Map<Integer,String> map = new ConcurrentHashMap();
		map.put(1,"val1");
		map.put(2,"val2");
		map.put(3,"val3");
		
		Iterator<Map.Entry<Integer,String>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer,String> entry = itr.next();
			System.out.println("before1 "+entry.getKey()+":"+entry.getValue());
			
			if(entry.getKey()==2) {
				map.put(4, "val4");
			}
			System.out.println("after "+entry.getKey()+":"+entry.getValue());
		}
		
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("abc");
		list.add("cde");
		list.add("pqr");
		
		Iterator<String> litr = list.iterator();
		while(litr.hasNext()) {
			String s = litr.next();
			
			if(s.equals("cde"))
				list.add("xyz");
		}
		System.out.println(list);
		
	}

}

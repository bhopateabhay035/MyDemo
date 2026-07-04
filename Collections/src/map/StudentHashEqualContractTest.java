package map;

import java.util.HashMap;
import java.util.Map;

public class StudentHashEqualContractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Student,String> map = new HashMap<>();
		Student s1 = new Student("tom","eco",18);
		Student s2 = new Student("dom","eco",18);
		Student s3 = new Student("tom","eco",19);
		map.put(s1, "commerce");
		map.put(s2, "hist");
		map.put(s3, "comm");
		System.out.println(map);
		System.out.println(map.get(s1));
		System.out.println(map.get(s2));
		System.out.println(map.get(s3));
	}

}

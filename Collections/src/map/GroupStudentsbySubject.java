package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStudentsbySubject {
	public static void main(String[] args) 
    {         
        List<Student> studentList = new ArrayList<Student>();
                  
        studentList.add(new Student("Palz Miomi", "Accounting",4));
        studentList.add(new Student("Vrisha Naik", "Computer Science",11));
        studentList.add(new Student("Henry James", "History",21));
        studentList.add(new Student("Naz Aksa", "Computer Science",6));
        studentList.add(new Student("Sarang Dage", "Accounting",7));
        studentList.add(new Student("Arvin Goyal", "Philosophy",12));
        studentList.add(new Student("Prakash Gowda", "History",7));
        studentList.add(new Student("Imraan Shami", "Accounting",9));
        studentList.add(new Student("Andy Stokes", "Computer Science",10));
        studentList.add(new Student("Sakshi Shetty", "Philosophy",13));
         
        //Grouping students by specialization
        Map<String, List<Student>> subjectToStudentMap = studentList.stream()
        		.collect(Collectors.groupingBy(Student::getSpecialization));
        subjectToStudentMap.forEach((key, value) -> System.out.println(key+" : "+value));
    }

}

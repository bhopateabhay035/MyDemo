package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group employees by department and then by age
//Group employees by age 

public class EmployeeExample {

	String name, department;
    int age,sal;
    
    EmployeeExample(String name, String department, int age,int sal) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.sal = sal;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmployeeExample [name=" + name + ", department=" + department + ", age=" + age +", sal=" + sal + "]";
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<EmployeeExample> employees = Arrays.asList(
			    new EmployeeExample("Alice", "IT", 25,100),
			    new EmployeeExample("Bob", "HR", 30,200),
			    new EmployeeExample("Charlie", "HR", 30,300),
			    new EmployeeExample("Dave", "IT", 25,400),
			    new EmployeeExample("Alice", "HR", 5,500)
			);

	    List<EmployeeExample> admins = employees.stream()
	    	    .filter((user) -> user.department.equals("HR"))
	    	    .collect(Collectors.toList());
	    	    System.out.println(admins);

	    //Group employees by department and then by age
		Map<String, Map<Integer, List<String>>> grouped = employees.stream()
				.collect(Collectors.groupingBy(e -> e.department,
			        Collectors.groupingBy(e -> e.age, 
			            Collectors.mapping(e -> e.name, Collectors.toList()))));
		System.out.println("Group employees by department and then by age "+grouped);
			
		//Group employees by age 
		Map<Integer, List<String>> grouped1 = employees.stream()
				.collect(Collectors.groupingBy(e -> e.age, 
						Collectors.mapping(e -> e.name, Collectors.toList())));
		System.out.println("Group employees by age "+grouped1);
				
		//Group employees by age anotherway2 ie replace String withClass EmployeeExample
		//so that Collectors.mapping not required as it print specific attribute value
		// but withClass EmployeeExample it will print all attribute as per toString
		Map<Integer, List<EmployeeExample>> grouped2 = employees.stream()
				.collect(Collectors.groupingBy(e -> e.age));
		System.out.println("Group employees by age anotherway "+grouped2);
		
		//Collectors.groupingBy can take1 or 2 or 3 arguments

		//Group Employees by Department and Calculate Average Salary
		Map<String, Double> avgSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(
							d -> d.department,
							Collectors.averagingInt(n -> n.sal)
				));
		System.out.println("Average Salary by Department: " + avgSalaryByDept);
				
		//Group Employees by Department and Calculate total Salary
		Map<String, Integer> totSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(
							d -> d.department,
							Collectors.summingInt(n -> n.sal)
				));
		System.out.println("Total Salary by Department: " + totSalaryByDept);
				
		//Find the Top 2 Highest-Paid Employees
		List<String> topN = employees.stream()
				//.sorted(Comparator.comparing(EmployeeExample::getSal ).reversed())
				//or	
				//.sorted((m,n) -> Double.compare(n.getSal(),m.getSal()))
				.map(n -> n.getName()+" "+n.getSal())
				.limit(2)
				.collect(Collectors.toList());
		System.out.println("Top 2 Employees: " + topN);
		
		
		// Sort by name, then by age if name is same
        List<EmployeeExample> sortedEmployees = employees.stream()
            .sorted(Comparator.comparing(EmployeeExample::getName)
                .thenComparing(EmployeeExample::getAge))
            .collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);
        System.out.println();
        
     // Sort by name, then by department in descending
        List<EmployeeExample> sortedEmployees1 = employees.stream()
            .sorted(Comparator.comparing(EmployeeExample::getName)
                .thenComparing(EmployeeExample::getDepartment).reversed())
            .collect(Collectors.toList());

        // Print the sorted list
        sortedEmployees1.forEach(System.out::println);
        
        int rows = 5; // Number of lines in the pattern

        // Outer loop for rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop for printing numbers in each row
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            // Move to the next line after printing all numbers in the row
            System.out.println();
        }
        
        int ar[] = new int[rows];
        for(int i=1;i<=rows;i++){
        int j = i;
        while(j>0){

        	System.out.print(i);
        j--;
        }
        System.out.println();
        }

	}

	
	
}

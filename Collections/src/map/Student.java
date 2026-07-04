package map;

import java.util.Objects;

public class Student {
    String name;
    String specialization;
    int age;
     
    public Student(String name, String specialization, int age) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.age = age;
	}
 
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() 
    {
        return name;
    }
 
    public String getSpecialization() 
    {
        return specialization;
    }

	@Override
	public String toString() {
		return "Student [name=" + name + ", specialization=" + specialization + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, specialization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(name, other.name)
				&& Objects.equals(specialization, other.specialization);
	}
     
   

}

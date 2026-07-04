package example;

public class StaticVar {

	int age;
	String name;
	static String comp; // = "bajaj";
	
	public StaticVar(int age, String name) {
		//super();
		this.age = age;
		this.name = name;
	}
	
	static {
		comp="infosys";
		System.out.println("static block initializes before main() during class loading");
	}
	
	static String compName() {
		//age = age+1; // compiler error as we cannot make changes to non static variables
		comp = "tata";
		return comp;
		
	}
	
	void disp() {
		System.out.println("details are "+age+" "+name+" "+comp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticVar.comp = "bajaj";
		StaticVar c1 = new StaticVar(1,"abc");
		StaticVar c2 = new StaticVar(2,"xyz");
		c1.disp();
		c2.disp();
		System.out.println("company name "+StaticVar.compName()+" or "+c1.compName());
	}
	

}

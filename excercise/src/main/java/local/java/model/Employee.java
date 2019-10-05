package local.java.model;

public class Employee implements Comparable {

	private String firstName;
	private String lastName;
	private Sex sex;
	private Integer age;
	private Double salary;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, Sex sex, Integer age, Double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", age=" + age
				+ ", salary=" + salary + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
		
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}



	@Override
	public int compareTo(Object o) {
		
		double firstSalaty = this.salary;
		Employee e = (Employee) o;
		double secondSalary =e.salary;
		
		if (firstSalaty < secondSalary)
			return -1;
		else if (firstSalaty > secondSalary)
			return +1;
		else
			return 0;
	
	}
	

}

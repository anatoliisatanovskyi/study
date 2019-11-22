package local.java.excercise.json;

import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import local.java.excercise.composition.EntityGenerator;
import local.java.excercise.filesio.ResourceReader;
import local.java.model.Employee;
import local.java.model.Sex;

public class JsonTest {

	/**
	 * 1. We need to create a custom unsigned exception. We will use it to wrap
	 * exceptions that are thrown by a Json library that we'll be using. Create
	 * package local.java.excercise.json. In this package create class
	 * JsonParseException that extends RuntimeException. This class must have two
	 * constructors: first must take in a parameter 'String message' and in
	 * constructor pass it to parent as follows 'super(message)'. Second constructor
	 * must take in two parameters: 'String message, Exception cause' and pass them
	 * to super.
	 * 
	 * 2. In package local.java.excercise.json create interface Jsonifiable with
	 * method 'String toJson()' that throws JsonParseException.
	 * 
	 * 3. We need to create a class that we will be using as to convert to Json. In
	 * package local.java.excercise.json create class EmployeeDetails. It must have
	 * three class fields: String companyName, String departmentName, Employee
	 * employee. This class must have a constructor that will take in and set these
	 * three fields. Json library has some requirements that we must support. Class
	 * must have an empty constructor(that will do nothing). All class fields, that
	 * should be present in json, must have getters and setters. We need to add all
	 * this to class EmployeeDetails. Class must implement interface Jsonifiable. To
	 * implement this method we will use a library class ObjectMapper. We can use it
	 * to translate an object instance to a json String as follows: new
	 * ObjectMapper().writeValueAsString(obj)'. In our case obj will be this
	 * EmployeeDetails object instance. method 'writeValueAsString' will throw
	 * multiple exceptions. Handle them by wrappint the exception to our custom
	 * created one - 'JsonParseException (constructor with two arguments)'.
	 * 
	 * 4. In test create a new EmployeeDetails instance using constructor with three
	 * arguments(use stub values as parameters or generate an employee using utility
	 * class EntityGenerator). Print to console the result of calling method toJson
	 * on the created EmployeeDetails instance.
	 */
	@Test
	public void testWriteObjectAsJsonString() throws Exception {
		
		
		EmployeeDetails ed = new EmployeeDetails( "Google", "IT", new Employee("Bill", "Sherman", Sex.MALE, 55, 598.88));
		System.out.println(ed.toJson());
		//ed.getEmployee().scan(ed.getEmployee());
	}

	/**
	 * In this example we will see how other libraries use annotations to modify
	 * their behaviour. In class Employee on top of method 'getFullName' add
	 * annotation @JsonIgnore Run previous test, that prints json string to console,
	 * with and without the change and compare the results. After this leave the
	 * annotation present.
	 */
	@Test
	public void testLibraryAnnotations() throws Exception {
		System.out.println(new ObjectMapper().writeValueAsString(EntityGenerator.generateCompanies()));
	}

	/**
	 * Read the contents of file 'src/main/resources/json/employeeDetails.json' as a
	 * String. You can lookup how its done in class
	 * local.java.excercise.filesio.ResourceReader and add a new method 'public
	 * String readAsString(String path)'. This String will contain a json
	 * representation of EmployeeDetails object. To translate the String to an
	 * object instance we will use a json library class as follows: 'new
	 * ObjectMapper().readValue(json, EmployeeDetails.class)'. Here parameter 'json'
	 * is the string that we previously read from file. the result of calling this
	 * is an instance of EmployeeDetails. Using getter methods print out it's
	 * contents and check that all fields are present and not null.
	 */
	@Test
	public void testReadObjectFromJsonString() throws Exception {
		ObjectMapper Mapper = new ObjectMapper();
		Mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String json = ResourceReader.readAsString("json/employeeDetails.json");
		EmployeeDetails baby = Mapper.readValue(json, EmployeeDetails.class);
		Class<EmployeeDetails> c = EmployeeDetails.class;
		EmployeeDetails instance = c.newInstance();
		System.out.println(baby);
	}

	/**
	 * In class EmployeeDetails remove the empty constructor. Try running previous
	 * test and check whether an exception is thrown and it's message. You can also
	 * check what errors are thrown in case you nest some errors in json format of
	 * the file 'src/main/resources/json/employeeDetails.json', e.g: remove a bracer
	 * or a column; add an new field that is not present in the class. Thrown
	 * exceptions will have some description in the message
	 */
	@Test
	public void testInvalidJsonRequirements() throws Exception {

	}
}

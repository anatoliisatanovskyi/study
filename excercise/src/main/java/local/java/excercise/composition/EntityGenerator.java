package local.java.excercise.composition;

import java.util.*;

import local.java.excercise.filesio.ResourceReader;
import local.java.excercise.randomization.Randomizer;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;

public class EntityGenerator {

	public static Employee generateEmployee(Queue <String> firstNames, Queue<String> lastNames) {
		
		
		Employee employee = new Employee(firstNames.poll(), lastNames.poll(), Randomizer.generateSex(), Randomizer.randomizeInteger(20, 60), Randomizer.randomizeDoule(500, 7000, 2));
		
		return employee;
			
	}

	public static Department generateDepartment(Queue <String> departmentName,int employees) {
	String path_firstNames = "filesio/first_names.txt";
	String path_lastNames = "filesio/last_names.txt";
		List emploeesList = new ArrayList();
		Queue qFirstNames = Randomizer.queueGenerator(ResourceReader.readAsList(path_firstNames));
		Queue qLastNames = Randomizer.queueGenerator(ResourceReader.readAsList(path_lastNames));
for ( int i = 0; i < employees; i++) {
	emploeesList.add(generateEmployee(qFirstNames, qLastNames ));
		}
		
		Department department = new Department(departmentName.poll(), emploeesList  );

		return department;
	}

	public static Company generateCompany(List<Department> departmentEmployees) {
		String path = "filesio/company_names.txt";
    List companyList = ResourceReader.readAsList(path);
    Queue queue = Randomizer.queueGenerator(companyList);
	
		
		Company Mycompany = new Company((String)queue.poll(), departmentEmployees );		
		
		return Mycompany;
	}

}

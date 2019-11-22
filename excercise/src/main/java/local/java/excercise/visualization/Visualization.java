package local.java.excercise.visualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import local.java.excercise.datapresentation.CompanyView;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.Sex;

public class Visualization {

	private static final String SALARY_CSV = "salary.csv";
	private static final String AGE_CSV = "age.csv";

	private File createEmptyCsv(String filename) throws IOException {
		String filepath = resourceRootPath() + File.separator + "web" + File.separator + filename;
		File file = new File(filepath);
		if (file.exists())
			file.delete();
		file.createNewFile();
		return file;
	}

	private String resourceRootPath() {
		return new StringBuilder()
				.append(new File(this.getClass().getClassLoader().getResource(".").getFile()).getParentFile()
						.getParentFile().getAbsolutePath())
				.append(File.separator).append("src").append(File.separator).append("main").append(File.separator)
				.append("resources").toString();
	}

	public void csvWrite(Company company, String fileName) {

		try {

			File file = createEmptyCsv(fileName);
			PrintWriter pr = new PrintWriter(file);
			pr.println("name,salary");
			for (Department d : company.getDepartments()) {
				for (Employee e : d.getEmployees()) {
					pr.println(e.getFirstName() + "," + e.getSalary());
					// String.join(delimiter, elements)
				}
			}

			pr.flush();
		} catch (IOException e) {
			System.out.println("Error occurded" + e.getMessage());

		}

	}

	public void csvWriteBySalaryAscending(Company company, String fileName) {
		List<Employee> bySalary = new ArrayList<>();

		try {

			File file = createEmptyCsv(fileName);
			PrintWriter pr = new PrintWriter(file);
			pr.println("name,age,salary");
			bySalary.addAll(CompanyView.filterByAgeFromToGender(company, 30, 55, Sex.MALE));
			Collections.sort(bySalary, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					if (o2.getAge().compareTo(o1.getAge()) == 0) {
						
						System.out.println("******************************");
						System.out.println((o1.getFullName().compareTo(o2.getFullName())));
						return o1.getFullName().compareTo(o2.getFullName());
					}
					
					System.out.println(o2.getAge().compareTo(o1.getAge()));
					return o2.getAge().compareTo(o1.getAge());
					
				}
			});

			for (Employee e : bySalary) {

				pr.println(e.getFullName() + "," + e.getAge() + "," + e.getSalary());

			}

			pr.flush();
		} catch (IOException e) {
			System.out.println("Error occurded" + e.getMessage());

		}

	}

}

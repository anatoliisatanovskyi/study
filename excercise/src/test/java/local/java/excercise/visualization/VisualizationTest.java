package local.java.excercise.visualization;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import local.java.excercise.composition.EntityGenerator;
import local.java.excercise.datapresentation.CompanyView;
import local.java.model.Company;
import local.java.model.Sex;

public class VisualizationTest {

	private static final String SALARY_CSV = "salary.csv";
	private static final String AGE_CSV = "age.csv";
	
	@Test
	public void csvWrite() throws Exception {
		EntityGenerator.generateCompanies();
		Visualization v = new Visualization();

		for (Company c : EntityGenerator.generateCompanies()) {

			// v.csvWrite(c, SALARY_CSV);
			v.csvWriteBySalaryAscending(c, SALARY_CSV);

		}

	}

	/**
	 * Using EntityGenerator generate one Company. Create file
	 * src\main\resources\web\salary.csv and write to it data with company employees
	 * name and salary in following format: first line must be 'name,salary'; all
	 * following lines must be comma separated employee full names and salary, e.g:
	 * John Doe,2000.00
	 * 
	 * For file writer use method 'File createEmptyCsv(String filename)' that is
	 * provided in this class below. This method returns empty csv file where lines
	 * should be written. As 'filename' parameter use 'SALARY_CSV' from this class
	 * header.
	 * 
	 * After successfully running the test open in browser file
	 * src\main\resources\web\salary.html and make sure that it displays the chart
	 * correctly.
	 * 
	 * <Additionally> Write to file lines, sorted by salary in ascending order and
	 * check with UI chart
	 */
	@Test
	public void testSalary() throws Exception {
	}

	/**
	 * This example will contain a generic description of a task that developer
	 * usually gets.
	 * 
	 * As a data analyst, I would like to have an ability to view company employees
	 * using a web chart. The chart should include first names, second names and
	 * age. It should include only male employees who's age is between 30 to 55
	 * inclusively. Chart should display employees in descending order by age.
	 * 
	 * <Additionally> For those employees who's age is the same - must show them in
	 * ascending order by first and last name.
	 * 
	 * When writing to csv file use name 'age.csv'. Check results with file
	 * src\main\resources\web\age.html
	 */
	@Test
	public void testAgeTaskRequest() throws Exception {
		Visualization v = new Visualization();
		for (Company c : EntityGenerator.generateCompanies()) {
v.csvWriteBySalaryAscending(c, AGE_CSV);

		}

	}

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
}

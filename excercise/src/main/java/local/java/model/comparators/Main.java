package local.java.model.comparators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		String configFilePath = args[0];
		
		try {
			Properties proeprties = new Properties();
			try (FileInputStream fis = new FileInputStream(new File(configFilePath))) {
				proeprties.load(fis);
			}
			System.out.println(proeprties);
			System.out.println(proeprties.getProperty("key1"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("args=" + Arrays.toString(args));
	}
}

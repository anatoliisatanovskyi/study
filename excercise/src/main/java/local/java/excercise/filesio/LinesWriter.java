package local.java.excercise.filesio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LinesWriter {

	public static void writeNew(String path, List<String> lines) throws IOException {
		write(path, lines, true);
	}

	public static void write(String path, List<String> lines, boolean doDelete) throws IOException {
		if (doDelete) {
			recreateFileIfExists(path);
		}

		try (FileWriter fw = new FileWriter(path)) {
			for (String line : lines) {
				fw.write(line + "\n");
			}
		}
	}

	private static void recreateFileIfExists(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
	}
}

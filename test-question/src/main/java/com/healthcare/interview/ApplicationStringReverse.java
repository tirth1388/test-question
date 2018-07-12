package com.healthcare.interview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ApplicationStringReverse {
	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		List<String> lines;
		StringBuilder builder = new StringBuilder();
		File file = new File("C:\\Users\\Saloni\\Desktop\\Output.txt");
		FileOutputStream os = null;

		try {
			lines = Files.readAllLines(Paths.get("C:\\Users\\Saloni\\Desktop\\1.txt"));
			os = new FileOutputStream(file);
			System.out.println(lines);
			for (String string : lines) {
				String results = reverseString.reverseWords(string);
				System.out.println(results);
			}
			// creating the file
			file.createNewFile();

			for (String string : lines) {
				String results = reverseString.reverseWords(string);
				builder.append(results);
				builder.append("\n");
			}
			System.out.println(builder.toString());
			os.write(builder.toString().getBytes());
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}

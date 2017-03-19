package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Class calculates maximum and minimum number in file, arithmetic average and median in file.
 * 
 * @author  sergiowork
 * @version 0.1
 */
public class TestFileLogic {
	
	/** File path. */
	private static String filePath;

	/** Set file path. */
	public static void setFilePath(String path) {
		filePath = path;
	}

	/** Get file path. */
	public static String getFilePath() {
		return filePath;
	}
	

	/**
	 * Check file is it empty.
	 * 
	 * @param fileName Name of file.
	 * @return checkFile Boolean type: false - if file is empty, true - is file not empty.
	 * @throws IOException if file can't open.
	 */
	public static boolean checkFile(String fileName) {
		boolean checkFile = false;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			if ((reader.readLine()) == null) {
				JOptionPane.showMessageDialog(null, "Файл пустой.   Выберите файл с набором целых чисел.");
				checkFile = false;
			} else {
				checkFile = true;
			}
			
			reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return checkFile;
	}

	/**
	 * Find maximum number in file.
	 * 
	 * @param fileName Name of file.
	 * @return biggestNumber Maximum number in file.
	 * @throws IOException if file can't open.
	 */
	public static int maxNumberInFile(String fileName) {
		int biggestNumber = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line;
			biggestNumber = Integer.MIN_VALUE;
			int number;

			while ((line = reader.readLine()) != null) {
				try {
					number = Integer.parseInt(line);
					biggestNumber = number > biggestNumber ? number : biggestNumber;
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}

			reader.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return biggestNumber;
	}

	/**
	 * Find minimum number in file.
	 * 
	 * @param fileName Name of file.
	 * @return lowestNumber Minimum number in file.
	 * @throws IOException if file can't open.
	 */
	public static int minNumberInFile(String fileName) {
		int lowestNumber = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line;
			lowestNumber = Integer.MAX_VALUE;
			int number;

			while ((line = reader.readLine()) != null) {
				try {
					number = Integer.parseInt(line);
					lowestNumber = number < lowestNumber ? number : lowestNumber;
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}

			reader.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return lowestNumber;
	}

	/**
	 * Find arithmetic average in file.
	 * 
	 * @param fileName Name of file.
	 * @return average Arithmetic average in the file.
	 * @throws IOException if file can't open.
	 */
	public static double averegeInFile(String fileName) {
		double average = 0;

		try {

			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			int sum = 0;
			int numbersOfFile = 0;

			while (true) {
				String line = reader.readLine();

				if (line == null)
					break;
				sum += Integer.parseInt(line);
				numbersOfFile++;
			}

			reader.close();

			average = (double) sum / numbersOfFile;

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return average;
	}

	/**
	 * Convert dynamic array to static array.
	 * 
	 * @param integers Dynamic array of Integer.
	 * @return ints Static array of int.
	 */
	private static int[] buildIntArray(List<Integer> integers) {
		int[] ints = new int[integers.size()];
		int i = 0;
		for (Integer n : integers) {
			ints[i++] = n;
		}
		return ints;
	}

	/**
	 * Find median in file.
	 * 
	 * @param fileName Name of file.
	 * @return median Median in file.
	 * @throws IOException if file can't open.
	 */
	public static double medianInFile(String fileName) {
		double median = 0;

		try {

			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line;
			int number;
			ArrayList<Integer> numbers = new ArrayList<Integer>();

			while ((line = reader.readLine()) != null) {
				number = Integer.parseInt(line);
				numbers.add(number);
			}

			int[] values = buildIntArray(numbers);
			Arrays.sort(values);

			if (values.length % 2 == 0) {
				median = (double) (values[values.length / 2] + values[(values.length / 2) - 1]) / 2;
			} else {
				median = (double) values[values.length / 2];
			}

			reader.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return median;
	}

}

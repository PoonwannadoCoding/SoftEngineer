package class1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class stat {
	static ArrayList<Integer> result = new ArrayList<>();

	public static void readFIle(String filename){
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while (br.ready()) {
				result.add(Integer.valueOf(br.readLine()));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static double calculateAverage(List<Integer> marks) {
		Integer sum = 0;
		if(!marks.isEmpty()) {
			for (Integer mark : marks) {
				sum += mark;
			}
			return sum.doubleValue() / marks.size();
		}
		return sum;
	}

	public static double calculateSD(List<Integer> numArray)
	{
		double sum = 0.0, standardDeviation = 0.0;
		int length = numArray.size();
		for(double num : numArray) {
			sum += num;
		}
		double mean = sum/length;

		for(double num: numArray) {
			standardDeviation += Math.pow(num - mean, 2);
		}
		return Math.sqrt(standardDeviation/length);
	}

	public static void main(String args[]) {
		String filename = args[0];
		readFIle(filename);
		Collections.sort(result);
		System.out.println("mean: "+ calculateAverage(result));
		System.out.println("std: " + calculateSD(result));
		System.out.println("min: "+ result.get(0));
		System.out.println("max: "+ result.get(result.size()-1));


	}
}
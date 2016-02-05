package CPUSchedulerpPH;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CPUConfiguration {
	private final String INPUT_FILE = "input.data";
	private File input;
	protected Scanner scan;
	protected boolean premptive;
	protected int quantum;
	protected int numberOfProcesses;
	
	public CPUConfiguration() throws FileNotFoundException{
		input = new File(INPUT_FILE);
		scan = new Scanner(input);
		numberOfProcesses = scan.nextInt();
		if (scan.nextInt() == 1) {
			premptive = true;
		} else {
			premptive = false;
		}
		quantum = scan.nextInt();
	}
}

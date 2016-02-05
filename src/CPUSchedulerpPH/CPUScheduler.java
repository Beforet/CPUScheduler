package CPUSchedulerpPH;

import java.io.*;
import java.util.*;

public class CPUScheduler {
	private static CPUConfiguration config;
	private static Processes processes;
	private static PriorityQueue<Process> readyQueue;
	private static Process newProcess;
	private static Process currentProcess;
	private static PrintWriter printer;
	private static int time;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		config = new CPUConfiguration();
		processes = new Processes(config);
		
		readyQueue = new PriorityQueue<Process>();
		printer = new PrintWriter("output.data");	
		
		readyQueue.add(processes.popFirstProcess());
		currentProcess = readyQueue.peek();
		
		time = 0;	
		
		do{
			try{
				newProcess = processes.popNewProcess(time);
				readyQueue.add(newProcess);
			}			
			catch(NoNewProcessException e){
				;
			}
			
			if(currentProcess != readyQueue.peek()){
				printer.println(currentProcess);
				currentProcess = readyQueue.peek();
				currentProcess.primeForExecution(time);
			}
			
			try{
				currentProcess.execute(time);
			}
			catch (ProcessTerminatedException e){
				printer.println(currentProcess);
				readyQueue.remove();
				currentProcess = readyQueue.peek();
				if (currentProcess != null){
					currentProcess.primeForExecution(time);
				}
			}
			
			time++;
			//System.out.println(readyQueue);
		} while (!readyQueue.isEmpty() || !processes.isEmpty());
		printer.close();
	}
}

package CPUSchedulerpPH;

import java.util.*;

public class Processes {
	private ArrayList<Process> processList;
	
	public Processes(CPUConfiguration config) {
		int id = 1;
		processList = new ArrayList<Process>();
		while (config.scan.hasNext()){
			int arrival = config.scan.nextInt();
			int burst = config.scan.nextInt();
			int priority = config.scan.nextInt();
			processList.add(new Process(arrival, burst, priority, id++));
		}		
	}
	
	public Process popFirstProcess() {
		Process first = processList.get(0);
		for(int i=1; i < processList.size(); i++){
			Process next = processList.get(i);
			if(first.arrivalTime > next.arrivalTime){
				first = next;
			}
		}
		processList.remove(first);
		return first;
	}
	
	public Process popNewProcess(int time) throws NoNewProcessException{
		if (processList.isEmpty()){
			throw new NoNewProcessException("There is no new process");
		}
		Process newProcess = null;
		
		for (int i = 0; i < processList.size(); i++){
			if (processList.get(i).arrivalTime <= time){
				newProcess = processList.get(i);
				processList.remove(i);
			}
		}		 
		if (newProcess == null){
			throw new NoNewProcessException("There is no new process");
		}
		return newProcess;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return processList.isEmpty();
	}
	
}

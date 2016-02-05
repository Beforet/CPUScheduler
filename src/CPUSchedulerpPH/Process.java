package CPUSchedulerpPH;

public class Process implements Comparable<Process> {
	protected int id;
	protected int startTime;
	protected int endTime;
	protected int priority;
	protected int arrivalTime;
	protected int burstTime;	
	protected int timeSpentExecuting;
	
	public Process(int arrivalTime, int burstTime, int priority, int id) {
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
		this.id = id;
		startTime = arrivalTime;	
		timeSpentExecuting = 0;
	}
	
	public void primeForExecution(int time){
		if(startTime < time) {
			startTime = time;		
		}
	}
	
	public void execute(int time) throws ProcessTerminatedException{		
		endTime = time;
		if(timeSpentExecuting++ == burstTime){
			throw new ProcessTerminatedException("Process terminated");
		}
	}
	
	public int compareTo(Process p) {
		if(this.priority > p.priority) {
			return -1;
		} else if(this.priority < p.priority) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString(){
		return "" + startTime + '\t' + endTime + '\t' + id;
	}
}

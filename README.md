CPU Process Scheduler Simulation

This program simulation the scheduling processes of a CPU, employing a preemptive High Priority
scheduling algorithm. What this means is that processes become available to the CPU at different
times, and if a process with a higher priority arrives while another process is executing, the
current process is interrupted and the new process begins execution.

To use this program, you need an input file called "input.data" that defines how many processes there are,
whether the program uses a preemptive or round robin algorithm, when to check if a process with a higher priority
is available for execution, when each process arrives, how long the process takes to execute, and what its priority is. 

input.data<br>
10 (number of processes)<br>
0 (if not RR nor preemptive, 1 for opposite) 2 (=quantum)<br>
3 (arriving time for P1) 12(burst time) 2(priority)<br>
…<br>
0 (arriving time for P10) 7(burst time) 5(priority)

A file, "output.data" is made that describes when each process begins execution. The file should take the following
format:

output.data<br>
0(start) 7(end) 10 (process #)<br>
7(start) 21(end) 1(process #)<br>
…<br>
102(start) 115(end) 8(process #)

This program was made as part of a school project for SUNY College at New Paltz's Operating Systems course.
This readme includes some text from the project documentation, in particular the format for the input and
output files. 
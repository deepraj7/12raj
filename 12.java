import java.util.*;
class Process
{

	int pid, bt, at, ct, tat, wt, btt;  //variables
	
	// Process(){}

	Process(int p, int b, int a)   //parameterized constructor
	{
		pid = p;
		bt = b;
		at = a;
		btt = b;
	}
}

class RunScheduler {

	static int pro;
	static float atat=0;
	static float awt=0;
	static ArrayList<Process> ar = new ArrayList(); //creation of ar ArrayList object

	public static void main(String args[])  //main function
	{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		pro = sc.nextInt();
		System.out.println("\n");
		System.out.println("Pid AT BT\t");
		for (int i = 0; i < pro; i++) 
		{
			int pid = sc.nextInt();
			int at = sc.nextInt();
			int bt = sc.nextInt();
			ar.add(new Process(pid, bt, at));
		} //input of process id,arrival time and burst time; and adding them to ArrayList object
		LRTF(); //call of the Scheduler function
		display(); //showing data
	}

	static int allDone()
{
		int is = 0;
		for (Process p : ar)
		{
			if (p.bt > 0)
			{
				is += 1;
			}
		}
		return is;  //used to ensure that if burst time is 0, then when the next process is reached then the burst time is incremented
	}

	static void LRTF()
	{
		ArrayList<Process> readyqueue = new ArrayList(); //another Arraylist with readyqueue type object to store varibles
		int timer = 0, ct = 0, m = 0;  //timer to increment the process time and completion time alongwith a counter varible m
		System.out.println("\t\t\t\t\tGaant Chart\n");

		do {

			if (readyqueue.size() < pro)
			{
				for (int j = 0; j < pro; j++) 
				{
					if ((ar.get(j)).at == timer && (ar.get(j)).bt > 0)  //if the current process is equal to the incremented timer and burst time>0
					{
						readyqueue.add(ar.get(j)); //add process to readyqueue object
					}
				}
			} // System.out.println("ReadyQueue Size:"+readyqueue.size());
			if (readyqueue.size() <= 0)
			{
				timer++;  //if the size of readyqueue is still 0,without any processes in it, increment timer
				continue;
			}
			Process lpro = (Process) readyqueue.get(0);   //lpro object of Process type
			for (int k = 0; k < readyqueue.size(); k++) 
			{
				if ((readyqueue.get(k)).bt <= 0)  //if the burst time of the process is 0,then work's over and it's removed from readyqueue
				{
					readyqueue.remove(k);
				}
			}
			
			for (int k = 0; k < readyqueue.size(); k++) 
			{
				if (lpro.bt < (readyqueue.get(k)).bt && (readyqueue.get(k)).bt > 0) //comparison of the burst times of the current process and the process residing in ready queue
				{
					lpro = (Process) (readyqueue.get(k));
				} else if (lpro.bt == (readyqueue.get(k)).bt && (readyqueue.get(k)).bt > 0)
				 {
					lpro = (Process) priority(lpro, readyqueue.get(k)); //if burst times of both get equal, then placed in priority function
				}
				if ((readyqueue.get(k)).bt <= 0) 
				{
					readyqueue.remove(k); // when burst time gets 0, process removed from readyqueue
				}
			}
			//gaant chart
			System.out.print("P["+lpro.pid+"]"+"-> ");
			
			timer++;
			if (lpro.bt > 0)
			{
				lpro.bt -= 1;
				lpro.ct = timer;
				lpro.tat = lpro.ct - lpro.at; 
				lpro.wt = lpro.tat - lpro.btt; //calculation of all the parameters 
			}
			
		} while (allDone() > 0 || readyqueue.size() > 0);
}

	static Process priority(Process lp, Process rp) //priority function to decide the shortest id
	{
		if (lp.pid > rp.pid)
		{
			return rp;
		} else
			return lp;
	}

	static void display() // to display the parameters
	{
		System.out.println("\n\n");
		System.out.println("Process id  Arrival time    Burst time    Completion time   Turn around time   Waiting time");
		for (Process ob : ar)
		{
			atat+=ob.tat;
			awt+=ob.wt;
			System.out.println(" "+ob.pid + "\t\t" + ob.at + "\t\t" + ob.btt + "\t\t" + ob.ct + "\t\t  " + ob.tat + "\t\t  " + ob.wt);
		}
		atat=(float)(atat/pro);
		awt=(float)(awt/pro);
		System.out.println("\n\n");
		System.out.println("\t\t\tAverage turnaround time is: \t"+atat+"\n\t\t\tAverage waiting time is:\t"+awt);
	}
}
/*
Test Cases
1st-
 * 3   
   2132 0 2
   2102 2 4
   2453 4 8

2nd-
   4
   1 1 2
   2 2 4
   3 3 6
   4 4 8

3rd-
	5
	1 1 3
	2 2 5
	3 3 7
	4 4 9
	5 5 13
 */

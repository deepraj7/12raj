import java.util.*;
class Process
{
	int pid, bt, at, ct, tat, wt, btt;
	
	// Process(){}

	Process(int p, int b, int a)
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
	static ArrayList<Process> ar = new ArrayList();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		pro = sc.nextInt();
		System.out.println("\n");
		System.out.println("Pid AT BT\t");
		for (int i = 0; i < pro; i++) {

			int pid = sc.nextInt();

			int at = sc.nextInt();
			int bt = sc.nextInt();
			ar.add(new Process(pid, bt, at));
		}
		LRTF();
		display();
	}

	static int allDone()

	{
		int is = 0;
		for (Process p : ar) {
			if (p.bt > 0) {
				is += 1;
			}
		}
		return is;
	}

	static void LRTF() {
		ArrayList<Process> readyqueue = new ArrayList();
		int timer = 0, ct = 0, m = 0;
		System.out.println("\t\t\t\t\tGaant Chart\n");
		do {
			if (readyqueue.size() < pro) {
				for (int j = 0; j < pro; j++) {
					if ((ar.get(j)).at == timer && (ar.get(j)).bt > 0) {
						readyqueue.add(ar.get(j));

					}
				}
			} // System.out.println("ReadyQueue Size:"+readyqueue.size());
			if (readyqueue.size() <= 0) {
				timer++;
				continue;

			}
			Process lpro = (Process) readyqueue.get(0);
			for (int k = 0; k < readyqueue.size(); k++) 
			{

				if ((readyqueue.get(k)).bt <= 0) 
				{
					readyqueue.remove(k);
				}
			}
			
			for (int k = 0; k < readyqueue.size(); k++) 
			{
				if (lpro.bt < (readyqueue.get(k)).bt && (readyqueue.get(k)).bt > 0) 
				{
					lpro = (Process) (readyqueue.get(k));
				} else if (lpro.bt == (readyqueue.get(k)).bt && (readyqueue.get(k)).bt > 0)
				 {
					lpro = (Process) priority(lpro, readyqueue.get(k));
				}
				if ((readyqueue.get(k)).bt <= 0) 
				{
					readyqueue.remove(k);
				}
			}
			//gaant chart
			System.out.print("P["+lpro.pid+"]"+"-> ");
			
			timer++;
			if (lpro.bt > 0) {
				lpro.bt -= 1;
				lpro.ct = timer;
				lpro.tat = lpro.ct - lpro.at;
				lpro.wt = lpro.tat - lpro.btt;
			}
			
		} while (allDone() > 0 || readyqueue.size() > 0);
}

	static Process priority(Process lp, Process rp) {
		if (lp.pid > rp.pid) {
			return rp;
		} else
			return lp;
	}

	static void display() {
		System.out.println("\n\n");
		System.out.println("Process id  Arrival time    Burst time    Completion time   Turn around time   Waiting time");
		for (Process ob : ar) {
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
//for compilation in cmd, use:
//javac (file_name).java
//java RunScheduler
/*
 * 3   
2132 0 2
2102 2 4
2453 4 8
 */

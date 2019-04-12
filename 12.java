import java.util.*;
class Process
{
	int pid,bt,at,ct,tat,wt,btt;
//Process(){}

Process(int p,int b,int a)
{
	pid=p;
	bt=b;
	at=a;
	btt=b;
}
}
class RunScheduler
{

	static int pro;
	static ArrayList<Process>ar=new ArrayList();

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes");
		pro=sc.nextInt();
		System.out.println("Pid \t Bt \t at\t");
		for(int i=0;i<pro;i++)
		{

			int pid=sc.nextInt();
			int bt=sc.nextInt();
			int at=sc.nextInt();
			ar.add(new Process(pid,bt,at));
		}
		LRTF();
		display();

	}
	static int allDone()

	{
		int is=0;
		for(Process p:ar)
		{
			if(p.bt>0)
			{
				is+=1;
			}
		}
		return is;
	}
	
	static void LRTF()
	{
		ArrayList<Process>readyqueue=new ArrayList();
		int timer=0,ct=0,m=0;
		do
		{
			if(readyqueue.size()<pro){
			for(int j=0;j<pro;j++)
			{
				if((ar.get(j)).at==timer && (ar.get(j)).bt>0)
				{
					readyqueue.add(ar.get(j));
					
					
				}
			}
		}   //System.out.println("ReadyQueue Size:"+readyqueue.size());
			Process lpro=(Process)readyqueue.get(0);
			//System.out.println(lpro.bt);
			
			//System.out.println();
			System.out.println("\nBefore Remove:");
			for(Process i : readyqueue){
				System.out.print(i.pid+" "+i.bt+" / ");
			}
		    System.out.print("Before LONG:"+lpro.pid+" ");
		    for(int k=0;k<readyqueue.size();k++)
			{

				if((readyqueue.get(k)).bt<=0)
				{
					readyqueue.remove(k);
				}
			}
			for(int k=0;k<readyqueue.size();k++)
			{
				if(lpro.bt<(readyqueue.get(k)).bt && (readyqueue.get(k)).bt>0)
				{
					lpro=(Process)(readyqueue.get(k));
				}
				else if(lpro.bt==(readyqueue.get(k)).bt && (readyqueue.get(k)).bt>0)
			    {
					lpro=(Process)priority(lpro,readyqueue.get(k));
				}
				if((readyqueue.get(k)).bt<=0)
				{
					readyqueue.remove(k);
				}
			}

			System.out.println("\nAfter Remove:");
			for(Process i : readyqueue){
				System.out.print(i.pid+" "+i.bt+" / ");
			}
		    System.out.print("After LONG:"+lpro.pid+" ");
			
			timer++;
			lpro.bt-=1;
			lpro.ct=timer;
			lpro.tat=lpro.ct-lpro.at;
			lpro.wt=lpro.tat-lpro.btt;
			
			
		}while(allDone()>0||readyqueue.size()>0);

	}
	static Process priority(Process lp,Process rp)
	{
		if(lp.pid>rp.pid)
		{
			return rp;
		}
		else
			return lp;
	}
static void display()
{
	System.out.println("Process id\t Arrival time\t Burst time \t Completion time \t Turn around time \t Waiting time\t");
	for(Process ob:ar)
	{
		System.out.println(ob.pid+"\t"+ob.at+"\t"+ob.btt+"\t"+ob.ct+"\t"+ob.tat+"\t"+ob.wt);

	}
}
}
/*
2132 2 0
2102 4 0
2453 8 0
*/

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
void main()
{
	int max=3;
	int i,j,temp1,temp2;
	int at=0;
	int pro[3]={2132,2102,2453};
	float awt=0,atat=0;
	int wt[max],tat[max],et[max];
	int bt[3]={2,4,8};
	printf("\n");
	printf("\n");
	printf("\t\t\tThe processes along with their ids are as follows:\n");
	for(i=0;i<max;i++)
	{
		printf(" \t P[%d]=[%d]\t",(i+1),pro[i]);
	}
	printf("\n");
	printf("\n");
	printf("\t\tThe burst time of the respective processes are as follows:\n");
for(i=0;i<max;i++)
{
	printf("\t %d\t\t",bt[i]);
}
printf("\n");
}

//bubble sort technique for lrtf

for(i=0;i<max;i++)
{
	for(j=0;j<max-i-1;j++)
	{
		if(bt[j+1]>bt[j])
		{
			temp1=bt[j];
			bt[j]=bt[j+1];
			bt[j+1]=temp1;
		}
		else if(bt[j+1]=bt[j])
		{
		
			temp2=pro[j];
			pro[j]=pro[j+1];
			pro[j+1]=temp2;
			
	}
	}
}
printf("\n");
printf("    process id \t    burst time \t    waiting time    turnaround time    ending time \n");

for(i=0;i<max;i++)
{
	wt[i]=0;
	tat[i]=0;
	at=0;
	for(j=0;j<i;j++)
	{
	wt[i]+=bt[j];	
	}
	
	tat[i]=wt[i]+bt[i];
	et[i]=tat[i]+at;
	awt+=wt[i];
	atat+=tat[i];
	printf("\t%d\t\t %d\t\t %d\t\t %d\t\t   %d\n",pro[i],bt[i],wt[i],tat[i],et[i]);
	
}

awt/=max;
atat/=max;
printf("\n");
printf("\n\t\t\t\t  Average waiting time is= %f\n",awt);
printf("\n\t\t\t\tAverage turn around time is= %f\n",atat);

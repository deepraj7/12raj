#include<iostream>

using namespace std;
int readyqueue[3][2];
	int maxx=3;
	int i,j,temp1,temp2;
	int pro[3][3]={{2132,2,2},{2102,4,4},{2453,8,8}};
	float awt=0,atat=0;
	int wt[3],tat[3],ct[3];
	int at[3]={0,0,0};
	int bt[3]={2,4,8};
	int bt1[3]={2,4,8};



int prioritySchedule(int l,int c){

    int result=0;
    if(pro[l][0]>pro[c][0]){
        result = c;
    }else{
        result = l;
    }
    return result;
}
int isnull(int R[3][2]){
    int isThere=0;
    for(int i=0;i<maxx;i++){
        if(R[i][1]>0){
            isThere =1;
        }
    }
    return isThere;
}
int isnullA(int R[3][3]){
    int isThere=0;
    for(int i=0;i<maxx;i++){
        if(R[i][1]>0){
            isThere =1;
        }
    }
    return isThere;
}
void display(){
for(int i=0;i<maxx;i++)
{

    cout<<endl;
    cout<<pro[i][0]<<" "<<pro[i][2]<<" "<<ct[i]<<" "<< tat[i]<<" "<<wt[i]<<endl;
}

}
int main()
{

	cout<<"\n";
	cout<<"\n";
	cout<<"\t\t\tThe processes along with their ids are as follows:\n";
	for(i=0;i<maxx;i++)
	{
		cout<<" \t P[]=[]\t"<<(i+1)<<pro[i][0];
	}
	cout<<"\n";
	cout<<"\n";
	cout<<"\t\tThe burst time of the respective processes are as follows:\n";
for(i=0;i<maxx;i++)
{
	cout<<"\t \t\t"<<bt[i];
}
cout<<"\n";

int cTALL=0;
int k=0;
do
{
    int counter=0;

    for(int i=0;i<maxx;i++)
	{

		if(at[i]==k && bt[i]>0)
		{
			readyqueue[counter++][0]=pro[i][0];
            readyqueue[counter++][1]=pro[i][1];

		}
	}
	int longprocess=0;

	for(int i=0;i<counter;i++)
    {
     if(bt[longprocess] < readyqueue[i][1] && readyqueue[i][1]>0){
        longprocess = i;
     }
     else if(bt[longprocess]== readyqueue[i][1] && readyqueue[i][1]>0){
        longprocess = prioritySchedule(longprocess,i);
     }
    }
    cTALL++;
    pro[longprocess][1]-=1;
    ct[longprocess] = cTALL;
    tat[longprocess] = ct[longprocess] - at[longprocess];
    wt[longprocess] = tat[longprocess] - bt1[longprocess];
    k++;

}while(isnull(readyqueue)==1|| isnullA(pro)==1);
display();
}


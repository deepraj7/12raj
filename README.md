
F:\4th sem study\projects>javac LRTFusingJAVA.java
Note: LRTFusingJAVA.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

F:\4th sem study\projects>java RunScheduler

Enter the number of processes 
3  


Pid AT BT
2132 0 2      
2102 2 4     
2453 4 8     
                                            Gaant Chart

P[2132]-> P[2132]-> P[2102]-> P[2102]-> P[2453]-> P[2453]-> P[2453]-> P[2453]-> P[2453]-> P[2453]-> P[2102]-> P[2453]-> P[2102]-> P[2453]-> P[2453]->


Process id  Arrival time    Burst time    Completion time   Turn around time   Waiting time
 2132           0               2               2                 2               0
 2102           2               4               13                11              7
 2453           4               8               14                10              2



                        Average turnaround time is:     7.6666665
                        Average waiting time is:        3.0

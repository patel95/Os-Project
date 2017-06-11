/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class SRTF {
    
       
    int processArray[];
        int arrivalArray[];
        int burstArray[];
        int priorityArray[];
        int tatArray[]=new int[2000];
        int wtArray[]=new int[2000];
    public SRTF(int[] processArray, int[] arrivalArray, int[] burstArray, int[] priorityArray) {
        
        this.processArray=processArray;
        this.arrivalArray=arrivalArray;
        this.burstArray=burstArray;
        this.priorityArray=priorityArray;
    }
    
    
    
     public void calculate()
    {
        int gantt[]=new int[2000];
        float sumTAT=0, sumWT=0;
        int x=0,i,j,n=0;
        int cpuSum=0,minBurst, minBurstPos=-1;
        String s="";
        int time=0;
        int burstArray2[]=new int[processArray.length];
        
        for(i=0;i<processArray.length;i++)
        {
            burstArray2[i]=burstArray[i];
        }
        
        
        
       
        while(true)
        {
            minBurst=999999;
            minBurstPos=-1;
            for(i=0;i<processArray.length;i++)
            {
                if(burstArray[i]>0 && arrivalArray[i]<=time)
                {
                    if(burstArray[i]<minBurst)
                    {
                        minBurst=burstArray[i];
                        minBurstPos=i;
                    }
                }
            }
            if(minBurstPos==-1)
            {
                gantt[time]=0;
                time++;
            }
            else
            {
                gantt[time]=processArray[minBurstPos];
                time++;
                burstArray[minBurstPos]--;
                if(burstArray[minBurstPos]==0)
                {
                    n++;
                    tatArray[minBurstPos]=time-arrivalArray[minBurstPos];
                    sumTAT+=tatArray[minBurstPos];
                    wtArray[minBurstPos]=tatArray[minBurstPos]-burstArray2[minBurstPos];
                     sumWT+=wtArray[minBurstPos];
                     cpuSum+=burstArray2[minBurstPos];
                }
            }
            if(n==processArray.length)
                break;
            
        }
       
        x=time;
        
        if(gantt[0]==0)
            s+="| Idle |";
        else
            s+="| P"+gantt[0]+" |";
        
        for (i = 1; i < x; i++) {
            if(gantt[i]!=gantt[i-1])
            {
                if(gantt[i]==0)
            s+=" Idle |";
        else
            s+=" P"+gantt[i]+" |";
            }
        }
        
        
        MyStaticClass.s=s;
        MyStaticClass.avgTAT=sumTAT/processArray.length;
        MyStaticClass.avgWT=sumWT/processArray.length;
        MyStaticClass.totTAT=x;
        MyStaticClass.totWT=(int)sumWT;
        MyStaticClass.cpuUtil=(Math.round(((double)cpuSum/x)*100.0*100.0))/100.0;
        MyStaticClass.throughPut=(Math.round(((double)processArray.length/x)*100.0))/100.0;
        //System.out.println(s);
        new GanttChart().setVisible(true);
    }
    
  
    
    
    
}

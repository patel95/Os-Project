/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class SJF {
    
     
    int processArray[];
        int arrivalArray[];
        int burstArray[];
        int priorityArray[];
        int tatArray[]=new int[2000];
        int wtArray[]=new int[2000];
    public SJF(int[] processArray, int[] arrivalArray, int[] burstArray, int[] priorityArray) {
        
        this.processArray=processArray;
        this.arrivalArray=arrivalArray;
        this.burstArray=burstArray;
        this.priorityArray=priorityArray;
    }
    
    
    
     public void calculate()
    {
        int gantt[]=new int[2000];
        float sumTAT=0, sumWT=0;
        int x=0,i,j;
        int cpuSum=0,min, minPos=-1, minArrival;
        String s="";
        int time=0;
        int n=processArray.length;
        while(n-->0)
        {
            min=999999;
            minPos=-1;
            minArrival=99999999;
            for(i=0;i<processArray.length;i++)
            {
                if(arrivalArray[i]<=time && burstArray[i]!=-1)
                {
                    if(burstArray[i]<min)
                    {
                        minPos=i;
                        min=burstArray[i];
                    }
                }
                if(burstArray[i]!=-1 && arrivalArray[i]<minArrival)
                {
                    minArrival=arrivalArray[i];
                }
            }
            if(minPos==-1)
            {
                for(j=time;j<minArrival;j++)
                {
                    gantt[j]=0;
                }
                time=minArrival;
                n++;
            }
            else
            {
                for(j=0;j<burstArray[minPos];j++)
                {
                    gantt[time+j]=processArray[minPos];
                }
            tatArray[minPos]=time+j-arrivalArray[minPos];
            sumTAT+=tatArray[minPos];
            wtArray[minPos]=tatArray[minPos]-burstArray[minPos];
            sumWT+=wtArray[minPos];
            cpuSum+=burstArray[minPos];
            
            
            time=time+burstArray[minPos];
            burstArray[minPos]=-1;
            
            }
            
        }
        
        x=time;
        for (i = 0; i < x; i++) {
            System.out.print(gantt[i]);
            
        }
        System.out.println(gantt);
        
        
        
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

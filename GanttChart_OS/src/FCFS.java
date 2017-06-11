/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class FCFS {
    
    
    String ts="0";
    int processArray[];
        int arrivalArray[];
        int burstArray[];
        int priorityArray[];
        int tatArray[]=new int[2000];
        int wtArray[]=new int[2000];
        
    public FCFS(int[] processArray, int[] arrivalArray, int[] burstArray, int[] priorityArray) {
        
        this.processArray=processArray;
        this.arrivalArray=arrivalArray;
        this.burstArray=burstArray;
        this.priorityArray=priorityArray;
    }
    
    public void calculate()
    {
        int gantt[]=new int[2000];
        float sumTAT=0, sumWT=0;
        int x=0;
        int cpuSum=0;
        for(int i=0;i<processArray.length;i++)
        {
            
            for(int j=x;j<arrivalArray[i];j++)
            {
                gantt[x]=0;
                x++;
            }
            
            for(int j=0;j<burstArray[i];j++)
            {
                gantt[x]=i+1;
                x++;
            }
            tatArray[i]=x-arrivalArray[i];
            sumTAT+=tatArray[i];
            wtArray[i]=tatArray[i]-burstArray[i];
            sumWT+=wtArray[i];
            cpuSum+=burstArray[i];
            ts=ts + " | " + x;
        }
        
        
        String s="";
        if(gantt[0]==0)
            s+="| Idle |";
        else
            s+="| P"+gantt[0]+" |";
        
        for (int i = 1; i < x; i++) {
            if(gantt[i]!=gantt[i-1])
            {
                if(gantt[i]==0)
            s+=" Idle |";
        else
            s+=" P"+gantt[i]+" |";
            }
        }
        
        System.out.println(processArray.length);
        MyStaticClass.s=s;
        MyStaticClass.timeString=ts;
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

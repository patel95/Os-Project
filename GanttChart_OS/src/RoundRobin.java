
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class RoundRobin {
    
    
    int processArray[];
        int arrivalArray[];
        int burstArray[];
        int priorityArray[];
        int tatArray[]=new int[2000];
        int wtArray[]=new int[2000];
        int tq;
    public RoundRobin(int[] processArray, int[] arrivalArray, int[] burstArray, int[] priorityArray, int tq) {
        
        this.processArray=processArray;
        this.arrivalArray=arrivalArray;
        this.burstArray=burstArray;
        this.priorityArray=priorityArray;
        this.tq=tq;
    }
    
    
     public void calculate()
    {
        int gantt[]=new int[2000];
        float sumTAT=0, sumWT=0;
        int x=0,i,j,n=0, popped=-1;
        int cpuSum=0,minArrival;
        String s="";
        int time=0, flag=0;
        int burstArray2[]=new int[processArray.length];
        int visited[]=new int[processArray.length];
        for(i=0;i<processArray.length;i++)
        {
            burstArray2[i]=burstArray[i];
            visited[i]=0;
        }
        
       Queue<Integer> queue = new LinkedList<Integer>();
      flag=0;
       while(true)
       {
           System.out.print(" "+time);
           //System.out.println(queue);
           minArrival=99999;
           for(i=0;i<processArray.length;i++)
           {
               if(arrivalArray[i]<=time && burstArray[i]>0 && visited[i]!=1)
               {
                   queue.add(processArray[i]);
                   visited[i]=1;
               }
               if(arrivalArray[i]<minArrival)
               {
                   minArrival=arrivalArray[i];
               }
           }
           
           if(flag==1)
           {
               queue.add(popped);
               flag=0;
           }
           
           if(queue.isEmpty())
           {
               for(i=time;i<minArrival;i++)
               {
                   gantt[i]=0;
               }
               time=minArrival;
           }
           else
           {
               popped=queue.remove();
               for(i=0;i<Math.min(tq, burstArray[popped-1]);i++)
               {
                   gantt[time+i]=popped;
               }
               time+=Math.min(tq, burstArray[popped-1]);
               burstArray[popped-1]-=Math.min(tq, burstArray[popped-1]);
               if(burstArray[popped-1]<=0)
               {
                   n++;                
                    tatArray[popped-1]=time-arrivalArray[popped-1];
                    sumTAT+=tatArray[popped-1];
                    wtArray[popped-1]=tatArray[popped-1]-burstArray2[popped-1];
                     sumWT+=wtArray[popped-1];
                     cpuSum+=burstArray2[popped-1];
               }
               else
               {
                   flag=1;      
               }
               
               
           }
           
           if(n==processArray.length)
               break;
           
       }
        
        x=time;
        
        for(i=0;i<x;i++)
        {
            System.out.print(gantt[i]);
        }
   
        
        
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

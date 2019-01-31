

import java.util.*;
import pk7.Hour;
import pk7.Minute;

class Second extends Minute{
int sec;
	Second(){}
	
	Second(int a,int b,int c){
	super(a,b);
	
	this.sec=c;

	if(this.sec>60){
	this.min++;
	this.sec=this.sec-60;
	}	

	if(this.min>60){
	this.hr++;
	this.min=this.min-60;
	}
}


void difference(Second start,Second end){
	if(start.sec > end.sec){
	--end.min;
	end.sec +=60;
	}
this.sec=end.sec - start.sec;
	if(start.min > end.min){
	--end.hr;
	end.min +=60;
	}
this.min=end.min - start.min;
this.hr=end.hr - start.hr;
}
}

class myexception extends Exception{
int detail;

   myexception(int v){
   detail=v;
  }

public String toString()
{
return ("hr:"+detail);
}
}


 class Time1{
public static void main(String args[])
{
	Second t3=new Second();
Scanner scan=new Scanner(System.in);

System.out.println("Enter start time:");
int a=scan.nextInt();
int b=scan.nextInt();
int c=scan.nextInt();
Second t1=new Second(a,b,c);
System.out.println(" Start time="+t1.hr+":"+t1.min+":"+t1.sec);

System.out.println("Enter end time:");
int a1=scan.nextInt();
int b1=scan.nextInt();
int c1=scan.nextInt();
Second t2=new Second(a1,b1,c1);
System.out.println(" End time="+t2.hr+":"+t2.min+":"+t2.sec);

try{

if(t2.hr<t1.hr){
throw new myexception(t2.hr-t1.hr);
}
else{
t3.difference(t1,t2);
System.out.println(" Time Difference="+t3.hr+":"+t3.min+":"+t3.sec);
}
}
catch(myexception e){
System.out.println("exception"+e);

}

}}
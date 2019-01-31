import java.util.*;
import pk2.*;
 




 class Bike extends Vehicle{
int wh;
 int ca;
      public  Bike(int w, int c){
          wh=w;
          ca=c;
         }

void wheels(){
System.out.println("No of wheels in bike: "+wh);}

void capacity(){
System.out.println("Capacity in bike: "+ca);}}


 abstract class Car extends Vehicle{
 int wh;
         Car(int w){
        wh=w;
         }

void wheels(){
System.out.println("Wheels in car: "+wh);}
}

class Safari extends Car{
int ca;
        Safari(int w, int c){
        super(w);
        ca=c;
       }

void capacity(){
System.out.println("Capacity in safari is: "+ca);}}

class Swift extends Car{
int ca; 
    Swift(int w, int c){
      super(w);
       ca=c;
       }

void capacity(){
System.out.println("Capacity in swift is: "+ca);}}

class myexception extends Exception{
int detail;
  myexception(int s){
  detail=s;
  }
public String toString(){
return ("error"+detail);
}
}


 class Types{
    public static void main(String args[]){

Scanner scan=new Scanner(System.in);

System.out.println("Enter wheels of bike:");
int a=scan.nextInt();
try{
if(a!=2){
throw new myexception(a);
}
else{


System.out.println("Eneter capacity of bike:");
int aa=scan.nextInt();


 Bike b=new Bike(a,aa);
b.wheels();
b.capacity();
}
}
catch(myexception e){
System.out.println("exception"+e);
}

Safari sa=new Safari(4, 8);
sa.wheels();
sa.capacity();

Swift s=new Swift(4, 6);
s.wheels();
s.capacity();
}}       

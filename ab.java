import java.util.*;


abstract class Animals{
  int eyes;
 Animals(int e){
    eyes=e;
     }

abstract void display();
}

abstract class Terrestial extends Animals{
   int legs;
Terrestial(int e,int l){
   super(e);
   legs=l;
}}

abstract class Aquatic extends Animals{
   int gills;
 Aquatic(int e, int g){
   super(e);
   gills=g;
}}

abstract class Aerial extends Animals{
   int wings;
  Aerial(int e, int w){
  super(e);
   wings=w;
}}

class lion extends Terrestial{
     lion(int e, int l){
  super(e,l);
}
void display(){
 System.out.println("Lion has eyes: "+eyes+" legs: "+legs);
   }
}

class fish extends Aquatic{
  fish(int e, int g){
  super(e,g);
}
void display(){
   System.out.println("fish has eyes: "+eyes+"  gills: "+gills);
}}

class sparrow extends Aerial{
   sparrow(int e, int w){
  super(e,w);}

void display(){
  System.out.println("Sparrow has eyes: "+eyes+" wings : "+wings);
}}

class myexception extends Exception{
int detail;
  myexception(int s){
  detail=s;
  }
public String toString(){
return ("error"+detail);
}
}




 class Organisms{
  public static void main(String args[]){
Scanner scan=new Scanner(System.in);

System.out.println("Enter eyes of lion:");
int a=scan.nextInt();
try{
if(a!=2){
throw new myexception(a);
}
else{
 lion li=new lion(a,4);
  li.display();
}
}
catch(myexception e){
System.out.println("exception"+e);
}

 fish fi=new fish(2,5);
 fi.display();

sparrow sp=new sparrow(2,2);
sp.display();
}}
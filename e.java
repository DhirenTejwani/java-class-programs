import java.util.*;
import pk3.Animals;
import pk3.Terrestial;
import pk3.Aquatic;
import pk3.Aerial;







class lion extends Terrestial{
     lion(int e, int l){
  super(e,l);
}
public void display(){
 System.out.println("Lion has eyes: "+eyes+" legs: "+legs);
   }
}

class fish extends Aquatic{
  fish(int e, int g){
  super(e,g);
}
public void display(){
   System.out.println("fish has eyes: "+eyes+"  gills: "+gills);
}}

class sparrow extends Aerial{
   sparrow(int e, int w){
  super(e,w);}

public void display(){
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
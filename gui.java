
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class gui extends Frame{
	public static void main(String args[]){
	    gui g1=new gui();
	    g1.addComponents();
	    g1.attachEvents();
	    }
Panel p1,p2,p3,p4, mainp;
Label b1,b2,b3, b4, g, q, l, e;
Label tah,ta1,ta2,ta3,ta4;
Label o,t;
final TextField t1, t2, t3, add, email,ot;
Button clear,b,exit;
Choice dd,m,y;

JRadioButton r1=new JRadioButton(" Male");    
JRadioButton r2=new JRadioButton(" Female");

DefaultTableModel d=new DefaultTableModel(4, 4);
JTable jt;

ButtonGroup bg=new ButtonGroup();     // include radios in this grp, so that only one radio can be selected
	
Checkbox l1,l2,l3;
	 
Second newframe;
String[] data=new String[13];


public gui(){
    this.setSize(435,835);
    setLayout(null);
    
    p1=new Panel();  // contains radio buttons
	p2=new Panel();  // contains table
    p3=new Panel();  // last panel
	p4=new Panel();  //title
	mainp=new Panel();
	
	
	jt = new JTable(d);
	jt.setSize(300, 300);
	
	mainp.setLayout(null);
	mainp.setBounds(15,115, 400, 280);
	mainp.setBackground(Color.yellow);
	
	p2.setLayout(null); 
    p2.setBounds(15, 396, 400, 150);
    p2.setBackground(Color.BLUE);
   
    p3.setBounds(15, 547, 400, 250);
    p3.setBackground(Color.red);
    p3.setLayout(null);
    
    p4.setBackground(Color.BLACK);
    p4.setBounds(15,50,400,60);
 //   p4.setLayout(null);
    
    t=new Label("STUDENT FORM");
    Font f=new Font("Serif",Font.BOLD,30);
    t.setFont(f);
    t.setForeground(Color.RED); 
    
    b1=new Label("Name");
    b2=new Label("Contact");
    b3=new Label("Date");
	b4=new Label("Address");
	g=new Label("Gender");
	l=new Label("Languages Known:");
	e=new Label("Email");
	o=new Label("OTHERS:");
	
	dd=new Choice();
	m=new Choice();
	y=new Choice();
	
	dd.add("date");
	m.add("month");
	y.add("year");
	for(int i=1;i<=31;i++){
	String z=Integer.toString(i);
	dd.add(z);}
	
	for(int i=1;i<=12;i++){
		String z=Integer.toString(i);
		m.add(z);	
	}
	
	for(int i=1980;i<=2010;i++){
		String z=Integer.toString(i);
		y.add(z);}
	
	tah=new Label("QUALIFICATION TABLE");
	ta1=new Label("University");
	ta2=new Label("Degree");
	ta3=new Label("Course");
	ta4=new Label("Grade");

    t1 = new TextField();
    t2 = new TextField();
    t3 = new TextField();
	add = new TextField();
	email = new TextField();
	ot=new TextField();
	
	l1=new Checkbox("HINDI");
	l2=new Checkbox("GUJARATI");
	l3=new Checkbox("ENGLISH");

	clear=new Button("Clear");
	b = new Button("Display");
    exit = new Button("Exit");

    
    //setBounds
//    t.setBounds(35, 15,200, 50);
    
    b1.setBounds(5, 5, 120, 20);
    t1.setBounds(130,5,250,20);
    b4.setBounds(5,30,120,20);
    add.setBounds(130, 30, 250, 20);
    b3.setBounds(5, 60, 120, 20);
    
    dd.setBounds(130,60,60,20);
    m.setBounds(200, 60, 80, 20);
    y.setBounds(290, 60, 60, 20);
   
    g.setBounds(5,90, 120, 30);
    p1.setBounds(130, 90, 250, 30);
    l.setBounds(5, 130, 120, 50);
    l1.setBounds(130, 145, 250, 20);
    l2.setBounds(130, 165, 250, 20);
    l3.setBounds(130, 185, 250, 20);
    b2.setBounds(5, 210, 120, 20);
    t2.setBounds(130, 210, 250, 20);
    e.setBounds(5, 240, 120, 20);
    email.setBounds(130, 240, 250, 20);
    
    tah.setBounds(5, 10, 200, 30);
    ta1.setBounds(10, 50, 70, 20);
    ta2.setBounds(85, 50, 70, 20);
    ta3.setBounds(160, 50, 70, 20);
    ta4.setBounds(235, 50, 70, 20);
    jt.setBounds(10, 75, 300, 63);
    
    o.setBounds(5, 10, 100, 20);
    ot.setBounds(10, 40, 300, 75);
    clear.setBounds(50, 170, 70, 30);
    b.setBounds(140,170,70,30);
    exit.setBounds(230, 170, 70, 30); 
 
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent){
      System.exit(0);}
    });



  //  q=new Label("Qualification");
    //qualificationChoice = new Choice();

    
    

	
    
}
public void addComponents(){
	bg.add(r1);bg.add(r2);

	add(p4);
	p4.add(t);
	
	add(mainp);
    mainp.add(b1);
    mainp.add(t1);
    mainp.add(b4);
    mainp.add(add);
    mainp.add(b3);
    mainp.add(dd);
    mainp.add(m);
    mainp.add(y);

	p1.add(r1);p1.add(r2);  
	mainp.add(g);
	mainp.add(p1);
	    
	mainp.add(b2);
	mainp.add(t2);
	
	mainp.add(l);
	mainp.add(l1);
	mainp.add(l2);
	mainp.add(l3);

    mainp.add(e);
    mainp.add(email);
   
    add(p2);
    p2.add(tah);
    p2.add(ta1);
    p2.add(ta2);
    p2.add(ta3);
    p2.add(ta4);
    p2.add(jt);
    
    add(p3);
    p3.add(o);
    p3.add(ot);
    p3.add(clear);
    p3.add(b);
    p3.add(exit); 
    
    
    
    this.setVisible(true);
    p1.setVisible(true);
    p2.setVisible(true);
	p4.setVisible(true);
    p3.setVisible(true);
    b1.setVisible(true);
    b2.setVisible(true);
    b3.setVisible(true);

    t1.setVisible(true);
    t2.setVisible(true);
    t3.setVisible(true);

}

public void attachEvents(){

clear.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){
	
	   t1.setText(" "); 	
	   t2.setText(" ");
	   t3.setText(" ");
	   add.setText(" ");
	   email.setText(" ");
	   ot.setText(" ");
	   
	   r1.setSelected(false);
	   r2.setSelected(false);
	    	
	   l1.setState(false);
	   l2.setState(false);
	   l3.setState(false);
	   
	    }
	    });

b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

  String name=t1.getText();
  data[0]="name: "+name;

  

   String addr=add.getText();
   data[3]="ADDRESS: "+addr;
         

  /*      String date = t3.getText();
        if(date.length() == 0){
          data[2]="Enter date";
        }

        String regex = "^[0-3]?[0-9]/[0-1]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        if(!matcher.matches()){
            data[2]="Invalid Date";
        }
        else
        {
        	data[2]="Date: "+date;
        }*/
  data[2]= "Date: " + dd.getSelectedItem();
  data[2]= data[2] +"/ " + m.getSelectedItem();
  data[2]= data[2] +"/ " + y.getSelectedItem();
    
if(r1.isSelected()){
		data[6]="Gender: MALE";}
if(r2.isSelected()){
		data[6]="Gender: FEMALE";}

String s = t2.getText();
String regexMobile = "^[0-9]";
        Pattern patternMobile = Pattern.compile(regexMobile);
        Matcher matcherMobile = patternMobile.matcher(s);



        if(s.length() == 0){
      data[1]="Enter Number";
        }
        else if(s.length() != 10){
      data[1]="Invalid Number";
        }else{
       data[1]="Contact:"+s;
        }		
	
data[7]="Languages Known:";
	if(l1.getState())data[7]=data[7]+" Hindi";
	if(l2.getState())data[7]=data[7]+" Gujarati";
	if(l3.getState())data[7]=data[7]+" English";

	// data[0]=t1.getText();
	// data[1]=t2.getText();
//	 data[2]=t3.getText();
	// data[3]=add.getText();
	 data[4]="email: " +email.getText();
	 data[5]="others: " +ot.getText();

	 data[8]=(String)jt.getValueAt(0, 0);
	 data[8]=data[8] +" " +(String)jt.getValueAt(0, 1);
	 data[8]=data[8] +" " +(String)jt.getValueAt(0, 2);
	 data[8]=data[8] +" " +(String)jt.getValueAt(0, 3);
	 	
	 
	 data[9]=(String)jt.getValueAt(1, 0);
	 data[9]=data[9] +" " +(String)jt.getValueAt(1, 1);
	 data[9]=data[9] +" " +(String)jt.getValueAt(1, 2);
	 data[9]=data[9] +" " +(String)jt.getValueAt(1, 3);
	 
    	newframe=new Second(data);
	    newframe.setVisible(true);
	    newframe.setSize(500, 300);
    }
});

	

exit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
          System.exit(0);
        }
    });
}



}			


class Second extends Frame{
List li=new List(1);
Label l;
	public Second(String[] data){
		 this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent windowEvent){
		      System.exit(0);}
		    });
	setLayout(null);
	add(li);
	li.add(data[0]);	//name
	li.add(data[3]);	//add	
	li.add(data[2]);	//date
	li.add(data[6]);	//gender
	li.add(data[7]);	//languages
	li.add(data[1]);	//number
	li.add(data[4]);	//email
	
	li.add(data[8]);
	li.add(data[9]);
	li.add(data[5]);	//other
	
	
	
	
	
	
	li.setBounds(50, 50, 300, 200);
	l=new Label("a");
	
	li.setVisible(true);
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//complete line 179;
package calculator;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
public class Calculator extends Frame implements ActionListener{
    Button f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20;Panel p1,p2;TextField Tf,Tf1;String s3="";
    public void fw(){
        String s[]={"ce","c","=","/","7","8","9","*","4","5","6","-","1","2","3","+","0","(",")","Dot"};
        f1=new Button(s[0]);f2=new Button(s[1]);f3=new Button(s[2]);f4=new Button(s[3]);f5=new Button(s[4]);f6=new Button(s[5]);
        f7=new Button(s[6]);f8=new Button(s[7]);f9=new Button(s[8]);f10=new Button(s[9]);f11=new Button(s[10]);f12=new Button(s[11]);
        f13=new Button(s[12]);f14=new Button(s[13]);f15=new Button(s[14]);f16=new Button(s[15]);f17=new Button(s[16]);f18=new Button(s[17]);
        f19=new Button(s[18]);f20=new Button(s[19]);
        
        p1=new Panel();p2=new Panel();
        p1.setLayout(new GridLayout(5,4));p2.setLayout(new GridLayout(2,1));
       f1.addActionListener(this);f2.addActionListener(this);f3.addActionListener(this);f4.addActionListener(this);
       f5.addActionListener(this);f6.addActionListener(this);f7.addActionListener(this);f8.addActionListener(this);
       f9.addActionListener(this);f10.addActionListener(this);f11.addActionListener(this);f12.addActionListener(this);
       f13.addActionListener(this);f14.addActionListener(this);f15.addActionListener(this);f16.addActionListener(this);
       f17.addActionListener(this);f18.addActionListener(this);f19.addActionListener(this);f20.addActionListener(this);
        p1.add(f1);p1.add(f2);p1.add(f3);p1.add(f4);p1.add(f5);p1.add(f6);p1.add(f7);p1.add(f8);p1.add(f9);p1.add(f10);p1.add(f11);
        p1.add(f12);p1.add(f13);p1.add(f14);p1.add(f15);p1.add(f16);p1.add(f17);p1.add(f18);p1.add(f19);p1.add(f20);
        Tf=new TextField(40);Tf1=new TextField(40);
        p2.add(Tf);p2.add(Tf1);
        //Tf.setBounds(5,5,100,100);
        
        //p1.setBounds(0,110,500,400);setLayout(null);
        //add(Tf);add(p1);
        add(p2,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
       // add(Tf1,BorderLayout.SOUTH);
        this.addWindowListener(new WindowAdapter(){
        public void WindowClosing(WindowEvent e){
            dispose();
          }
        });
        setSize(500,500);
        setVisible(true);
    }
public int power(String x){
    int i=0;
	if(x.equals("+")||x.equals("-")){
	    i=2;
	}
	if(x.equals("*")||x.equals("/")){
		i=3;
	}
        return i;
}
public Vector<String> BinfTopost(Vector<String>a){
	Stack<String> s=new Stack<>();
        Vector<String> b=new Vector<String>() ;
	//b.setSize(a.size());
	//vector<string> :: iterator i;
	for(int i=0;i<a.size();i++){
		String db=a.get(i);
		if(db.equals("(")){
		s.push(db);
		//continue;
	    }
		else if(db.equals("+")||db.equals("-")||db.equals("*")||db.equals("/")){
		   if(s.empty()){
		   	 s.push(db);
		    }
		  	else{
		  		
		  		String c=s.peek();
		  		if(power(c)<power(db)||db.equals("(")){   //strong sits on weak;
					  s.push(db);
				  }
				  else{
				  	while(power(c)>=power(db) && !c.equals("(")){
				  		b.add(c);
				  		s.pop();
				  		if(!s.empty())
				  		c=s.peek();
				  		else
				  		break;
					  }
					  s.push(db);
				  }
			  }
		}
		else if(db.equals(")")){
			String c=s.peek();
			while(!c.equals("(")){
				b.add(c);
				s.pop();
				c=s.peek();
			}
			s.pop();  //removes open bracket from stack;
		}
		else{
			b.add(db);
		}
	}
	while(!s.empty()){
		b.add(s.peek());
		s.pop();
	}
  return b;
}
double evalRPN(Vector<String>a){
  //Stack<double>s=new Stack<>();
  Stack<Double>s=new Stack<>();double r =0;
  //vector<String> :: iterator i;//ze=0;
 for(int i=0;i<a.size();i++){
 		String db=a.get(i);
                System.out.println(" db is "+db);
 		if(db.equals("+")||db.equals("-")||db.equals("*")||db.equals("/")){
 			double p2=s.peek();
 			s.pop();
 			double p1=s.peek();
 			s.pop();
 			if(db.equals("+"))
 				r=p1+p2;
			 else if(db.equals("-"))
			 	r=p1-p2;
			 else if(db.equals("*"))
			 	r=p1*p2;
			 else if(db.equals("/")){
			 	if(p2!=0){
			 		r=p1/p2;
				 }
				 else{
				 	//throw new Exception
		              // ze=1;
				 }
			 }
			 //cout<<"pushed value eval,pushed "<<r<<endl;
			 s.push(r);
		 }
		 else{
		 	//int i1 = stoi(db);
		 	//stringstream geek(db);
		 	//double i1=0;
		 	//geek >> i1;
                        double i1 = Double.parseDouble(db);
		 	s.push(i1);
		 }
   }
 double k=s.peek();
 return k;
}

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Calculator ob=new Calculator();
        ob.fw();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String s=Tf.getText();
     String s2=ae.getActionCommand();
     if(s2!="=" && s2!="ce" && s2!="c" && s2!="Dot"){
    s3=s;
    String s1=s+s2;
    Tf.setText(s1);
     }
     if(s2=="Dot"){
         s2=".";
       String s1=s+s2;
       Tf.setText(s1);   
     }
     if(s2=="ce"){
         Tf.setText("");Tf1.setText("");
     }
     if(s2=="c"){
         s=s.substring(0,s.length()-1);
        Tf.setText(s);
     }
     if(s2=="="){
         Vector<String>a=new Vector<>(); Vector<String>b=new Vector<>();
        //String s="((783+27)*51-2";  //len is 9 
        int i=0;int n=s.length();int f=0;
        while(i<n-1){
            String str=s.substring(i, i+1);
            int j=i+1;
            String str1=s.substring(j, j+1);
            if(!str.equals("+")&&!str.equals("-") && !str.equals("*") && !str.equals("/") &&!str.equals("(")&&!str.equals(")")){
            while(!str1.equals("+")&&!str1.equals("-") && !str1.equals("*") && !str1.equals("/") &&!str1.equals("(")&&!str1.equals(")")){
                str=str+str1;
                if(j==n-1){
                    f=1;
                    break;
                }
                j++;
                 str1=s.substring(j, j+1);
            }
            }
            i=j;
            System.out.println(str);
            a.add(str);
        }
        if(i==n-1 && f==0 ){
            String str=s.substring(i, i+1);
            System.out.println(str);
            a.add(str);
        }
        b=BinfTopost(a);
         System.out.println("vector b is "+b);
        double x=evalRPN(b);
         System.out.println(" ans is "+x);
         String ans=Double.toString(x);
         Tf1.setText(ans);
     }
    }

}

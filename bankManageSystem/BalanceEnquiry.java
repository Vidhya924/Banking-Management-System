package bankManageSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class BalanceEnquiry extends JFrame implements ActionListener {
	String pinNo;
	JButton Back,Exit;
	BalanceEnquiry(String pinNo){
	   this.pinNo=pinNo;
  	   setLayout(null);
  	   ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
  	   Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
  	   ImageIcon i3 = new ImageIcon(i2);
  	   JLabel image=new JLabel(i3);
  	   image.setBounds(0,0,900,900);
  	   add(image);
  	   //back
  	 Exit= new JButton("Exit");
	   Exit.setBounds(400,480,100,30);
	   Exit.setFont(new Font("Raleway",Font.BOLD,20));
	   Exit.setForeground(Color.WHITE);
	   Exit.setBackground(Color.BLACK);
	   Exit.addActionListener(this);
	   image.add(Exit);
	   //back
	   Back= new JButton("Back");
	   Back.setBounds(190,480,100,30);
	   Back.setFont(new Font("Raleway",Font.BOLD,20));
	   Back.setForeground(Color.WHITE);
	   Back.setBackground(Color.BLACK);
	   Back.addActionListener(this);
	   image.add(Back);
  	   //balance
	   Conn conn = new Conn();
	   int balance =0;
		 try {
			 ResultSet rs= conn.s.executeQuery("select * from bank where pin ='"+pinNo+"'");
		     while(rs.next()) {
		    	 if(rs.getString("type").equals("Deposit")){
		            balance +=Integer.parseInt(rs.getString("amount"));
		    	 }
		    	 else {
			          balance -=Integer.parseInt(rs.getString("amount"));
		    	 }
		     }
		 }
		     catch (Exception e) {
		    	 System.out.println(e);
		     }
		 JLabel BalEnq = new JLabel("BALANCE ENQUIRY");  
		 BalEnq.setBounds(220,300,400,35);
		 BalEnq.setFont(new Font("Raleway",Font.BOLD,25));
		 BalEnq.setForeground(Color.WHITE);
		 BalEnq.setBackground(Color.BLACK);
  	    image.add(BalEnq);
		 JLabel stmnt = new JLabel("Your Account Current Balance is ");  
		 stmnt.setBounds(170,350,400,35);
		 stmnt.setFont(new Font("Raleway",Font.BOLD,20));
		 stmnt.setForeground(Color.WHITE);
		 stmnt.setBackground(Color.BLACK);
  	    image.add(stmnt);
		 JLabel text = new JLabel("Rs"+ balance);  
		 text.setBounds(300,400,400,35);
  	    text.setFont(new Font("Raleway",Font.BOLD,20));
  	    text.setForeground(Color.WHITE);
  	    text.setBackground(Color.BLACK);
  	    image.add(text);
		//box
		setSize(900,900);
		setVisible(true);
		setLocation(200,0);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Back) {
			setVisible(false);
			new Transactions(pinNo).setVisible(true);
		}
		else if(ae.getSource()==Exit) {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("");

	}

}

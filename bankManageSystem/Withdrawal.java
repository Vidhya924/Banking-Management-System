package bankManageSystem;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Withdrawal extends JFrame implements ActionListener{
	JButton withDraw,back,exit;
	JTextField amount;
	String pinNo;
	Withdrawal(String pinNo){
	  this.pinNo=pinNo;
	  setLayout(null);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	  Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  JLabel image = new JLabel(i3);
	  image.setBounds(0,0,900,900);
	  add(image);
	  JLabel text = new JLabel("Select Withdrawal amount");
	  text.setForeground(Color.WHITE);
	  text.setBackground(Color.BLACK);
	  text.setFont(new Font("System",Font.BOLD,16));
	  text.setBounds(200,350,400,45);
	  image.add(text);
	  amount= new JTextField();
	  amount.setFont(new Font("Raleway",Font.BOLD,16));
	  amount.setForeground(Color.WHITE);
	  amount.setBackground(Color.BLACK);
	  amount.setBounds(190,400,300,35);
	  image.add(amount);
	  //deposit
	  withDraw = new JButton("WithDrawl");
	  withDraw.setFont(new Font("Raleway",Font.BOLD,16));
	  withDraw.setForeground(Color.WHITE);
	  withDraw.setBackground(Color.BLACK);
	  withDraw.setBounds(190,450,150,30);
	  withDraw.addActionListener(this);
	  image.add(withDraw);
	  //back
	  back = new JButton("Back");
	  back.setFont(new Font("Raleway",Font.BOLD,16));
	  back.setForeground(Color.WHITE);
	  back.setBackground(Color.BLACK);
	  back.setBounds(380,450,100,30);
	  back.addActionListener(this);
	  image.add(back);
	  //exit
	  exit = new JButton("Exit");
	  exit.setFont(new Font("Raleway",Font.BOLD,16));
	  exit.setForeground(Color.WHITE);
	  exit.setBackground(Color.BLACK);
	  exit.setBounds(300,500,100,30);
	  exit.addActionListener(this);
	  image.add(exit);
	  //TERMINAL
	  setSize(900,900);
	  setVisible(true);
	  setLocation(300,0);
  }
  public void actionPerformed(ActionEvent ae) {
	  try {
		  String number = amount.getText();
		  Date date = new Date();
		  
		  if(ae.getSource()==withDraw) {
			  if(amount.getText().equals("")) {
				  JOptionPane.showMessageDialog(null,"Please enter the Amount  you want to Withdraw");
			  }
			  else {
				 Conn conn = new Conn();
		     	 conn.s.executeUpdate("insert into bank values('"+pinNo+"', '"+date+"', 'WithDraw', '"+number+"')");
				  JOptionPane.showMessageDialog(null,"Rs"+number+"\n Amount Successfully Credited");
                  setVisible(false);
                  new Transactions(pinNo).setVisible(true);
			  }
		  }
			  else if(ae.getSource()==back) {
				  setVisible(false);
				  new Transactions(pinNo).setVisible(true);
			  }
		  }
	  catch(Exception e){
		  System.out.println(e);
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new Withdrawal("");
	}

}

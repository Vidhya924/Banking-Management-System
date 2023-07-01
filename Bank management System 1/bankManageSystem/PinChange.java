package bankManageSystem;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
	String pinNo;
	JPasswordField pin,Repin;
	JButton Change,Back,Exit;
       PinChange(String pinNo){
    	   this.pinNo=pinNo;
    	   setLayout(null);
    	   ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    	   Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    	   ImageIcon i3 = new ImageIcon(i2);
    	   JLabel image=new JLabel(i3);
    	   image.setBounds(0,0,900,900);
    	   add(image);
    	   JLabel  change = new JLabel("Change your PIN");
    	   change.setBounds(250,300,400,45);
    	   change.setFont(new Font("Raleway",Font.BOLD,20));
    	   change.setForeground(Color.WHITE);
    	   change.setBackground(Color.BLACK);
    	   image.add(change);
    	   
    	   JLabel newPin = new JLabel("New Pin");
    	   newPin.setBounds(200,380,400,30);
    	   newPin.setFont(new Font("Raleway",Font.BOLD,20));
    	   newPin.setForeground(Color.WHITE);
    	   newPin.setBackground(Color.BLACK);
    	   image.add(newPin);
    	   //box
    	   pin = new JPasswordField();
    	   pin.setBounds(400,380,100,30);
    	   pin.setFont(new Font("Raleway",Font.BOLD,20));
    	   pin.setForeground(Color.WHITE);
    	   pin.setBackground(Color.BLACK);
    	   image.add(pin);
    	   JLabel RePin = new JLabel("Re enter the PIN");
    	   RePin.setBounds(200,420,400,30);
    	   RePin.setFont(new Font("Raleway",Font.BOLD,20));
    	   RePin.setForeground(Color.WHITE);
    	   RePin.setBackground(Color.BLACK);
    	   image.add(RePin);
    	   //box
    	   Repin = new JPasswordField();
    	   Repin.setBounds(400,420,100,30);
    	   Repin.setFont(new Font("Raleway",Font.BOLD,20));
    	   Repin.setForeground(Color.WHITE);
    	   Repin.setBackground(Color.BLACK);
    	   image.add(Repin);
    	   Change= new JButton("Change");
    	   Change.setBounds(190,480,100,30);
    	   Change.setFont(new Font("Raleway",Font.BOLD,20));
    	   Change.setForeground(Color.WHITE);
    	   Change.setBackground(Color.BLACK);
    	   Change.addActionListener(this);
    	   image.add(Change);
    	   //back
    	   Back= new JButton("Back");
    	   Back.setBounds(400,480,100,30);
    	   Back.setFont(new Font("Raleway",Font.BOLD,20));
    	   Back.setForeground(Color.WHITE);
    	   Back.setBackground(Color.BLACK);
    	   Back.addActionListener(this);
    	   image.add(Back);
    	   //exit
    	   Exit= new JButton("Exit");
    	   Exit.setBounds(300,520,100,30);
    	   Exit.setFont(new Font("Raleway",Font.BOLD,20));
    	   Exit.setForeground(Color.WHITE);
    	   Exit.setBackground(Color.BLACK);
    	   Exit.addActionListener(this);
    	   image.add(Exit);
    	   //terminal    	   
    	   setSize(900,900);
    	   setLocation(200,0);
    	   setVisible(true);
       }
       public void actionPerformed(ActionEvent ae) {
    		  String epin = pin.getText();
    		  String rpin = Repin.getText();
    	   if(ae.getSource()==Back) {
    		   setVisible(false);
    		   new Transactions(pinNo).setVisible(true);
    	   }
    	   else if(ae.getSource()==Exit) {
    		   System.exit(0);
    	   }
    	   try { 
    		   if(ae.getSource()==Change) {
    		   if(!epin.equals(rpin)) {
    			   JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
    			   return;
    		   }
    		   if(epin.equals("") || rpin.equals("")) {
    			   JOptionPane.showMessageDialog(null, "Please enter the new PIN");
    			   return;
    		   }
    		   else if(epin.equals(rpin)) {
    		   Conn conn = new Conn();
    		   String query1= "update bank  set pin ='"+rpin+"' where pin ='"+pinNo+"' ";
    		   String query2= "update login  set pinNo ='"+rpin+"' where pinNo ='"+pinNo+"' ";
    		   String query3= "update signupthree  set pinNo ='"+rpin+"' where pinNo ='"+pinNo+"' ";
    		   conn.s.executeUpdate(query1);
    		   conn.s.executeUpdate(query2);
    		   conn.s.executeUpdate(query3);
    		   JOptionPane.showMessageDialog(null, "PIN Successfully Changed");
    	       setVisible(false);
    	       new Transactions(rpin).setVisible(true);
    		   }
    	 }
     }
    	  catch(Exception e) {
    		  System.out.println(e);
    	  }
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("");

	}

}

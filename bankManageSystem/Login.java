package bankManageSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.management.loading.ClassLoaderRepository;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	      JButton login, signup, clear;
	      JTextField cardTextField;
	      JPasswordField pinTextField;
       Login(){
    	   setTitle("JAVA ATM SYSTEM");
    	   //cornered the image
    	   setLayout(null);
    	   ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    	   Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    	   ImageIcon i3= new ImageIcon(i2);
    	   JLabel label = new JLabel(i3);
    	   label.setBounds(70,10,100,100);
    	   add(label);
    	   JLabel text = new JLabel("Welcome to ATM");
    	   text.setFont(new Font("Osward",Font.BOLD,38));
    	   text.setBounds(200, 40, 400, 40);
    	   add(text);
    	   //SECOND TEXT
    	   JLabel cardNo = new JLabel("Card No:");
    	   cardNo.setFont(new Font("Osward",Font.BOLD,25));
    	   cardNo.setBounds(120, 150, 150, 30);
    	   add(cardNo);
    	   //textfields=box
    	   cardTextField = new JTextField();
    	   cardTextField.setBounds(300, 150, 230, 30);
    	   cardTextField.setFont(new Font("Arial",Font.BOLD,14));
    	   add(cardTextField);
    	   //THIRD TEXT
    	   JLabel pinNo = new JLabel("ATM PIN:");
    	   pinNo.setFont(new Font("Osward",Font.BOLD,25));
    	   pinNo.setBounds(120, 220, 250, 30);
    	   add(pinNo);
    	   pinTextField = new JPasswordField();
    	   pinTextField.setBounds(300, 220, 230, 30);
    	   pinTextField.setFont(new Font("Arial",Font.BOLD,14));
    	   add(pinTextField);
    	   //BUTTONS
    	   login = new JButton("SIGN IN");
    	   login.setBounds(300, 300, 100, 30);
    	   login.setBackground(Color.BLACK);
    	   login.setForeground(Color.WHITE);
    	   //button functions
    	   login.addActionListener(this);
    	   add(login);
    	   //SECOND BUTTON
    	   clear = new JButton("CLEAR");
    	   clear.setBounds(430, 300, 100, 30);
    	   clear.setBackground(Color.BLACK);
    	   clear.setForeground(Color.WHITE);
    	   clear.addActionListener(this);
    	   add(clear);
    	   //THIRD BUTTON
    	   signup = new JButton("SIGN UP");
    	   signup.setBounds(300, 350,230, 30);
    	   signup.setBackground(Color.BLACK);
    	   signup.setForeground(Color.WHITE);
    	   signup.addActionListener(this);
    	   add(signup);
    	   //OUTLINE BOX
    	   getContentPane().setBackground(Color.WHITE);
    	   setSize(800,480);
    	   setVisible(true);
    	   setLocation(350,200);
       }
       public void actionPerformed(ActionEvent ae) {
    	   if(ae.getSource()== clear) {
    		   cardTextField.setText("");
    		   pinTextField.setText("");
    	   }
    	   else if(ae.getSource()== login) {
    		   Conn conn = new Conn();
    		   String cardNo = cardTextField.getText();
    		   String pinNo=pinTextField.getText();
    		   String query ="select * from login where cardNo= '"+cardNo+ "' and pinNo='"+pinNo+"' ";
    		   try {
    			   ResultSet rs = conn.s.executeQuery(query);
    			   if(rs.next()) {
    				   setVisible(false);
    				   new Transactions(pinNo).setVisible(true);
    			   }
    			   else {
    				   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin!");
    			   }
    		   }
    		   catch(Exception e) {
    			  System.out.println(e);
    		   }
    		   if(cardNo.length()!=16 || pinNo.length()!=4) {
    			   JOptionPane.showMessageDialog(null, "Invalid Information!!");
    		   }
    		   for(int i=0;i<cardNo.length();i++) {
    			   if(cardNo.charAt(i)<9) {
        			   JOptionPane.showMessageDialog(null, "Invalid Card Number!");
        			   break;
    			   }
    		   }
    		   for(int i=0;i<pinNo.length();i++) {
    			   if(pinNo.charAt(i)<'1' &&pinNo.charAt(i)>'9' ) {
        			   JOptionPane.showMessageDialog(null, "Invalid PIN!"); 
        			   break;
    			   }
    		   }
    	   }
    	   else if(ae.getSource()== signup) {
    		   setVisible(false);
    		   new SignupOne().setVisible(true);
    	   }
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Login();
	}

}

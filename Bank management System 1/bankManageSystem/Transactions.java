package bankManageSystem;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {
	JLabel text,welcome;
	JButton deposit,CashWith,FastCash,MiniState,PinChange,BalEnqry,Exit;
	String pinNo;
	Transactions(String pinNo){
		this.pinNo=pinNo;
		setLayout(null);
		setTitle("Transactions");
		 ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
  	   Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
  	   ImageIcon i3= new ImageIcon(i2);
  	   JLabel label = new JLabel(i3);
  	   label.setBounds(0,0,900,900);
  	   add(label);
  	 welcome = new JLabel("Welcome!");
   	welcome.setBounds(300,300,700,35);
  	welcome.setForeground(Color.WHITE);
  	welcome.setFont(new Font("System", Font.BOLD,20));
	    //add text into image
	    label.add(welcome);
  	    text = new JLabel("Please Select your Transaction");
  	    text.setBounds(200,350,700,35);
  	    text.setForeground(Color.WHITE);
  	    text.setFont(new Font("System", Font.BOLD,20));
  	    //add text into image
  	    label.add(text);
  	   //deposit
  	   deposit = new JButton("Deposit");
  	   deposit.setBounds(170,415,150,30);
  	   deposit.setBackground(Color.BLACK);
  	   deposit.setForeground(Color.WHITE);
  	   deposit.addActionListener(this);
  	   label.add(deposit);
//  	   WITHDRAWL
  	   CashWith = new JButton("Cash Withdrawal");
    	CashWith.setBounds(370,415,150,30);
    	CashWith.setBackground(Color.BLACK);
    	CashWith.setForeground(Color.WHITE);
    	CashWith.addActionListener(this);
 	   label.add(CashWith);
//	   FAST CASH JButton deposit,CashWith,FastCash,MiniState,PinChange,BalEnqry,Exit;
 	  FastCash = new JButton("Back");
 	  FastCash.setBounds(370,485,150,30);
 	  FastCash.setBackground(Color.BLACK);
 	  FastCash.setForeground(Color.WHITE);
 	 FastCash.addActionListener(this);
  	   label.add(FastCash);
//  	MINI STATEMENT
  	 MiniState = new JButton("Mini Statement");
  	MiniState.setBounds(170,450,150,30);
  	MiniState.setBackground(Color.BLACK);
  	MiniState.setForeground(Color.WHITE);
    MiniState.addActionListener(this);
	label.add(MiniState);
//	   PIN CHANGE
	   PinChange = new JButton("Pin Change");
	   PinChange.setBounds(170,485,150,30);
	   PinChange.setBackground(Color.BLACK);
	   PinChange.setForeground(Color.WHITE);
	   PinChange.addActionListener(this);
  	   label.add(PinChange);
//  	BAlance
  	     BalEnqry = new JButton("Balance Enquiry");
    	 BalEnqry.setBounds(370,450,150,30);
    	 BalEnqry.setBackground(Color.BLACK);
    	 BalEnqry.setForeground(Color.WHITE);
    	 BalEnqry.addActionListener(this);
	   label.add(BalEnqry);
//  	   Exit
	   Exit = new JButton("Exit");
	   Exit.setBounds(300,520,100,30);
	   Exit.setBackground(Color.BLACK);
	   Exit.setForeground(Color.WHITE);
	   Exit.addActionListener(this);
  	   label.add(Exit);
		setSize(900,900);
		//setUndecorated(true);
		setLocation(300,0);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		//JButton deposit,CashWith,FastCash,MiniState,PinChange,BalEnqry,Exit;
		if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNo).setVisible(true);
		}
		else if(ae.getSource()==CashWith) {
			setVisible(false);
			new Withdrawal(pinNo).setVisible(true);
		}
		else if(ae.getSource()==FastCash) {
			setVisible(false);
			new Login().setVisible(true);
		}
		else if(ae.getSource()==MiniState) {
			setVisible(false);
			new MiniStatement(pinNo).setVisible(true);
		}
		else if(ae.getSource()==PinChange) {
			setVisible(false);
			new PinChange(pinNo).setVisible(true);
		}
		else if(ae.getSource()==BalEnqry) {
			setVisible(false);
			new BalanceEnquiry(pinNo).setVisible(true);
		}
		else if(ae.getSource()==Exit) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("");

	}

}

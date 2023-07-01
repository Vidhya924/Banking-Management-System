package bankManageSystem;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class SignupThree extends JFrame implements ActionListener {
	JRadioButton savAcc,fisDep,currAcc,reDep;
	JCheckBox ATMcard,InterBank,MobBank,EmailAlert,CheqBook,EStat,agreeStat;
	JButton cancel,submit;
	String formno;
	SignupThree(String formno){
		this.formno = formno;
		setLayout(null);
		JLabel AccDet = new JLabel("3. Account Details");
		AccDet.setFont(new Font("Raleway",Font.BOLD,25));
		AccDet.setBounds(250,0,400,40);
		add(AccDet);
		//Account type
		JLabel Acctype = new JLabel("Account Type:");
		Acctype.setFont(new Font("Raleway",Font.BOLD,20));
		Acctype.setBounds(100,50,400,40);
		add(Acctype);
		//Savings Acc
		savAcc = new JRadioButton("Savings Account");
		savAcc.setFont(new Font("Raleway",Font.BOLD,15));
		savAcc.setBounds(100,100,200,40);
		savAcc.setBackground(Color.WHITE);
		add(savAcc);
		//Fixed Deposit Account
		fisDep = new JRadioButton("Fixed Deposit Account");
		fisDep.setFont(new Font("Raleway",Font.BOLD,15));
		fisDep.setBounds(350,100,500,40);
		fisDep.setBackground(Color.WHITE);
		add(fisDep);
		//Current Account
		currAcc = new JRadioButton("Current Account");
		currAcc.setFont(new Font("Raleway",Font.BOLD,15));
		currAcc.setBounds(100,150,200,40);
		currAcc.setBackground(Color.WHITE);
		add(currAcc);
		//Recurring Deposit Account
		reDep = new JRadioButton("Recurring Deposit Account");
		reDep.setFont(new Font("Raleway",Font.BOLD,15));
		reDep.setBounds(350,150,500,40);
		reDep.setBackground(Color.WHITE);
		add(reDep);
		ButtonGroup grpButton = new ButtonGroup();
		grpButton.add(savAcc);
		grpButton.add(fisDep);
		grpButton.add(currAcc);
		grpButton.add(reDep);
		JLabel cardNo = new JLabel("Card Number: ");
		cardNo.setFont(new Font("Raleway",Font.BOLD,20));
		cardNo.setBounds(100,200,400,40);
		add(cardNo);
		JLabel xxCardNo = new JLabel("XXXX-XXXX-XXXX-4184");
		xxCardNo.setFont(new Font("Raleway",Font.BOLD,18));
		xxCardNo.setBounds(380,200,800,40);
		add(xxCardNo);
		JLabel cardDesc = new JLabel("(Yours 16 - digit card numbers)");
		cardDesc.setFont(new Font("Raleway",Font.ITALIC,15));
		cardDesc.setBounds(100,250,400,40);
		add(cardDesc);
		//CardNoDetails
		JLabel xxDetails = new JLabel("(It would appear on ATM, cheque books.)");
		xxDetails.setFont(new Font("Raleway",Font.ITALIC,15));
		xxDetails.setBounds(380,250,400,40);
		add(xxDetails);
		//Pin no
		JLabel pinNo = new JLabel("PIN: ");
		pinNo.setFont(new Font("Raleway",Font.BOLD,20));
		pinNo.setBounds(100,300,400,40);
		add(pinNo);
		JLabel xxCardpsw = new JLabel("XXXX");
		xxCardpsw.setFont(new Font("Raleway",Font.BOLD,18));
		xxCardpsw.setBounds(380,300,800,40);
		add(xxCardpsw);
		JLabel digPSW = new JLabel("(Your 4 digit password)");
		digPSW.setFont(new Font("Raleway",Font.ITALIC,15));
		digPSW.setBounds(100,350,400,40);
		add(digPSW);
		//Services
		JLabel servReq= new JLabel("Services Required:");
		servReq.setFont(new Font("Raleway",Font.BOLD,20));
		servReq.setBounds(100,400,400,40);
		add(servReq);
        //JCheckBox ATMcard,InterBank,MobBank,EmailAlert,CheqBook,EStat;
		 ATMcard = new JCheckBox("ATM Card");
		ATMcard.setFont(new Font("Raleway",Font.BOLD,15));
		ATMcard.setBounds(100,450,200,40);
		ATMcard.setBackground(Color.WHITE);
		add(ATMcard);
		 InterBank = new JCheckBox("Internet Banking");
		InterBank.setFont(new Font("Raleway",Font.BOLD,15));
		InterBank.setBounds(350,450,400,40);
		InterBank.setBackground(Color.WHITE);
		add(InterBank);
		 MobBank = new JCheckBox("Mobile Banking");
		MobBank.setFont(new Font("Raleway",Font.BOLD,15));
		MobBank.setBounds(100,500,200,40);
		MobBank.setBackground(Color.WHITE);
		add(MobBank);
		 EmailAlert = new JCheckBox("Email Alerts");
		EmailAlert.setFont(new Font("Raleway",Font.BOLD,15));
		EmailAlert.setBounds(350,500,400,40);
		EmailAlert.setBackground(Color.WHITE);
		add(EmailAlert);
		 CheqBook = new JCheckBox("Cheque Books");
		CheqBook.setFont(new Font("Raleway",Font.BOLD,15));
		CheqBook.setBounds(100,550,200,40);
		CheqBook.setBackground(Color.WHITE);
		add(CheqBook);
		 EStat = new JCheckBox("E-Statements");
		EStat.setFont(new Font("Raleway",Font.BOLD,15));
		EStat.setBounds(350,550,400,40);
		EStat.setBackground(Color.WHITE);
		add(EStat);
		agreeStat = new JCheckBox("I here-by declare all the informations provided are true to my knowledge");
		agreeStat.setFont(new Font("Raleway",Font.ITALIC,15));
		agreeStat.setBounds(100,600,600,40);
		agreeStat.setBackground(Color.WHITE);
		add(agreeStat);
		// Cancel ansd subit button
		 cancel = new JButton("Cancel");
		 cancel.setFont(new Font("Raleway",Font.BOLD,15));
		 cancel.setBounds(100,650,100,40);
		 cancel.setBackground(Color.WHITE);
		 cancel.addActionListener(this);
		add(cancel);
	     submit = new JButton("Submit");
		submit.setFont(new Font("Raleway",Font.BOLD,15));
		submit.setBounds(550,650,100,40);
		submit.setBackground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		//Terminal
		setSize(850,820);
		setLocation(350,0);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
//		JRadioButton savAcc,fisDep,currAcc,reDep;
//		JCheckBox ATMcard,InterBank,MobBank,EmailAlert,CheqBook,EStat,agreeStat;
//		JButton cancel,submit;
		String Acctype=null;
		if(ae.getSource()==submit) {
			if(savAcc.isSelected()) {
				Acctype= "Saving Account";
			}
		    if(fisDep.isSelected()) {
				Acctype= "Fixed Deposit Account";
			}
		    if(currAcc.isSelected()) {
				Acctype= "Current Account";
			}
		     if(reDep.isSelected()) {
				Acctype= "Recurring Deposit Account";
			}
			Random random = new Random();
			long first7 = (random.nextLong() % 90000000L) + 5040936000000000L;
	        String cardno = "" + Math.abs(first7);
	        
	        long first3 = (random.nextLong() % 9000L) + 1000L;
	        String pin = "" + Math.abs(first3);
	        String facility = "";
	        if(ATMcard.isSelected()) {
	        	facility=facility+" ATM card";
	        }
	        else  if(InterBank.isSelected()) {
	        	facility=facility + " Internet Banking";
	        }
	        else  if(MobBank.isSelected()) {
	        	facility=facility+ " Mobile Banking";
	        }
	        else  if(EmailAlert.isSelected()) {
	        	facility=facility+ " Email Alerts";
	        }
	        else  if(CheqBook.isSelected()) {
	        	facility=facility+" Cheque Books";
	        }
	        else  if(EStat.isSelected()) {
	        	facility=facility+"E-Statements";
	        }
	        try {
	        	if(Acctype.equals("")) {
	        		JOptionPane.showMessageDialog(null, " Account type is required");
	        	}
	        	else {
	        		Conn conn = new Conn();
	        		String query1 = "insert into signupThree values('"+formno+"','"+Acctype+"','"+cardno+"','"+pin+"','"+facility+"')";
	        	    conn.s.executeUpdate(query1);
	        	    String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
	        	    conn.s.executeUpdate(query2);
	        	    JOptionPane.showMessageDialog(null, "Card Number" +cardno+"\n"+ "PIN:" +pin);
	        	     setVisible(false);
	        	     new Deposit(pin).setVisible(true);
	        	}
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
	        
		}
		else if(ae.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupThree("");

	}

}

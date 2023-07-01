package bankManageSystem;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class MiniStatement extends JFrame {
	String pinNo;
	MiniStatement(String pinNo){
		this.pinNo=pinNo;
		setLayout(null);
		setTitle("MINI STATEMENT");
		JLabel text = new JLabel();
		add(text);
		//bank heading
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150,20,200,20);
		bank.setFont(new Font("Raleway",Font.BOLD,25));
		add(bank);
		//cardNo
		JLabel cardNo = new JLabel();
		cardNo.setBounds(20,80,300,20);
		add(cardNo);
		//mini
		JLabel mini =new JLabel();
		mini.setBounds(20,140,300,200);
		add(mini);
		//balance
		JLabel Balance = new JLabel();
		Balance.setBounds(20,400,300,20);
		add(Balance);
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from login where pinNo = '"+pinNo+"'");
			while(rs.next()) {
				cardNo.setText("Card Number:" + rs.getString("cardNo").substring(0,4)+"XXXXXXXX" +rs.getString("cardNo").substring(12));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			Conn conn= new Conn();
			int bal =0;
			ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+pinNo+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+ "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				 if(rs.getString("type").equals("Deposit")){
			            bal +=Integer.parseInt(rs.getString("amount"));
			    	 }
			    	 else {
				          bal -=Integer.parseInt(rs.getString("amount"));
			    	 }
			}
			Balance.setText("Your Current Account Balance is Rs "+bal);
		}
		catch(Exception e){
			System.out.println(e);
		}
		setSize(500,500);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MiniStatement("");
	}
	

}

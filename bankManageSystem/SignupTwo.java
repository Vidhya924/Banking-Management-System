package bankManageSystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
	JButton next;
	JTextField panTextField,aadharTextField;
	JRadioButton yes,no,yes1,no2;
	JComboBox relBox,catBox,incRange,educBoc,specBox,occBox;
	String formno;
	SignupTwo(String formno){
		//this.formno=formno;
		setLayout(null);
		setTitle("BACKGROUND DETAILS");
		Random ran = new Random();
		long random = Math.abs(ran.nextLong() % 9000L) + 1000L;	
//		JLabel formno= new JLabel("ATM FROM NO. "+ random);
//		formno.setFont(new Font("Raleway", Font.BOLD, 38));
//		formno.setBounds(140, 20, 600,40);
//		add(formno); 
		//second label
		JLabel personDetails= new JLabel("1.BACKGROUND DETAILS ");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 27));
		personDetails.setBounds(240, 60, 400,40);
		add(personDetails);
		//Religion
		JLabel religion= new JLabel("Religion: ");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140,100,30);
		add(religion);
		String[] religionVal = {"Hindu","Muslim","Christian","Other"};
		 relBox = new JComboBox(religionVal);
		relBox.setBounds(300, 140, 400, 30);
		relBox.setBackground(Color.WHITE);
		add(relBox);		
		//Category
		JLabel category= new JLabel("Category: ");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190,600,30);
		add(category);
		String[] catVal= {"ST","SC","BC","MBC"};
		 catBox=new JComboBox(catVal);
		catBox.setBounds(300, 190, 400, 30);
		catBox.setBackground(Color.WHITE);
		add(catBox);		
		//Income
		JLabel income= new JLabel("Income: ");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240,700,30);
		add(income);
		String[] Range = {"NULL",">25K",">50L",">=1L",">=2L","I AM RICH"};
		 incRange =new JComboBox(Range);
		incRange.setBounds(300, 240, 400, 30);
		incRange.setBackground(Color.WHITE);
		add(incRange);
		//education
		JLabel education= new JLabel("Education: ");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 290,200,30);
		add(education);
		String[] educ = {"Graduate","UG","PG","DOCTRATE","Non Graduate"};
		 educBoc =new JComboBox(educ);
		educBoc.setBounds(300, 290, 400, 30);
		educBoc.setBackground(Color.WHITE);
		add(educBoc);
		//Specification
		JLabel specification= new JLabel("Specification: ");
		specification.setFont(new Font("Raleway", Font.BOLD, 20));
		specification.setBounds(100, 340,600,30);
		add(specification);
		String[] spec = {"Arts & Science","Engineering","Medical","Agri","Research"};
		 specBox =new JComboBox(spec);
		specBox.setBounds(300, 340, 400, 30);
		specBox.setBackground(Color.WHITE);
		add(specBox);
		//Occupation
		JLabel occupation= new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390,200,30);
		add(occupation);
		String[] occ = {"Self employment","Business","Goverment Employee","Salarized","Retired","Student","Other"};
	    occBox =new JComboBox(occ);
		occBox.setBounds(300, 390, 400, 30);
		occBox.setBackground(Color.WHITE);
		add(occBox);
		//PAN
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);
		//box finished
		JLabel PAN= new JLabel("PAN No: ");
		PAN.setFont(new Font("Raleway", Font.BOLD, 20));
		PAN.setBounds(100, 440,100,30);
		add(PAN);
		//Aadhar
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);
		//box finished
		JLabel Aadhar= new JLabel("Aadhar No: ");
		Aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		Aadhar.setBounds(100, 490,200,30);
		add(Aadhar);
		//Senior
		JLabel senior= new JLabel("Senior citizen: ");
		senior.setFont(new Font("Raleway", Font.BOLD, 20));
		senior.setBounds(100, 540,200,30);
		add(senior);
	    yes = new JRadioButton("Yes");
		yes.setBounds(300, 540, 100, 30);
		yes.setBackground(Color.WHITE);
		add(yes);
	    no = new JRadioButton("No");
		no.setBounds(450,540,200,30);
		no.setBackground(Color.WHITE);
		add(no);
		ButtonGroup seniorGrp = new ButtonGroup();
		seniorGrp.add(yes);
		seniorGrp.add(no);
		//Existing Acc
		JLabel existAcc= new JLabel("Existing Account : ");
		existAcc.setFont(new Font("Raleway", Font.BOLD, 20));
		existAcc.setBounds(100, 590,200,30);
		add(existAcc);
		//RadioButton
	    yes1 = new JRadioButton("Yes");
		yes1.setBounds(300, 590, 100, 30);
		yes1.setBackground(Color.WHITE);
		add(yes1);
	    no2 = new JRadioButton("No");
		no2.setBounds(450,590,200,30);
		no2.setBackground(Color.WHITE);
		add(no2);
		ButtonGroup ExAcc = new ButtonGroup();
		ExAcc.add(yes1);
		ExAcc.add(no2);
		
		//NextButton
		next= new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 620, 80, 30);
		next.addActionListener(this);
		add(next);
		//TextBox
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
	//	JComboBox relBox,catBox,incRange,educBoc,specBox,occBox;

		String religion = (String)relBox.getSelectedItem();// long string value
		String category =  (String)catBox.getSelectedItem();
		String income = (String)incRange.getSelectedItem();
		String education = (String)educBoc.getSelectedItem();
		String specification =(String)specBox.getSelectedItem();
		String Occupation =(String)occBox.getSelectedItem();
		String PAN_No = panTextField.getText();
		String Aadhar_No = aadharTextField.getText();
        String senCitizen = null;
		if(yes.isSelected()) {
			senCitizen="Senior Citizen";
		}
		else if(no.isSelected()) {
			senCitizen="Not a Senior Citizen";
		}
		String ExAccc =  null;
		if(yes1.isSelected()) {
			ExAccc="Already have a Account";
		}
		else if(no2.isSelected()) {
			ExAccc="New Account" ;
		}
		try {
			if(PAN_No.length()!=10) {
				JOptionPane.showMessageDialog(null, "Invalid PAN number");
			//	new SignupTwo(formno).setVisible(true);
			}
			else if(Aadhar_No.length()!=12) {
				JOptionPane.showMessageDialog(null, "Invalid Aadhar number");
				//new SignupTwo(formno).setVisible(true);
			}
			
			else if(relBox.equals("")) {
				JOptionPane.showMessageDialog(null, " Details  required ");
			}
			else {
				Conn c= new Conn();
				//create table signupTwo(FormNo varchar(35),Religion varchar(35), Category varchar(35),Income varchar(35),Education varchar(35),Specification varchar(35),PAN_No varchar(35), AadharNo varchar(35), SeniorCitizen varchar(35),ExistionAccount varchar(35));
				String query = "Insert into signupTwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+specification+"','"+Occupation+"','"+PAN_No+"',' "+Aadhar_No+"', '"+senCitizen+"', '"+ExAccc+"')";
                c.s.executeUpdate(query);
                setVisible(false);                
			   new SignupThree(formno).setVisible(true);
			}
		}
		catch (Exception e) {
			System.out.println(e);;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupTwo("");
      // new SignupTwo("").setVisible(true);
       
	}

}

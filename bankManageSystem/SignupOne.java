package bankManageSystem;
import javax.swing.*;
import java.util.regex.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {
	long random;
	JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
	JButton next;
	JRadioButton male,female;
	JDateChooser dateChooser;
	String formno;
	SignupOne(){
		setLayout(null);
		this.formno =  formno;
		
		Random ran = new Random();
		long random = Math.abs(ran.nextLong() % 9000L) + 1000L;
		formno=String.valueOf(random);
		JLabel formNo= new JLabel("APPLICATION FROM NO. "+ random);
		formNo.setFont(new Font("Raleway", Font.BOLD, 38));
		formNo.setBounds(140, 20, 600,40);
		add(formNo);
		//second label
		JLabel personDetails= new JLabel("1.PERSONAL DETAILS "+ random);
		personDetails.setFont(new Font("Raleway", Font.BOLD, 27));
		personDetails.setBounds(240, 60, 400,40);
		add(personDetails);
		//Name
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		//boxfinished
		JLabel name= new JLabel("Name: ");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140,100,30);
		add(name);
		//Father Name
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		//box finished
		JLabel fname= new JLabel("Father name: ");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190,600,30);
		add(fname);
		//Date of birth
		JLabel dob= new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240,700,30);
		add(dob);
		//calendar box
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		//Gender
		JLabel gender= new JLabel("Gender: ");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290,100,30);
		add(gender);
		// radio button
		male = new JRadioButton("Male");
		male .setBounds(300,290,100,30);
		male.setBackground(Color.WHITE);
		add(male);
		female = new JRadioButton("Female");
		female .setBounds(450,290,200,30);
		add(female);
		female.setBackground(Color.WHITE);
		ButtonGroup gendergroup = new ButtonGroup();
		// let to select only one button
		gendergroup.add(male);
		gendergroup.add(female);
		//EmailAddress
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		//box finished
		JLabel email= new JLabel("Email Address: ");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340,600,30);
		add(email);
		//Address
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 390, 400, 30);
		add(addressTextField);
		//box finished
		JLabel address= new JLabel("Address: ");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 390,200,30);
		add(address);
		//City
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 440, 400, 30);
		add(cityTextField);
		//box finished
		JLabel city= new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 440,100,30);
		add(city);
		//State
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 490, 400, 30);
		add(stateTextField);
		//box finished
		JLabel state= new JLabel("State: ");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 490,100,30);
		add(state);
		//Pincode
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 540, 400, 30);
		add(pincodeTextField);
		//box finished
		JLabel pincode= new JLabel("Pincode: ");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 540,100,30);
		add(pincode);
		//NextButton
		next= new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 600, 80, 30);
		next.addActionListener(this);
		add(next);
		//TextBox
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String regex="^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		String formno = " "+ random;// long string value
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="Female";
		}
		String email = emailTextField.getText();
		Matcher matcher = pattern.matcher(email);
		String address = addressTextField.getText();
		String city =  cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		String regex2="[0-9]+";
		Pattern p= Pattern.compile(regex2);
		Matcher m =p.matcher(pincode);
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, " Name is Required ");
			}
			else if(! matcher.matches()) {
				JOptionPane.showMessageDialog(null, "Invalid Email Address");
			}
			else if(pincode.length()!=6 || (!m.matches())) {
				JOptionPane.showMessageDialog(null, "Invalid Pin Code");
			}
			else {
				Conn c= new Conn();
				String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"',' "+city+"', '"+pincode+"', '"+state+"')";
                c.s.executeUpdate(query);
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
				//  String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";                
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new SignupOne();
       
	}

}

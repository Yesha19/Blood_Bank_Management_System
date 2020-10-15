package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME OF QUESTIONS ASKED BY DOCTOR ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//DONE BUTTON ACTION LISTENER 
class DAL implements ActionListener
{
	Main1 mp;
	CheckDonor cd;
	
	public DAL(CheckDonor cd,Main1 mp)
	{
		this.cd= cd;
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String s1 = null,s2 = null,s3 = null,s4 = null,s5 = null;
		int temp = 1;
		
		if(cd.txtbg.getText().equals("A+") || cd.txtbg.getText().equals("A-") || cd.txtbg.getText().equals("B-") || 
				cd.txtbg.getText().equals("B+") || cd.txtbg.getText().equals("AB+") || cd.txtbg.getText().equals("AB-") || 
				cd.txtbg.getText().equals("O+") || cd.txtbg.getText().equals("O-") )
		{
			s1 = cd.txtbg.getText();
			if((cd.txt1.getText().equals("yes") || cd.txt1.getText().equals("no")) &&
				(cd.txt2.getText().equals("yes") || cd.txt2.getText().equals("no")) &&
				(cd.txt3.getText().equals("yes") || cd.txt3.getText().equals("no")) && 
				(cd.txt4.getText().equals("yes") || cd.txt4.getText().equals("no")))
			{
				s2 = cd.txt1.getText();
				s3 = cd.txt2.getText();
				s4 = cd.txt3.getText();
				s5 = cd.txt4.getText();
			}
			else
			{
				temp = 0;
				cd.lbl5.setVisible(false);
				cd.lbl5.setText("FIELDS SHOULD CONTAIN EITHER yes OR no");
				cd.lbl5.setVisible(true);
			}
		}
		else
		{
			temp = 0;
			cd.lbl5.setVisible(false);
			cd.lbl5.setText("WRONG BLOOD GROUP FORMAT");
			cd.lbl5.setVisible(true);
		}
			
		
		
		if(temp == 1)
		{
			//checking whether all text fields are filled or not
			if((s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")) == false)
			{
				//checking the answers to questions (whether the donor is fit or not)
				if(s2.equals("yes") && s3.equals("yes") && s4.equals("no") && s5.equals("no"))
				{
					try 
					{
						//calling inputDonor function of Donor class
						mp.Don.inputDonor(cd.name, cd.age, cd.sex, cd.contactno, cd.city, cd.id, cd.pass, s1);
						
						//calling file function of BloodBottles class
						mp.fo.file(s1);
						
						System.out.println("SUCCESSFULLY DONATED!");
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("BLOOD CANNOT BE DONNATED!");
				}
				
				cd.setVisible(false);
			}
			else
			{
				cd.lbl5.setVisible(true);
			}
		}
		
	}
	
}

//FRAME FOR QUESTIONS ASKED BY DOCTOR TO CHECK WHETHER THE DONOR IS FIT TO DONATE THE BLOOD OR NOT

public class CheckDonor extends JFrame
{
	JLabel lblbg = new JLabel("Enter your Blood group:");
	JTextField txtbg = new JTextField(10);
	
	JLabel lblheader = new JLabel("QUESTIONS: (yes/no)");
	JLabel lbl1 = new JLabel("Are you above 18 years?");
	JLabel lbl2 = new JLabel("Are you above 45kgs weight?");
	JLabel lbl3 = new JLabel("Do you have any severe disease?");
	JLabel lbl4 = new JLabel("Are you diabetic?");
	JLabel lbl5 = new JLabel("FIELDS CAN'T BE EMPTY");
	
	JTextField txt1 = new JTextField(10);
	JTextField txt2 = new JTextField(10);
	JTextField txt3 = new JTextField(10);
	JTextField txt4 = new JTextField(10);
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	JButton btndone = new JButton("DONE");
	Main1 mp;
	String name,sex,city,id,pass;
	int age;
	long contactno;
	
	public CheckDonor(Main1 mp,String name , int age , String sex , long contactno , String city , String id , String pass)
	{
		this.mp = mp;
		this.age = age;
		this.contactno = contactno;
		this.id = id;
		this.pass = pass;
		this.city = city;
		this.sex = sex;
		this.name = name;
		this.setTitle("DONOR DETAILS");
		
		this.setBounds(0,0,500,500);
		btndone.addActionListener(new DAL(this,mp));
		
		lbl1.setBounds(10, 10, 50, 20);
		lbl2.setBounds(10, 10, 50, 20);
		lbl3.setBounds(10, 10, 50, 20);
		lbl4.setBounds(10, 10, 50, 20);
		
		txt1.setBounds(10,10,40,20);
		
		p2.setLayout(new GridLayout(1,2,10,10));
		p2.add(btndone);
		p2.add(lbl5);
		
		lbl5.setVisible(false);
		
		p1.setLayout(new GridLayout(1,2,10,10));
		p1.add(lblbg);
		p1.add(txtbg);
		
		p3.setLayout(new GridLayout(5,2,70,70));
		p3.add(lblheader);
		p3.add(new JLabel(""));
		p3.add(lbl1);
		p3.add(txt1);
		p3.add(lbl2);
		p3.add(txt2);
		p3.add(lbl3);
		p3.add(txt3);
		p3.add(lbl4);
		p3.add(txt4);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p3,BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
	}
	
	
}

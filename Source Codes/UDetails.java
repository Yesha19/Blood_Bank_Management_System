package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME FOR USER REGISTRATION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//RESISTER BUTTON ACTION LISTENER

class regAL implements ActionListener
{
	Main1 mp;
	UDetails up;
	
	public regAL(UDetails up,Main1 mp)
	{
		this.mp = mp;
		this.up = up;
	}
	
	public boolean testCase(String str)
	{
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(c >= 65 && c <= 90) 
			{
				return false;
			}
		}
		//str.charAt(index)
		return true;
	}
	
	public boolean testCase1(String str)
	{
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(!( (c >= 65 && c <= 90) || (c >= 97 && c <=122) )) 
			{
				return false;
			}
		}
		
		return true;
	}
	 
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String name = null,id = null,pass = null,sex = null,city = null;
		long contact = 0;
		int age = 0,temp=0;
		up.txtfield.setText("");
		//getting the attributes from the fields 
		
		
		if(!up.tname.getText().equals("") && testCase(up.tname.getText()))
		{
			name = up.tname.getText();
			if(!up.tage.getText().equals("") && (up.tage.getText().matches("[0-9]+")))
			{
				age = Integer.valueOf(up.tage.getText());
				if(!up.tsex.getText().equals("") && ( up.tsex.getText().charAt(0)=='M' || up.tsex.getText().charAt(0)=='F') && (up.tsex.getText().length() == 1))
				{
					sex = up.tsex.getText();
					if(!up.tcity.getText().equals("") && testCase(up.tcity.getText()))
					{
						city = up.tcity.getText();
						if(!up.tcontact.getText().equals("") && (up.tcontact.getText().matches("[0-9]+")) && (up.tcontact.getText().length() == 10))
						{
							contact = Long.valueOf(up.tcontact.getText());
							try {
								if(!up.tid.getText().equals("") && (mp.u.userIdCheck(up.tid.getText()) == 0) )
								{
									id = up.tid.getText();
									if(!up.tpass.getText().equals(""))
									{
										pass = up.tpass.getText();
									}
									else
									{
										temp = 1;
										up.txtfield.setVisible(false);
										up.txtfield.setText("WRONG PASSWORD FORMAT");
										up.txtfield.setVisible(true);
									}
								}
								else
								{
									temp = 1;
									up.txtfield.setVisible(false);
									
									if(up.tid.getText().equals(""))
										up.txtfield.setText("WRONG USER FORMAT");
									else
										up.txtfield.setText("USERNAME ALREADY EXISTS");
									
									up.txtfield.setVisible(true);
								}
							} 
							
							catch (IOException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
						}
						else
						{
							temp = 1;
							up.txtfield.setVisible(false);
							up.txtfield.setText("WRONG CONTACT FORMAT");
							up.txtfield.setVisible(true);
						}
					}
					else
					{
						temp = 1;
						up.txtfield.setVisible(false);
						up.txtfield.setText("WRONG CITY FORMAT");
						up.txtfield.setVisible(true);
					}
					
				}
				else
				{
					temp = 1;
					up.txtfield.setVisible(false);
					up.txtfield.setText("WRONG GENDER FORMAT");
					up.txtfield.setVisible(true);
				}
			}
			else
			{
				temp = 1;
				up.txtfield.setVisible(false);
				up.txtfield.setText("WRONG AGE FORMAT");
				up.txtfield.setVisible(true);
				
			}
		}
		else
		{
			temp = 1;
			up.txtfield.setVisible(false);
			up.txtfield.setText("WRONG NAME FORMAT");
			up.txtfield.setVisible(true);
		}
		
		try
		{
			if(temp == 0)
			{
				//calling the inputUser function of class User
						
				mp.u.inputUser(name,age,sex,contact,city,id,pass);
				up.txtfield.setVisible(false);
				up.setVisible(false);
			}
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
}


//FRAME OF REGISTRATION OF USER

public class UDetails extends JFrame
{
	JLabel lname,lage,lcity,lid,lpass,lcontact,lsex,txtfield;
	JTextField tname,tage,tsex,tcontact,tpass,tid,tcity;
	JPanel p1,p2;
	JButton btnRegister;
	Main1 mp;
	
	public UDetails(Main1 mp)
	{
		this.mp = mp;
		this.setTitle("USER REGISTRATION");
		p1 = new JPanel();
		p2 = new JPanel();
		this.setBounds(0,0,500,500);
		lname = new JLabel("        Name : (lower case alphabets)");
		lage = new JLabel("        Age :");
		lsex = new JLabel("        Gender : (M/F)");
		lcontact = new JLabel("        Contact :");
		lcity = new JLabel("        City :");
		lid = new JLabel("        User ID:");
		lpass = new JLabel("        Password :");
		txtfield = new JLabel("TEXTS FIELDS CAN'T BE EMPTY, FILL DETAILS PROPERLY!");
		btnRegister = new JButton("REGISTER");
		p1.setBounds(0,0,100,200);
		p1.setLayout(new GridLayout(0,2,5,20));
		
		txtfield.setVisible(false);
		
		tname = new JTextField();
		tage = new JTextField();
		tsex = new JTextField();
		tcontact = new JTextField();
		tcity = new JTextField();
		tid = new JTextField();
		tpass = new JTextField();
		
		btnRegister.addActionListener(new regAL(this,mp));
		
		lname.setBounds(10, 10, 50, 20);
		lage.setBounds(10, 10, 50, 20);
		lcity.setBounds(10, 10, 50, 20);
		lsex.setBounds(10, 10, 50, 20);
		lcontact.setBounds(10, 10, 50, 20);
		lid.setBounds(10, 10, 50, 20);
		lpass.setBounds(10, 10, 50, 20);
		
		tname.setBounds(100, 100, 10, 10);
		tage.setBounds(100, 100, 10, 10);
		tcity.setBounds(100, 100, 10, 10);
		tsex.setBounds(100, 100, 10, 10);
		tcontact.setBounds(100, 100, 10, 10);
		tid.setBounds(100, 100, 10, 10);
		tpass.setBounds(100, 100, 10, 10);
		
		p1.add(lname,BorderLayout.CENTER);
		p1.add(tname,BorderLayout.CENTER);
		p1.add(lage,BorderLayout.CENTER);
		p1.add(tage,BorderLayout.CENTER);
		p1.add(lsex,BorderLayout.CENTER);
		p1.add(tsex,BorderLayout.CENTER);
		p1.add(lcontact,BorderLayout.CENTER);
		p1.add(tcontact,BorderLayout.CENTER);
		p1.add(lcity,BorderLayout.CENTER);
		p1.add(tcity,BorderLayout.CENTER);
		p1.add(lid,BorderLayout.CENTER);
		p1.add(tid,BorderLayout.CENTER);
		p1.add(lpass,BorderLayout.CENTER);
		p1.add(tpass,BorderLayout.CENTER);
		
		p2.add(btnRegister);
		p2.add(txtfield);
		
		
		this.add(p1,BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);

		
	}
	
}

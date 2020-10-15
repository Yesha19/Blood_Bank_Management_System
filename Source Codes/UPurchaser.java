package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME OF REQUESTING A BLOODGROUP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//DONE ACTION LISTENER
class doneAL implements ActionListener
{
	Main1 mp;
	UPurchaser up;
	
	public doneAL(UPurchaser up, Main1 mp)
	{
		this.mp = mp;
		this.up = up;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		String s1,s2;
		
		//taking the purpose of purchasing (s1) and wanted blood group (s2) from the User
		
		s1 = up.txt1.getText();
		s2 = up.txt2.getText();
		
		if(s2.equals("A+") || s2.equals("A-") || s2.equals("B+") || s2.equals("B-") || s2.equals("AB+") || s2.equals("AB-") || s2.equals("O+") || s2.equals("O-"))
		{
			try 
			{
				//If blood group bottle is available then calling inputPurchasers of Purchaser class and calling file1 function of BloodBottles class
				//and calling receipt class constructor
				
				if(mp.fo.checkBottle(s2) >= 1)
				{
					mp.Pur.inputPurchasers(up.name, up.age, up.sex, up.contactno, up.city, up.id, up.pass,s1,s2);
					mp.fo.file1(s2);
					Receipt r1 = new Receipt(s2);
					r1.setVisible(true);
					System.out.println("SUCCESSFULLY PURCHASED!");
					up.setVisible(false);
				}
				else
				{
					//if the bottle is not available, then file that request by calling fileRequest function of Request class
					up.lblw.setVisible(true);
					up.txtw.setVisible(true);
					String k = up.txtw.getText();
					
					String[] re = new String[10];
					re = k.split("/");
					
					
					if(re[0].matches("[0-9]+") && re[1].matches("[0-9]+") && re[2].matches("[0-9]+") && re[0].length()==2 && re[1].length()==2 
							&& re[2].length()==4 && check(re)==1 && (k.charAt(2)=='/') && (k.charAt(5)=='/'))
					{
						LocalDate y0 = java.time.LocalDate.now();
						
						String h1 = y0.toString();
						String[] k2 = new String[10];
						
						k2 = h1.split("-");
						LocalDate date4 = LocalDate.of(Integer.valueOf(re[2]),Integer.valueOf(re[1]),Integer.valueOf(re[0]));
				        LocalDate date2 = LocalDate.of(Integer.valueOf(k2[0]),Integer.valueOf(k2[1]),Integer.valueOf(k2[2]));  //cd
				        
				        if(date4.isAfter(date2) || date4.isEqual(date2))
				        {
							mp.r.fileRequest(up.id, s2 , k);
							System.out.println("SUFFICIENT BOTTLES NOT AVAILABLE!");
				        }
				        
				        else
						{
							up.lbl3.setVisible(false);
							up.lbl3.setText("WRONG DATE FORMAT");
							up.lbl3.setVisible(true);
						}
					}
					else
					{
						up.lbl3.setVisible(false);
						up.lbl3.setText("WRONG DATE FORMAT");
						up.lbl3.setVisible(true);
					}
				}
			}
			
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else
		{
			up.lbl3.setVisible(true);
		}
	}
	
	public int check(String[] re)
	{
		int r1 = Integer.valueOf(re[0]);
		int r2 = Integer.valueOf(re[1]);
		int r3 = Integer.valueOf(re[2]);
		
		if(r2==2)
		{
			if(r1<=28 && r1>=1)
				return 1;
			else
				return 0;
		}
		else if( r2==8 || (r2%12)%2==1 )
		{
			if(r1>=1 && r1<=31)
				return 1;
			else
				return 0;
		}
		else
		{
			if(r1>=1 && r1<=30)
				return 1;
			else
				return 0;
		}
		
	}
}


//FRAME OF REQUESTING WANTED BLOOD GROUP

public class UPurchaser extends JFrame
{
	JLabel lbl1 = new JLabel("Purpose of Purchasing:");
	JTextField txt1 = new JTextField(10);
	JLabel lbl2 = new JLabel("Wanted Blood Group : (A+ / A- / B+ / B- / AB+ / AB- / O+ / O- )");
	JTextField txt2 = new JTextField(10);
	JLabel lblw = new JLabel("DATE (till you want the blood group) : (dd/mm/yyyy)");
	JTextField txtw = new JTextField(50);
	JLabel lbl3 = new JLabel("WRONG BLOOD GROUP");
	
	JButton done = new JButton("DONE");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Main1 mp;
	String name,sex,city,id,pass;
	int age;
	long contactno;
	
	public UPurchaser(Main1 mp , String name , int age , String sex , long contactno , String city , String id , String pass )
	{
		this.setBounds(0,0,500,500);
		this.mp = mp;
		this.setTitle("REQUESTER DETAILS");
		
		this.age = age;
		this.contactno = contactno;
		this.id = id;
		this.pass = pass;
		this.city = city;
		this.sex = sex;
		this.name = name;
		
		done.addActionListener(new doneAL(this,mp));
		
		p1.setLayout(new GridLayout(0,2,30,30));
		p1.add(lbl1);
		p1.add(txt1);
		p1.add(lblw);
		p1.add(txtw);
		p1.add(lbl2);
		p1.add(txt2);
		
		//lblw.setVisible(false);
		//txtw.setVisible(false);
		
		p2.add(done);
		p2.add(lbl3);
		
		lbl3.setVisible(false);
		
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		
		this.pack();
	}
}

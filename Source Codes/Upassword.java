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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME TO CHANGE THE PASSWORD  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`


public class Upassword extends JFrame
{
	JLabel lbl1 = new JLabel("Enter new password:");
	//JTextField txt1 = new JTextField(10);
	JPasswordField txt1 = new JPasswordField(20);
	JButton done = new JButton("DONE");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	String id,pass;
	Main1 mp;
	
	public Upassword(Main1 mp,String id,String pass)
	{
		this.setBounds(0,0,500,200);
		txt1.setEchoChar('#');
		this.setTitle("UPDATE PASSWORD");
		this.id = id;
		this.pass = pass;
		this.mp = mp;
		lbl1.setSize(10,10);
		txt1.setSize(10,10);
		
		done.addActionListener(new PAL1(this,mp,id,pass));
		
		p1.setLayout(new GridLayout(1,2,100,100));
		p1.add(lbl1);
		p1.add(txt1);
		p2.add(done);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.SOUTH);
	}
}

//DONE ACTION LISTENER 

class PAL1 implements ActionListener
{
	Main1 mp;
	Upassword ups;
	String id;
	String pass;
	
	public PAL1(Upassword ups, Main1 mp,String id,String pass)
	{
		this.mp = mp;
		this.ups = ups;
		this.id = id;
		this.pass = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String s1 = new String(ups.txt1.getPassword());
		
		if(!s1.equals(""))
		{
			try 
			{
				//calling changePassword method of Admin class
				
				mp.a.changePassword(id,pass,s1,mp.u,mp.Don,mp.Pur);
				ups.setVisible(false);
			} 
			
			catch (NumberFormatException | ClassNotFoundException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("FIELDS CANNOT BE EMPTY!");
		}
	}
	
}


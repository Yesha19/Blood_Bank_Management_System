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

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  FRAME OF CONTACT UPDATION  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Ucontact extends JFrame
{
	JLabel lbl1 = new JLabel("Enter new contact:");
	JTextField txt1 = new JTextField(10);
	JButton done = new JButton("DONE");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	String id,pass;
	Main1 mp;
	
	public Ucontact(Main1 mp,String id,String pass)
	{
		this.setBounds(0,0,500,200);
		this.setTitle("UPDATE CONTACT");
		this.id = id;
		this.pass = pass;
		this.mp = mp;
		
		done.addActionListener(new DAL1(this,mp,id,pass));
		
		p1.setLayout(new GridLayout(1,2,10,10));
		p1.add(lbl1);
		p1.add(txt1);
		p2.add(done);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.SOUTH);
	}
	
}


//DONE ACTION LISTENER

class DAL1 implements ActionListener
{
	Main1 mp;
	Ucontact uc;
	String id;
	String pass;
	
	public DAL1(Ucontact uc, Main1 mp,String id,String pass)
	{
		this.mp = mp;
		this.uc = uc;
		this.id = id;
		this.pass = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String s1 = uc.txt1.getText();
		
		if(!s1.equals("") && (s1.matches("[0-9]+")) && (s1.length() == 10))
		{
			try 
			{
				mp.a.changeContact(id,pass,Long.valueOf(s1),mp.u,mp.Don,mp.Pur);
			} 
			
			catch (NumberFormatException | ClassNotFoundException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("WRONG FORMAT OF CONTACT");
		}
	}
	
}
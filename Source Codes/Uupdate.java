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

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`  UPDATE RECORDS OF USER ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
/*
 * Functionality performed : Frame to update the records of the user like updating the current password or contact number
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//CONTACT BUTTON ACTION LISTENER

class CAL implements ActionListener
{
	Uupdate up;
	Main1 mp;
	
	public CAL(Uupdate up,Main1 mp)
	{
		this.up= up;
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		Ucontact uc = new Ucontact(mp,up.id,up.pass);
		uc.setVisible(true);
	}
	
}


//PASSWORD BUTTON ACTION LISTENER

class PAL implements ActionListener
{
	Uupdate up;
	Main1 mp;
	
	public PAL(Uupdate up,Main1 mp)
	{
		this.up= up;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		Upassword ups = new Upassword(mp,up.id,up.pass);
		ups.setVisible(true);
		
	}
}


//BACK BUTTON ACTION LISTENER

class BAL1 implements ActionListener
{
	Uupdate up;
	
	public BAL1(Uupdate up)
	{
		this.up = up;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		up.setVisible(false);
	}
}



//FRAME OF UPDATION OF DETAILS OF USER

public class Uupdate extends JFrame
{
	JLabel lbl1 = new JLabel("What do you want to change?");
	JButton btnc = new JButton("CONTACT");
	JButton btnp = new JButton("PASSWORD");
	JButton btnback = new JButton("BACK");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Main1 mp;
	String id,pass;
			
	public Uupdate(Main1 mp,String id,String pass)	
	{
		this.setBounds(0, 0, 500, 200);
		this.setTitle("UPDATION WINDOW");
		this.mp = mp;
		this.id = id;
		this.pass = pass;
		
		btnc.addActionListener(new CAL(this,mp));
		btnp.addActionListener(new PAL(this,mp));
		btnback.addActionListener(new BAL1(this));
		
		p1.add(lbl1,BorderLayout.SOUTH);
		
		p2.setLayout(new GridLayout(1,3,10,10));
		p2.add(btnc);
		p2.add(btnp);
		p2.add(btnback);
		
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
	}
}

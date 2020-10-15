package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME TO ASK WHETEHR THE PERSON IS USER OR ADMIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * Functionality performed: Asks whether the person is User or Admin and respectively open frames accordingly
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//USER BUTTON ACTION LISTENER

class UserG implements ActionListener
{
	WelcomeFrame f;
	Main1 mp;
	
	public UserG(WelcomeFrame fg , Main1 mp)
	{
		fg = f;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		UserLogin g = new UserLogin(mp);
		g.setVisible(true);
	}
}

//ADMIN BUTTON ACTION LISTENER

class AdminG implements ActionListener
{
	WelcomeFrame f;
	Main1 mp;
	
	public AdminG(WelcomeFrame fg , Main1 mp)
	{
		fg = f;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		AdminLogin g = new AdminLogin(mp);
		g.setVisible(true);
	}
}



//FRAME OF USER OR ADMIN

public class WelcomeFrame extends JFrame
{
	JPanel pButtons = new JPanel();
	JLabel lblheader = new JLabel("              Are you a user or Admin?");
	JLabel lbltitle = new JLabel("                 ======= WELCOME TO THE BLOOD BANK =======      ");
	JButton btnUser = new JButton("User");
	JButton btnAdmin = new JButton("Admin");
	Main1 mp;
	
	public WelcomeFrame(Main1 mp)
	{
		this.mp = mp;
		this.setTitle("BLOOD BANK SYSTEM");
		this.setBounds(0,0,500,200);
		lblheader.setBounds(0,0,100,100);
		pButtons.add(btnUser);
		pButtons.add(btnAdmin);
		
		btnUser.addActionListener(new UserG(this,mp));
		btnAdmin.addActionListener(new AdminG(this,mp));
		
		this.add(lbltitle, BorderLayout.NORTH);
		this.add(lblheader, BorderLayout.CENTER);
		this.add(pButtons, BorderLayout.SOUTH);
	}
	
}

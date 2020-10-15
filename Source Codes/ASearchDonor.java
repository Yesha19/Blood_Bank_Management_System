package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class nameAL implements ActionListener
{
	ASearchDonor as;
	Main1 mp;
	
	public nameAL(Main1 mp,ASearchDonor as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		NameS ns = new NameS(mp);
		ns.setVisible(true);
	}	
}

class bgAL implements ActionListener
{
	ASearchDonor as;
	Main1 mp;
	
	public bgAL(Main1 mp,ASearchDonor as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		bgS ns = new bgS(mp);
		ns.setVisible(true);
	}
}

class ageAL implements ActionListener
{
	ASearchDonor as;
	Main1 mp;
	
	public ageAL(Main1 mp,ASearchDonor as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		AgeS ns = new AgeS(mp);
		ns.setVisible(true);	
	}
	
}

class backAL1 implements ActionListener
{
	ASearchDonor as;
	Main1 mp;
	
	public backAL1(Main1 mp,ASearchDonor as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		as.setVisible(false);
	}
	
	
}

public class ASearchDonor extends JFrame
{
	JButton btnName = new JButton("NAME");
	JButton btnAge = new JButton("AGE");
	JButton btnBg = new JButton("BLOOD GROUP");
	JButton btnbb = new JButton("Back");
	JLabel lbl = new JLabel("SEARCH BY:");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Main1 mp;
	
	public ASearchDonor(Main1 mp)
	{
		this.mp = mp;
		this.setBounds(0,0,500,300);
		this.setTitle("SEARCH BY?");
		
		p2.setLayout(new GridLayout(1,4,10,10));
		p2.add(btnName);
		p2.add(btnAge);
		p2.add(btnBg);
		p2.add(btnbb);
		
		btnName.addActionListener(new nameAL(mp,this));
		btnAge.addActionListener(new ageAL(mp,this));
		btnBg.addActionListener(new bgAL(mp,this));
		btnbb.addActionListener(new backAL1(mp,this));
		
		p1.add(lbl);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2, BorderLayout.SOUTH);
	}
}



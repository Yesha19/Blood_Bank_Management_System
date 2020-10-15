package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class nameAL1 implements ActionListener
{
	ASearchPurchaser as;
	Main1 mp;
	
	public nameAL1(Main1 mp,ASearchPurchaser as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		NameSP ns = new NameSP(mp);
		ns.setVisible(true);
	}	
}

class bgAL1 implements ActionListener
{
	ASearchPurchaser as;
	Main1 mp;
	
	public bgAL1(Main1 mp,ASearchPurchaser as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		bgSP ns = new bgSP(mp);
		ns.setVisible(true);
	}
}

class ageAL1 implements ActionListener
{
	ASearchPurchaser as;
	Main1 mp;
	
	public ageAL1(Main1 mp,ASearchPurchaser as)
	{
		this.as = as;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		AgeSP ns = new AgeSP(mp);
		ns.setVisible(true);	
	}
	
}

class backAL11 implements ActionListener
{
	ASearchPurchaser as;
	Main1 mp;
	
	public backAL11(Main1 mp,ASearchPurchaser as)
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

public class ASearchPurchaser extends JFrame
{
	JButton btnName = new JButton("NAME");
	JButton btnAge = new JButton("AGE");
	JButton btnBg = new JButton("BLOOD GROUP");
	JButton btnbb = new JButton("Back");
	JLabel lbl = new JLabel("SEARCH BY:");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Main1 mp;
	
	public ASearchPurchaser(Main1 mp)
	{
		this.mp = mp;
		this.setBounds(0,0,500,300);
		this.setTitle("SEARCH BY?");
		
		p2.setLayout(new GridLayout(1,4,10,10));
		p2.add(btnName);
		p2.add(btnAge);
		p2.add(btnBg);
		p2.add(btnbb);
		
		btnName.addActionListener(new nameAL1(mp,this));
		btnAge.addActionListener(new ageAL1(mp,this));
		btnBg.addActionListener(new bgAL1(mp,this));
		btnbb.addActionListener(new backAL11(mp,this));
		
		p1.add(lbl);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2, BorderLayout.SOUTH);
	}
}



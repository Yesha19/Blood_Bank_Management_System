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

class doneAL3 implements ActionListener
{
	bgS ns;
	Main1 mp;
	
	public doneAL3(Main1 mp,bgS ns)
	{
		this.ns = ns;
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String name = ns.txt1.getText();
		
		mp.a.searchDonor(mp.Don,3,name);
		ns.setVisible(false);
		
	}
	
}

public class bgS extends JFrame
{
	JButton btndone = new JButton("DONE");
	JPanel p2 = new JPanel();
	JPanel p1 = new JPanel();
	
	JLabel lbl1 = new JLabel("Enter blood group:");
	JTextField txt1 = new JTextField(10);
	Main1 mp;
	
	
	public bgS(Main1 mp)
	{
		this.mp = mp;
		this.setBounds(0,0,300,300);
		
		p1.setLayout(new GridLayout(1,2,10,10));
		p1.add(lbl1);
		p1.add(txt1);
		
		p2.add(btndone);
		
		btndone.addActionListener(new doneAL3(mp,this));
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.SOUTH);
	}
	
	
}

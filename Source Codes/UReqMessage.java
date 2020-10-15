package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME OF POP UP MESSAGE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * Functionality performed : When Requester had requested a particular blood group, and at that time the bottle was not available 
 * but now when it is available, Requester must be notified with the message of availability.
 */

//OK BUTTON ACTION LISTENER
class OkAL implements ActionListener
{
	UReqMessage r;
	
	public OkAL(UReqMessage r)
	{
		this.r = r;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		r.setVisible(false);
		
	}
}

//FRAME OF MESSAGE DUE TO THE REQUEST

public class UReqMessage extends JFrame
{
	JLabel lbl1 = new JLabel("    ======  IMPORTANT MESSAGE ======   ");
	JLabel lbl2;
	JButton btn = new JButton("OK");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	public UReqMessage(String s)
	{
		this.setBounds(0,0,300,300);
		this.setTitle("MESSAGE");
		lbl2 = new JLabel("   The blood bottle of group " + s + " you earlier requested is availabe now!");
		btn.addActionListener(new OkAL(this));
		
		p1.setLayout(new GridLayout(2,1,10,10));
		p1.add(lbl1);
		p1.add(lbl2);
		
		p2.add(btn);
		
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		
	}
}

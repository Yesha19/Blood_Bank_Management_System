package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ DISPLAY  OF DONOR  DETAILS  FRAME ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * Functionality Performed: It displays contents of the Donor list onto the frame
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class ADonDetails extends JFrame
{
	JPanel p;
	JPanel[] p1;
	JLabel[] ln,lc,la,lcity,lg,lbg,ld;
	Main1 mp;
	
	// CONSTRUCTOR (DISPLAYS FRAME THAT CONTAINS ALL THE DETAILS OF DONOR)
	public ADonDetails(Main1 mp)
	{
		this.mp = mp;
		this.setBounds(0, 0, 700, 500);
		this.setTitle("DONOR DETAILS");
		p = new JPanel();
		
		p.setLayout(new GridLayout(0,7));
		
		p.add(new JLabel("NAME"));
		p.add(new JLabel("AGE"));
		p.add(new JLabel("GENDER"));
		p.add(new JLabel("CITY"));
		p.add(new JLabel("CONTACT"));
		p.add(new JLabel("B.GROUP"));
		p.add(new JLabel("DATE"));
		
		this.setLayout(new GridLayout(0,1,1,3));
		this.add(p,BorderLayout.NORTH);
		
		int i=0;
		
		//calculating the number of objects stored in the linked list and store that into variable i
		
		Node<Donor> pos1 = mp.Don.dlist.getFirst();
		while(pos1!=null)
		{
			i++;
			pos1 = pos1.getNext();
		}
		
		//defining panel and labels of size i
		
		p1 = new JPanel[i];
		ln = new JLabel[i];
		lc = new JLabel[i];
		la = new JLabel[i];
		lcity = new JLabel[i];
		lg = new JLabel[i];
		lbg = new JLabel[i];
		ld = new JLabel[i];
		
		for(int j=0;j<i;j++)
		{
			p1[j] = new JPanel();
			ln[j] = new JLabel();
			la[j] = new JLabel();
			lc[j] = new JLabel();
			lcity[j] = new JLabel();
			lg[j] = new JLabel();
			lbg[j] = new JLabel();
			ld[j] = new JLabel();
			p1[j].setLayout(new GridLayout(0,7));
		}
		
		int j=0;
		
		//displaying each attribute of the object in the list
		
		Node<Donor> pos = mp.Don.dlist.getFirst();
		
		while(pos!=null)
		{
			ln[j].setText(pos.getData().name);
			la[j].setText(String.valueOf(pos.getData().age));
			lg[j].setText(pos.getData().sex);
			lcity[j].setText(pos.getData().city);
			lc[j].setText(String.valueOf(pos.getData().contactno));
			lbg[j].setText(pos.getData().bloodgroup);
			ld[j].setText(pos.getData().date);
			
			p1[j].add(ln[j]);
			p1[j].add(la[j]);
			p1[j].add(lg[j]);
			p1[j].add(lcity[j]);
			p1[j].add(lc[j]);
			p1[j].add(lbg[j]);
			p1[j].add(ld[j]);
			
			this.add(p1[j]);
			pos = pos.getNext();
			j++;
		}
	}
	
	
	
	//CONSTRUCTOR (DISPLAYS DONOR DETAILS THAT IS INCLUDED IN THE LINKED LIST list)
	//For displaying details that Admin has searched for ( for eg : specific name, age , etc)
	
	public ADonDetails(LinkedList list)
	{
		this.setBounds(0, 0, 600, 500);
		p = new JPanel();
		this.setTitle("LIST OF DONORS");
		
		p.setLayout(new GridLayout(0,7));
		
		p.add(new JLabel("NAME"));
		p.add(new JLabel("AGE"));
		p.add(new JLabel("GENDER"));
		p.add(new JLabel("CITY"));
		p.add(new JLabel("CONTACT"));
		p.add(new JLabel("B.GROUP"));
		p.add(new JLabel("DATE"));
		
		this.setLayout(new GridLayout(0,1,1,3));
		this.add(p,BorderLayout.NORTH);
		
		//calculating the number of objects stored in the linked list and store that into variable i
		
		int i=0;
		Node<Donor> pos1 = list.getFirst();
		while(pos1!=null)
		{
			i++;
			pos1 = pos1.getNext();
		}
		
		//defining panel and labels of size i
		
		p1 = new JPanel[i];
		ln = new JLabel[i];
		lc = new JLabel[i];
		la = new JLabel[i];
		lcity = new JLabel[i];
		lg = new JLabel[i];
		lbg = new JLabel[i];
		ld = new JLabel[i];
		
		for(int j=0;j<i;j++)
		{
			p1[j] = new JPanel();
			ln[j] = new JLabel();
			la[j] = new JLabel();
			lc[j] = new JLabel();
			lcity[j] = new JLabel();
			lg[j] = new JLabel();
			lbg[j] = new JLabel();
			ld[j] = new JLabel();
			p1[j].setLayout(new GridLayout(0,7));
		}
		
		
		//displaying each attribute of the object in the list
		
		int j=0;
		Node<Donor> pos = list.getFirst();
		while(pos!=null)
		{
			ln[j].setText(pos.getData().name);
			la[j].setText(String.valueOf(pos.getData().age));
			lg[j].setText(pos.getData().sex);
			lcity[j].setText(pos.getData().city);
			lc[j].setText(String.valueOf(pos.getData().contactno));
			lbg[j].setText(pos.getData().bloodgroup);
			ld[j].setText(pos.getData().date);
			
			p1[j].add(ln[j]);
			p1[j].add(la[j]);
			p1[j].add(lg[j]);
			p1[j].add(lcity[j]);
			p1[j].add(lc[j]);
			p1[j].add(lbg[j]);
			p1[j].add(ld[j]);
			
			this.add(p1[j]);
			pos = pos.getNext();
			j++;
		}
		
	}
}

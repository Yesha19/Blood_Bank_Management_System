package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FUNCTIONS BY ADMIN - FRAME ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * 1. DISPLAY DONOR LIST
 * 2. DISPLAY PURCHASER LIST
 * 3. SORT DONOR LIST
 * 4. SORT PURCHASER LIST
 * 5. SEARCH ON DONOR LIST
 * 6. SEARCH ON PURCHASER LIST
 */
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//ACTION LISTENER OF SEARCH DONOR BUTTON 
class SearchDonorAL implements ActionListener
{
	Main1 mp;
	AFunctions af;
	
	public SearchDonorAL(AFunctions af, Main1 mp)
	{
		this.af = af;
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			//calling search Donor function of admin class	
			ASearchDonor as = new ASearchDonor(mp);
			as.setVisible(true);
		}
				 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}


//ACTION LISTENER OF SEARCH PURCHASER BUTTON 
class SearchPurchaserAL implements ActionListener
{
	Main1 mp;
	AFunctions af;
	
	public SearchPurchaserAL(AFunctions af, Main1 mp)
	{
		this.af = af;
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			//calling search purchaser function of purchaser class
			ASearchPurchaser aps = new ASearchPurchaser(mp);
			aps.setVisible(true);
		}
		 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}


//ACTION LISTENER OF SORT DONOR LIST BUTTON 
class SDAL implements ActionListener
{
	AFunctions af;
	Main1 mp;
	
	public SDAL(AFunctions af,Main1 mp)
	{
		this.mp = mp;
		this.af=af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			//calling sort donor function of Donor class
			
			mp.a.sortDonor(mp.Don);
			af.dslist.setVisible(true);
			
			//af.textArea.setVisible(true);
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}


//ACTION LISTENER OF SORT PURCHASER LIST BUTTON 
class SPAL implements ActionListener
{
	AFunctions af;
	Main1 mp;
	
	public SPAL(AFunctions af,Main1 mp)
	{
		this.mp = mp;
		this.af=af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			//calling sort purchaser function of admin class
			
			mp.a.sortPurchaser(mp.Pur);
			af.pslist.setVisible(true);
			
		} 
		catch (ClassNotFoundException | IOException e)
		{
			e.printStackTrace();
		}
	}
}


//ACTION LISTENER OF DISPLAYING DONOR LIST BUTTON 

class DDAL implements ActionListener
{
	AFunctions af;
	Main1 mp;
	
	public DDAL(AFunctions af,Main1 mp)
	{
		this.mp = mp;
		this.af=af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//calling frame to display the details of donor
		
		ADonDetails ad = new ADonDetails(mp);
		ad.setVisible(true);
	}
}


//ACTION LISTENER OF DISPLAYING PURCHASER LIST BUTTON 

class DPAL implements ActionListener
{
	AFunctions af;
	Main1 mp;
	
	public DPAL(AFunctions af,Main1 mp)
	{
		this.mp = mp;
		this.af=af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//calling frame to display the details of donor
		
		APurDetails ad = new APurDetails(mp);
		ad.setVisible(true);
	}
}

//ACTION LISTENER OF BACK BUTTON 
class bb implements ActionListener
{
	AFunctions af;
	Main1 mp;
	
	public bb(AFunctions af,Main1 mp)
	{
		this.mp = mp;
		this.af=af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		displayBloodBottles ad = null;
		
		try 
		{
			//calling frame to display the number of blood bottles available
			
			ad = new displayBloodBottles(mp);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		ad.setVisible(true);
	}
}

//ACTION LISTENER OF LOG OUT BUTTON 
class logoutAL implements ActionListener
{
	AFunctions af;
	
	public logoutAL(AFunctions af)
	{
		this.af = af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println("LOGGED OUT SUCCESSFULLY!");
		af.setVisible(false);
	}	
}

class Req implements ActionListener
{
	AFunctions af;
	Main1 mp;
	
	public Req(AFunctions af,Main1 mp)
	{
		this.af = af;
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		FrReq r;
		try 
		{
			r = new FrReq(mp);
			r.setVisible(true);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// FUNCTIONS PERFORMED BY ADMIN - FRAME 

public class AFunctions extends JFrame
{
	private static final long serialVersionUID = 1L;
	JLabel header = new JLabel("What do you want to do?");
	JButton btnSearchDonor = new JButton("Search Donor");
	JButton btnSearchPurchaser = new JButton("Search Purchaser");
	JButton btnSortDonor = new JButton("Sort Donor");
	JButton btnSortPurchaser = new JButton("Sort Purchaser");
	JButton btnDonList = new JButton("Display Donor List");
	JButton btnPurList = new JButton("Display Purchaser List");
	JButton btnlogout = new JButton("Logout");
	JButton btnbb = new JButton("Blood Bottles");
	JButton btnreq = new JButton("Pending Requests");
	JTextArea textArea = new JTextArea("DONOR LIST SORTED!" +  "\nCLICK DISPLAY",6, 20);
	
	JLabel dslist = new JLabel("DONOR LIST SORTED! CLICK DISPLAY");
	JLabel pslist = new JLabel("PURCHASER LIST SORTED! CLICK DISPLAY");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Main1 mp;
	String id,pass;
	
	public AFunctions(Main1 mp,String id,String pass)
	{
		this.mp = mp;
		this.setTitle("ADMIN FUNCTIONS");
		this.setBounds(0,0,600,400);
		this.id = id;
		this.pass = pass;
		
		header.setBounds(10,10,50,20);
		btnSearchDonor.setBounds(10, 10, 50, 20);
		btnSearchDonor.addActionListener(new SearchDonorAL(this,mp));
		btnSearchPurchaser.setBounds(10, 10, 50, 20);
		btnSearchPurchaser.addActionListener(new SearchPurchaserAL(this,mp));
		btnSortDonor.addActionListener(new SDAL(this,mp));
		btnSortPurchaser.addActionListener(new SPAL(this,mp));
		btnDonList.addActionListener(new DDAL(this,mp));
		btnPurList.addActionListener(new DPAL(this,mp));
		btnbb.addActionListener(new bb(this,mp));
		btnlogout.addActionListener(new logoutAL(this));
		btnreq.addActionListener(new Req(this,mp));

		btnSearchDonor.setBackground(Color.WHITE);
		btnSearchPurchaser.setBackground(Color.WHITE);
		btnSortDonor.setBackground(Color.WHITE);
		btnSortPurchaser.setBackground(Color.WHITE);
		btnDonList.setBackground(Color.WHITE);
		btnPurList.setBackground(Color.WHITE);
		btnlogout.setBackground(Color.WHITE);
		btnbb.setBackground(Color.WHITE);	
		btnreq.setBackground(Color.WHITE);
		
		p2.setLayout(new GridLayout(3,3,10,10));
		
		p1.add(header,BorderLayout.CENTER);
		p2.add(btnSearchDonor);
		p2.add(btnSearchPurchaser);
		p2.add(btnSortDonor);
		p2.add(btnSortPurchaser);
		p2.add(btnDonList);
		p2.add(btnPurList);
		p2.add(btnbb);
		p2.add(btnlogout);
		p2.add(btnreq);
		p2.add(dslist);
		p2.add(pslist);
		
		textArea.setVisible(false);
		dslist.setVisible(false);
		pslist.setVisible(false);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
	}

}

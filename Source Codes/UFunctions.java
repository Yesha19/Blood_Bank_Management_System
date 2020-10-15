package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  FRAME OF FUNCTIONS PERFORMED BY USER ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/*
 * 1. TO DONATE
 * 2. TO REQUEST
 * 3. TO UPDATE THE RECORDS
 * 4. TO DELETE ACCOUNT
 * 5. LOGOUT
 */

//DONATE BUTTON ACTION LISTENER

class DonateAL implements ActionListener
{
	Main1 mp;
	UFunctions uf;
	String id;
	String pass;
	
	public DonateAL(UFunctions uf, Main1 mp,String id,String pass)
	{
		this.uf = uf;
		this.mp = mp;
		this.id = id;
		this.pass = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//Reading each object from users list and checking if that matches with the current user id and password
		Node<User> pos = mp.u.ulist.getFirst();
		while(pos!=null)
		{
			if( (pos.getData().user_id.equals(id)) && (pos.getData().password.equals(pass) ))
			{	
				try 
				{
					//calling checkDonor function of Doctor class (to check if the donor is fit to donate or not)
					mp.Doc.checkDonor(pos, id, pass, mp);
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			pos = pos.getNext();
		}
	}
	
}


//PURCHASE BUTTON ACTION LISTENER

class PurchaseAL implements ActionListener
{
	Main1 mp;
	UFunctions uf;
	String id;
	String pass;
	
	public PurchaseAL(UFunctions uf, Main1 mp,String id,String pass)
	{
		this.uf = uf;
		this.mp = mp;
		this.id = id;
		this.pass = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//Reading each object from users list and checking if that matches with the current user id and password
		Node<User> pos = mp.u.ulist.getFirst();
		while(pos!=null)
		{
			if( (pos.getData().user_id.equals(id)) && (pos.getData().password.equals(pass) ) )
			{	
				try 
				{
					//Calling frame UPurchaser
					UPurchaser p = new UPurchaser(mp,pos.getData().name , pos.getData().age , pos.getData().sex , pos.getData().contactno , pos.getData().city , id , pass);
					p.setVisible(true);
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			pos = pos.getNext();
		}
	}
	
}


//UPDATE BUTTON ACTION LISTENER

class UpdateAL implements ActionListener
{
	Main1 mp;
	UFunctions uf;
	String id;
	String pass;
	
	public UpdateAL(UFunctions uf, Main1 mp ,String id,String pass)
	{
		this.mp = mp;
		this.uf = uf;
		this.id = id;
		this.pass = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Node<User> pos = mp.u.ulist.getFirst();
		while(pos!=null)
		{
			if( (pos.getData().user_id.equals(id)) && (pos.getData().password.equals(pass) ) )
			{	
				try 
				{
					//calling frame Uupdate
					Uupdate ud = new Uupdate(mp,id,pass);
					ud.setVisible(true);
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			pos = pos.getNext();
		}
	}
}


//DELETE BUTTON ACTION LISTENER

class DeleteAL implements ActionListener
{
	UFunctions uf;
	Main1 mp;
	String id;
	String pass;
	
	public DeleteAL(UFunctions uf , Main1 mp,String id,String pass)
	{
		this.uf = uf;
		this.mp = mp;
		this.id = id;
		this.pass = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			//calling deleteUser function of Admin class
			mp.a.deleteUser(id, pass, mp.Don, mp.Pur, mp.u);
			uf.setVisible(false);
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		}	
	}
}

class LogoutAL1 implements ActionListener
{
	UFunctions uf;
	
	public LogoutAL1(UFunctions uf)
	{
		this.uf = uf;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("\nLogging out...\n");
		System.out.println("~~~~~~~~~~~~~~ You are logged Out ~~~~~~~~~~~");
		uf.setVisible(false);
	}
	
}


//BACK BUTTON ACTION LISTENER

class BackAL implements ActionListener
{
	UFunctions uf;
	
	public BackAL(UFunctions uf)
	{
		this.uf = uf;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		uf.setVisible(false);
	}
}


// FRAME OF FUNCTIONC PERFORMED BY USER

public class UFunctions extends JFrame
{
	JLabel header = new JLabel("Why Are You here?");
	JButton btnDonor = new JButton("DONATE");
	JButton btnPurchase = new JButton("REQUEST");
	JButton btnUpdate = new JButton("UPDATE DETAILS");
	JButton btnDelete = new JButton("DELETE ACCOUNT");
	JButton btnLogout = new JButton("LOGOUT");
	JButton btnBack = new JButton("BACK");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Main1 mp;
	String id,pass;
	
	public UFunctions(Main1 mp,String id,String pass)
	{
		this.mp = mp;
		this.setTitle("USER FUNCTIONS WINDOW");
		this.setBounds(0,0,500,300);
		this.id = id;
		this.pass = pass;
		
		header.setBounds(10,10,50,20);
		btnDonor.setBounds(10, 10, 50, 20);
		btnDonor.addActionListener(new DonateAL(this,mp,id,pass));
		btnPurchase.addActionListener(new PurchaseAL(this,mp,id,pass));
		btnUpdate.addActionListener(new UpdateAL(this,mp,id,pass));
		btnDelete.addActionListener(new DeleteAL(this,mp,id,pass));
		btnLogout.addActionListener(new LogoutAL1(this));
		btnBack.addActionListener(new BackAL(this));
		

		btnDonor.setBackground(Color.WHITE);
		btnPurchase.setBackground(Color.WHITE);
		btnUpdate.setBackground(Color.WHITE);
		btnDelete.setBackground(Color.WHITE);
		btnLogout.setBackground(Color.WHITE);
		btnBack.setBackground(Color.WHITE);
		
		
		p2.setLayout(new GridLayout(2,3,70,70));
		
		p1.add(header,BorderLayout.CENTER);
		p2.add(btnDonor);
		p2.add(btnPurchase);
		p2.add(btnUpdate);
		p2.add(btnDelete);
		p2.add(btnLogout);
		p2.add(btnBack);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
	}
}

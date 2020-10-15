package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ USER LOGIN FRAME ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * Functionality performed : Asks the user its id and password if already registered,else gives tells user to register.
 * 							 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//LOGIN BUTTON ACTION LISTENER

class loginActionListener implements ActionListener
{
	UserLogin u;
	Main1 mp;
	
	public loginActionListener()
	{
		
	}
	
	public loginActionListener(UserLogin u , Main1 mp)
	{
		this.u = u;
		this.mp = mp;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String id,pass;
		id = u.txtid.getText();
		pass = new String(u.txtpassword.getPassword());
		
		try 
		{
			if((id.equals("") || pass.equals("")) == false)
			{
				int ax = mp.u.userCheck(id,pass);
				if(ax == 1)
				{
					u.txtid.setText("");
					u.txtpassword.setText("");
					UFunctions uf = new UFunctions(mp,id,pass);
					uf.setVisible(true);
					
					//requests
					File f1 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
					if(f1.exists())
					{
						String s = mp.r.checkRequest(id);
						//s is bg
						
						if(!s.equals("0"))
						{
							int x = mp.fo.checkBottle(s);
							if(x > 0)
							{
								int y = mp.r.req(id, x);
								
								if(y == 1)
								{
									mp.r.removeRequest(id);
									UReqMessage r = new UReqMessage(s);
									r.setVisible(true);
								}
							}
						}
					}
					
					u.lbl1.setVisible(false);
				}
				else
				{
					u.lbl1.setVisible(true);
				}
				u.lbl2.setVisible(false);
			}
			else
			{
				u.lbl2.setVisible(true);
			}
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}

//REGISTER BUTTON ACTION LISTENER

class registerActionListener implements ActionListener
{
	Main1 mp;
	UserLogin up;
	
	public registerActionListener(UserLogin up,Main1 mp)
	{
		this.mp = mp;
		this.up = up;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		UDetails ul = new UDetails(mp);
		ul.setVisible(true);
		
	}
}

class bAL implements ActionListener
{
	UserLogin ul;
	
	public bAL(UserLogin ul)
	{
		this.ul = ul;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		ul.setVisible(false);
	}
}



//USER LOGIN FRAME 

public class UserLogin extends JFrame
{
	public JPanel pb = new JPanel();   
	public JPanel pw = new JPanel();
	public JPanel pe = new JPanel();
	Main1 mp;
	
	public JLabel id = new JLabel("User Id :");
	public JLabel pass = new JLabel("Password :");
	//public JTextField txtpassword = new JTextField(10);
	JPasswordField txtpassword = new JPasswordField(20);
	public JTextField txtid = new JTextField(10);
	public JButton btnlogin = new JButton("LOGIN");
	public JButton btnreg = new JButton("REGISTER");
	public JButton btnBack = new JButton("BACK");
	public JLabel lbl1;
	public JLabel lbl2;
	
	public UserLogin(Main1 mp)
	{
		this.mp = mp;
		this.setTitle("USER LOGIN WINDOW");
		this.setBounds(0, 0, 500, 300);
		pb = new JPanel();
		lbl1 = new JLabel("WRONG USERID/PASSWORD");
		lbl2 = new JLabel("FIELDS CAN'T BE EMPTY");
		txtpassword.setEchoChar('#');
		
		pb.setLayout(new GridLayout(2,3,5,5));
		pb.add(btnlogin);
		pb.add(btnreg);
		pb.add(btnBack);
		pb.add(lbl1);
		pb.add(lbl2);
		
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		
		txtpassword.setBounds(100, 100, 0, 0);
		txtid.setBounds(100,100,10,10);
		id.setBounds(50, 50, 100, 100);
		pass.setBounds(101,50,100,100);
		
		btnlogin.addActionListener(new loginActionListener(this,mp));
		btnreg.addActionListener(new registerActionListener(this,mp));
		btnBack.addActionListener(new bAL(this));
		
		pw = new JPanel();
		pw.setLayout(new GridLayout(2,0));
		pw.add(id);
		pw.add(pass);
		
		pe = new JPanel();
		pe.setLayout(new GridLayout(2,0));
		pe.add(txtid);
		pe.add(txtpassword);
		
		this.add(pb,BorderLayout.SOUTH);
		this.add(pw,BorderLayout.WEST);
		this.add(pe, BorderLayout.EAST);
		
	}
}

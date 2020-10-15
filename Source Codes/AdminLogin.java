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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ADMIN  LOGIN  WINDOW  FRAME  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//LOGIN BUTTON ACTION LISTENER

class A_loginActionListener implements ActionListener
{
	AdminLogin a;
	Main1 mp;
	
	public A_loginActionListener()
	{
		
	}
	
	public A_loginActionListener(AdminLogin a , Main1 mp)
	{
		this.a = a;
		this.mp = mp;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String id,pass;
		id = a.txtid.getText();
		pass = new String(a.txtpassword.getPassword());
		
		try 
		{
			int ax = mp.a.adminCheck(id,pass);
			if(ax == 1)
			{
				a.txtid.setText("");
				a.txtpassword.setText("");
				a.lbl1.setVisible(false);
				AFunctions af = new AFunctions(mp,id,pass);
				af.setVisible(true);
			}
			else
			{
				a.lbl1.setVisible(true);
			}			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


//BACK BUTTON ACTION LISTENER

class BackActionListener implements ActionListener
{
	AdminLogin al;
	
	public BackActionListener(AdminLogin al)
	{
		this.al = al;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		al.setVisible(false);		
	}
}


//~~~~~~~~~~~~~~~~~~~~~   ADMIN LOGIN FRAME  ~~~~~~~~~~~~~~~~~~~~~~~~~

public class AdminLogin extends JFrame
{
	private static final long serialVersionUID = 1L;
	public JPanel pb = new JPanel();   
	public JPanel pw = new JPanel();
	public JPanel pe = new JPanel();
	Main1 mp;
	
	public JLabel id = new JLabel("Admin Id :");
	public JLabel pass = new JLabel("Password :");
	public JPasswordField txtpassword = new JPasswordField(20);
	public JTextField txtid = new JTextField(10);
	public JButton btnlogin = new JButton("LOGIN");
	public JButton btnBack = new JButton("Back");
	public JLabel lbl1 = new JLabel("INCORRECT ID OR PASSWORD");
	
	public AdminLogin(Main1 mp)
	{
		this.mp = mp;
		this.setTitle("ADMIN LOGIN WINDOW");
		this.setBounds(0, 0, 500, 200);
		pb = new JPanel();
		pb.add(btnlogin);
		pb.add(btnBack);
		pb.add(lbl1);
		lbl1.setVisible(false);
		txtpassword.setEchoChar('#');
		
		txtpassword.setBounds(100, 100, 0, 0);
		txtid.setBounds(100,100,10,10);
		id.setBounds(50, 50, 100, 100);
		pass.setBounds(101,50,100,100);
		
		btnlogin.addActionListener(new A_loginActionListener(this,mp));
		btnBack.addActionListener(new BackActionListener(this));
		
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

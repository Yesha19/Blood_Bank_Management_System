package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FRAME OF DISPLAYING AVAILABLE NUMBER OF BLOOD BOTTLES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class displayBloodBottles extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	JPanel p =new JPanel();
	JPanel[] p1 = new JPanel[8];
	JLabel[] lblgp = new JLabel[8];
	JLabel[] lblno = new JLabel[8];
	Main1 mp;
	
	public displayBloodBottles(Main1 mp) throws IOException
	{
		this.mp = mp;
		this.setBounds(0, 0, 500, 500);
		this.setTitle("BLOOD BOTTLES AVAILABLE");
		
		this.setLayout(new GridLayout(9,1));
		
		String[] w = new String[10];
		String h;
		
		p.setLayout(new GridLayout(1,2));
		p.add(new JLabel("BLOOD GROUP"));
		p.add(new JLabel("BOTTLES"));
		
		this.add(p);
		
		//opening the file in reading mode
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		int j=0;
		
		
		//reading each line from the file and displaying the blood group and its corresponding number on the frame
		//w[0] denotes the blood group
		//w[1] denotes the number of bottles available of that blood group
		
		while((h=din.readLine())!=null && j<8)
		{
			w = h.split("\\s");
			p1[j] = new JPanel();
			lblgp[j] = new JLabel(w[0]);
			lblno[j] = new JLabel(w[1]);
			
			p1[j].setLayout(new GridLayout(1,2));
			p1[j].add(lblgp[j]);
			p1[j].add(lblno[j]);
			
			this.add(p1[j]);
			j++;
		}
		
		//closing the file
		
		f.close();
		fin.close();
		din.close();
	}
}
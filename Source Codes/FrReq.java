package BloodBankManagment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrReq extends JFrame
{
	JPanel p;
	JPanel[] p1;
	JLabel[] ln,lbg,ld,lrd;
	Main1 mp;
	
	// CONSTRUCTOR (DISPLAYS FRAME THAT CONTAINS ALL THE DETAILS OF DONOR)
	public FrReq(Main1 mp) throws IOException
	{
		this.mp = mp;
		this.setBounds(0, 0, 600, 500);
		this.setTitle("PENDING REQUEST");
		p = new JPanel();
		
		p.setLayout(new GridLayout(0,4));
		
		p.add(new JLabel("USER ID"));
		p.add(new JLabel("B.GROUP"));
		p.add(new JLabel("REQUEST DATE"));
		p.add(new JLabel("  END DATE"));
		
		
		this.setLayout(new GridLayout(0,1,1,3));
		this.add(p,BorderLayout.NORTH);
		
		int i=0;
		//calculating the number of objects stored in the linked list and store that into variable i
		String h;
		String[][] w = new String[100][10];
		
		File f2 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
		
		if(f2.exists())
		{
				FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
				InputStreamReader fin = new InputStreamReader(f);
				BufferedReader din  = new BufferedReader(fin);
				
				while((h=din.readLine())!=null)
				{
					w[i] = h.split("\\s");
					i++;
				}
				
				din.close();
				fin.close();
				f.close();
				//defining panel and labels of size i
				System.out.println(i);
				
				p1 = new JPanel[i];
				ln = new JLabel[i];
				lbg = new JLabel[i];
				lrd = new JLabel[i];
				ld = new JLabel[i];
				
				for(int j=0;j<i;j++)
				{
					p1[j] = new JPanel();
					ln[j] = new JLabel();
					lbg[j] = new JLabel();
					lrd[j] = new JLabel();
					ld[j] = new JLabel();
					p1[j].setLayout(new GridLayout(0,4,20,20));
				}
				
				int j=0;
				
				//displaying each attribute of the object in the list
				
				for(j=0;j<i;j++)
				{
					ln[j].setText(w[j][1]);
					lbg[j].setText(w[j][0]);
					
					String d1 = w[j][2] + "/" + w[j][3] + "/" + w[j][4];
					String d2 = w[j][5] + " " + w[j][6];
					
					lrd[j].setText(d2);
					ld[j].setText(d1);
					
					p1[j].add(ln[j]);
					p1[j].add(lbg[j]);
					p1[j].add(lrd[j]);
					p1[j].add(ld[j]);
					
					this.add(p1[j]);
				}
		}
	}
}

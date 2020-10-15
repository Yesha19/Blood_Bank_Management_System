package BloodBankManagment;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  RECEIPT FOR PURCHASERS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//FRAME OF RECEIPT GENERATION
public class Receipt extends JFrame
{
    Scanner sc = new Scanner(System.in);
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel lbl3 = new JLabel();
    JPanel p1  = new JPanel();
    
    public Receipt()
    {
    	
    }
    
    public Receipt(String wantedBloodGroup) throws IOException
    {
    	String h;
    	String[] w;
    	this.setBounds(0,0,300,300);
    	this.setTitle("RECEIPT");
    	p1.setLayout(new GridLayout(4,1,10,10));
    	
    	FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//reading each line from the file and if the bloodgroup matches, printing the price of that blood group
		while((h=din.readLine())!= null)
		{
			w = h.split("\\s");
			if(w[0].equals(wantedBloodGroup))
			{
                lbl1.setText("=========== Receipt ============");
                lbl2.setText("Blood group you wanted : " + wantedBloodGroup);
                lbl3.setText("Price: Rs " + w[1]);
			}
		}
		
		p1.add(lbl1);
		p1.add(lbl2);
		p1.add(lbl3);
		
		this.add(p1);
    }
    
}

/*
 * public void DisplayReceipt(String wantedbloodgroup)
    {
        switch(wantedbloodgroup)
        {
            case "A+":
            {
                System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : A+");
                System.out.println("\nCost : Rs 1000/-\n");
                break;
            }
            
            case "A-":
            {
            	System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : A-");
                System.out.println("\nCost : Rs 1000/-\n");
                break;
            }
            
            case "B+":
            {
                System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : B+");
                System.out.println("\nCost : Rs 1000/-\n");
            }
                 
            case "B-":
            {
            	System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : B-");
                System.out.println("\nCost : Rs 1000/-\n");
                break;
            }
                 
            case "O+":
            {
            	System.out.println("\n============Receipt============");
		        System.out.println("\nBlood group you wanted : O+");
		        System.out.println("\nCost : Rs 1000/-\n");
		        break;
            }
                 
            case "O-":
            {
                System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : O-");
                System.out.println("\nCost : Rs 5000/-\n");
                break;
             }
                 
            case "AB+":
            {
                System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : AB+");
                System.out.println("\nCost : Rs 1000/-\n");
                break;
             }
                 
            case "AB-":
             {
            	 System.out.println("\n============Receipt============");
                System.out.println("\nBlood group you wanted : AB-");
                System.out.println("\nCost : Rs 1000/-\n");
                break;
             }
        }   
    }
 */
 /* 
 public void fileData() throws IOException
    {
    	FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\src\\BBM\\price.txt");
    	PrintWriter w = new PrintWriter(fw);

    	w.write("A+ 1000");
    	w.println();
    	w.write("A- 1000");
    	w.println();
    	w.write("B+ 1000");
    	w.println();
    	w.write("B- 1000");
    	w.println();
    	w.write("O+ 1000");
    	w.println();
    	w.write("O- 1000");
    	w.println();
    	w.write("AB+ 1000");
    	w.println();
    	w.write("AB- 1000");
    	w.println();

    	fw.close();
    	w.close();
    }
    
 */
/*
public void displayReceipt(String wantedBloodGroup) throws IOException
{
	String h;
	String[] w;
	FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out.txt");
	InputStreamReader fin = new InputStreamReader(f);
	BufferedReader din  = new BufferedReader(fin);
	
	while((h=din.readLine())!= null)
	{
		w = h.split("\\s");
		if(w[0].equals(wantedBloodGroup))
		{
			System.out.println("\n=========== Receipt ============");
            System.out.println("\nBlood group you wanted : " + wantedBloodGroup);
            System.out.println("\n Price: Rs " + w[1] + "\n");
            
		}
	}
}*/

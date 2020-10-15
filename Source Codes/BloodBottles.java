package BloodBankManagment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CLASS BLOOD BOTTLES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * CONTAINS functions:
 * 1. file(bloodgroup) - Increment the number of blood group bottle that is donated by donor
 * 2. file1(bloodgroup) - Decrement the number of blood group bottle that is purchased by the requester
 * 3. checkBottle(bloodgroup) - To check whether the specified blood group is available or not
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class BloodBottles 
{
	//FUNCTION TO ADD THE NUMBER OF BOTTLE OF THE BLOOD GROUP DONATED BY THE DONOR
	
	public void file(String bg) throws IOException
	{
		String[] w1 = new String[10];
		String h;
		String oldtext = "";
		String aftertext = "";
		int temp = 1;
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		
		//storing contents of file till that blood group comes , into oldtext
		
		String ch = bg;
		int i=0;
		while((h=din.readLine())!=null)
		{
			w1 = h.split("\\s");
			
			if(w1[0].equals(ch))
			{
				temp = 1;
				break;
			}
			else
			{
				oldtext = oldtext + h + "\n";
			}
		}
		
		//storing contents of file after that blood group comes , into aftertext
		
		while((h=din.readLine())!=null)
		{
			aftertext = aftertext + h + "\n";
		}
	
		f.close();
		fin.close();
		din.close();
		
		
		int a = Integer.valueOf(w1[1]);
		FileWriter fw2 = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
		PrintWriter w2 = new PrintWriter(fw2);
		
		//writing the oldtext, the incremented number and the aftertext in the file
		
		w2.write(oldtext);
		w2.write(w1[0] + " " + (a+1));
		w2.println();
		w2.write(aftertext);
		
		fw2.close();
		w2.close();
		
	}
	
	//FUNCTION TO SUBTRACT THE NUMBER OF BOTTLES OF THE BLOOD GROUP PURCHASED BY THE PURCHASER
	
	public void file1(String bg) throws NumberFormatException, IOException
	{
		String[] w1 = new String[10];
		String h;
		
		String oldtext = "";
		String aftertext = "";
		int temp = 1;
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//storing contents of file till that blood group comes , into oldtext
		
		String ch = bg;
		int i=0;
		while((h=din.readLine())!=null)
		{
			w1 = h.split("\\s");
			
			if(w1[0].equals(ch))
			{
				temp = 1;
				System.out.println(Integer.valueOf(w1[1]));
				break;
			}
			else
			{
				oldtext = oldtext + h + "\n";
			}
		}
		
		//storing contents of file after that blood group comes , into aftertext
		
		while((h=din.readLine())!=null)
		{
			aftertext = aftertext + h + "\n";
		}
		
		f.close();
		fin.close();
		din.close();
		
		int a = Integer.valueOf(w1[1]);
		FileWriter fw2 = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
		PrintWriter w2 = new PrintWriter(fw2);
		
		//writing the oldtext, the decremented number and the aftertext in the file
		
		w2.write(oldtext);
		w2.write(w1[0] + " " + (a-1));
		w2.println();
		w2.write(aftertext);
		
		fw2.close();
		w2.close();
	}
	
	//FUNCTION TO CHECK WHETHER THE BLOODGROUP BOTTLE IS AVAILABLE OR NOT
	
	public int checkBottle(String bg) throws IOException
	{
		String h;
		String[] w = new String[5];
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//reading each line and checking whether the number of that bottle is greater than zero, if yes then returning 1 else returning zero
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[0].equals(bg) && Integer.valueOf(w[1])>0)
			{
				return Integer.valueOf(w[1]);
			}
		}
		
		return 0;
	}

}

/*FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\src\\BBM\\out1.txt");
PrintWriter w = new PrintWriter(fw);

w.write("A+ 0");
w.println();
w.write("A- 0");
w.println();
w.write("B+ 0");
w.println();
w.write("B- 0");
w.println();
w.write("O+ 0");
w.println();
w.write("O- 0");
w.println();
w.write("AB+ 0");
w.println();
w.write("AB- 0");
w.println();

fw.close();
w.close();*/

/*public void displayBottles() throws IOException
{
	String[] w = new String[10];
	String h;
	
	System.out.println("BLOOD GROUPS             NUMBER OF BOTTLES");
	
	FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\out1.txt");
	InputStreamReader fin = new InputStreamReader(f);
	BufferedReader din  = new BufferedReader(fin);
	
	while((h=din.readLine())!=null)
	{
		w = h.split("\\s");
		System.out.printf("%-30s %s\n", w[0], w[1]);
	}
	
	System.out.println("\n");
	
	f.close();
	fin.close();
	din.close();
}*/


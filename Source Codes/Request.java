package BloodBankManagment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CLASS REQUEST ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * CONTAINS FUNCTIONS:
 * 1. fileRequest - file the request of that user because blood grop he requested is not available
 * 2. checkRequest - checking whether that user had requested earlier or not
 * 3. removeRequest - removing request of user (if user has requested)
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


public class Request 
{
	//FUNCTION to add the request if the blood bottle is not available
	


	public void fileRequest(String id,String bg,String date) throws IOException
	{
		String[] k = new String[10];
		
		k = date.split("/");
		int day,mon,year,d1,m1,y1;
		
		day = Integer.valueOf(k[0]);
		mon = Integer.valueOf(k[1]);
		year = Integer.valueOf(k[2]);
		
		FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt",true);
		PrintWriter w = new PrintWriter(fw);
		
		//writing the id and bloodgroup in the file
		//w.println();
		LocalDate y0 = java.time.LocalDate.now();
		
		String h1 = y0.toString();
		String[] k1 = new String[10];
		
		k1 = h1.split("-");
		
		d1 = Integer.valueOf(k1[2]);
		m1 = Integer.valueOf(k1[1]);
		y1 = Integer.valueOf(k1[0]);
		
        LocalDate date2 = LocalDate.of(Integer.valueOf(k1[0]),Integer.valueOf(k1[1]),Integer.valueOf(k1[2]));  //cd
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));
        
		w.write(bg + " " + id + " " + day + " " + mon + " " + year + " " + dtf.format(now));
		w.println();
		
		w.close();
		fw.close();
	}
	
	
	//FUNCTION to check whether the user has requested or not
	
	public String checkRequest(String id) throws IOException
	{
		String h;
		String[] w = new String[20];
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//reading each line from the file and returning that bloodgroup that that user requested earlier
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			
			if(w[1].equals(id))
			{
				din.close();
				return w[0];
			}
		}
		return "0";
	}
	
	public int req(String id,int x) throws IOException
	{
		String h,h1;
		String[] w = new String[10];
		int d,m,y,d1,m1,y1,flag = 0 , flag1 = 0;
		LocalDate date1 = null,date2 = null;
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//reading each line from the file and returning that blood group that that user requested earlier
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[1].equals(id))
			{
				//date user said
				
				d = Integer.valueOf(w[2]);
				m = Integer.valueOf(w[3]);
				y = Integer.valueOf(w[4]);
				
				//present date
				LocalDate y0 = java.time.LocalDate.now();
				
				h1 = y0.toString();
				String[] k = new String[10];
				
				k = h1.split("-");
				
		        date1 = LocalDate.of(y,m,d);
		        date2 = LocalDate.of(Integer.valueOf(k[0]),Integer.valueOf(k[1]),Integer.valueOf(k[2]));  //cd
		        
		        if(date1.isAfter(date2) || date1.isEqual(date2))
		        {
		        	flag = 1;
		        }
		        else
		        {
		        	return 0; //0
		        }
		        
		        //System.out.println("flag " + flag);
		        break;
			}
		}
		
		din.close();
		fin.close();
		f.close();
		
		String[] ty = new String[10];
		if(flag == 1)
		{
			FileInputStream f1 = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
			InputStreamReader fin1 = new InputStreamReader(f1);
			BufferedReader din1  = new BufferedReader(fin1);
			ArrayList<String> list = new ArrayList<>();
			
			while((h=din1.readLine())!=null)
			{
				ty = h.split("\\s");
				if(ty[0].equals(w[0]))
				{
					LocalDate date5 = LocalDate.of(Integer.valueOf(ty[4]),Integer.valueOf(ty[3]),Integer.valueOf(ty[2]));
					list.add(date5.toString());
				}
			}
			
			Collections.sort(list);
			
			for(int i=0;i<x;i++)
			{
				if(list.get(i).equals(date1.toString()))
				{
					flag1 = 1;
					//System.out.println("hello");
					break;
					//denotes message can be displayed
				}
			}
			 
			if(flag1 == 1)
				return 1;
		}
		
		return 0;
	}
	
	
	public void removeRequest(String id) throws IOException
	{
		String h,oldtext="",aftertext="";
		String[] w = new String[10];
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//storing the contents of the file that appears before id appears into oldtext
		
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[1].equals(id))
				break;
			else
				oldtext = oldtext + h + "\n";
		}
		
		//storing the contents of the file that appears after id appears into aftertext
		
		while((h=din.readLine())!=null)
		{
			aftertext = aftertext + h + "\n";
		}
		
		din.close();
		fin.close();
		f.close();
		
		FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
		PrintWriter w1 = new PrintWriter(fw);
		
		//writing oldtext and aftertext in file
		w1.write(oldtext);
		w1.write(aftertext);
		
		w1.close();
		fw.close();
	}
}

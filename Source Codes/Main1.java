package BloodBankManagment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BLOOD BANK MANAGEMENT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * MAIN FUNCTION OF THE PROJECT
 * (calls WelcomeFrame)
 */
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Main1 
{
	static User u;
	static Donor Don;
	static Doctor Doc;
	static Purchaser Pur;
	static BloodBottles fo;
	static Receipt B1;
	static Request r;
	static Admin a;
	
	public static void main(String[] args) throws Exception 
	{
		//Initialize all class's objects 
		
		Main1 mp = new Main1();
		u = new User();
		Don = new Donor();
		Doc = new Doctor ("Dr.Muskan", 33);
		Pur=new Purchaser();   
	    fo = new BloodBottles();
	    B1 = new Receipt();
	    r = new Request();
	    a = new Admin();
	    
	    //removing requests
	    
	    LocalDate y0 = java.time.LocalDate.now();
	    String h1 = y0.toString();
	    
	    String[] k = new String[10];
		k = h1.split("-");
        LocalDate date2 = LocalDate.of(Integer.valueOf(k[0]),Integer.valueOf(k[1]),Integer.valueOf(k[2]));  
        
	    String h;
	    String[] ty = new String[10];
	    
	    File f2 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
	    
	    if(f2.exists())
	    {
		    FileInputStream f1 = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Requests.txt");
			InputStreamReader fin1 = new InputStreamReader(f1);
			BufferedReader din1  = new BufferedReader(fin1);
			
			while((h=din1.readLine())!=null)
			{
				ty = h.split("\\s");
				
				LocalDate date5 = LocalDate.of(Integer.valueOf(ty[4]),Integer.valueOf(ty[3]),Integer.valueOf(ty[2]));
				
				if(date2.isAfter(date5))
				{
					r.removeRequest(ty[1]);
				}
			}
			
			din1.close();
	    }
	    
	    //Calling WelcomeFrame (choosing between "USER" and "ADMIN")
	    
	    WelcomeFrame f12=new WelcomeFrame(mp);
		f12.setVisible(true);
	}

}

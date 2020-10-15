package BloodBankManagment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CLASS DONOR  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * CONTAINS ATTRIBUTES of User class (as it extends it) and contains bloodgroup, dlist (Donor Linked List)
 * 
 * CONTAINS FUNCTIONS:
 * 1. CONSTRUCTORS : To read the objects stored in file and insert that into dlist
 * 2. inputDonor() : inputting the details of Donor and storing that into file and dlist
 * 3. displayDonorList() : displaying donor list
 * 4. changeContact() and changePassword() : changing the contact and password of that donor
 * 5. dlistToFile() : Storing the contents of dlist to file
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Donor extends User implements Serializable 
{
    int d;
    int c =0;
    String bloodgroup;
    String date;
    LinkedList<Donor> dlist;
    private static final long serialVersionUID = -1254508370517952375L;
    
    //DEFAULT CONSTRUCTOR  (It takes the donor objects stored in the DONORS.TXT file and store it in the dlist)
     
    public Donor() throws Exception
    {
    	dlist= new LinkedList<>();
    	File f1 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Donors.txt");
		if(f1.exists())
		{
		   FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Donors.txt");
		   BufferedInputStream bis = new BufferedInputStream(file);
		   bis.mark(0);
		   bis.reset();
	       ObjectInputStream obj = new ObjectInputStream(bis);
	      
	       Donor c1 = null;
	       while(bis.available()>0)
	       {
	    	   c1=(Donor) obj.readObject();
	    	   dlist.insert(c1);
	       }
	       
	       if(file.markSupported())
			   file.reset();
	       
	       obj.close();
	       file.close();
		}    
    }    

    //PARAMETERIZED CONSTRUCTOR
   public Donor(String name ,int age ,String sex , long contactno , String city , String user_id , String password ,String bloodgroup,String date) throws Exception
   {
       this.name = name;
       this.age = age;
       this.sex = sex;
       this.contactno = contactno;
       this.city = city;
       this.user_id = user_id;
       this.password = password;
       this.bloodgroup = bloodgroup;
       this.date = date;
   }
   
   
   //INPUTTING THE DETAILS OF DONOR (it inserts the new Donor object in the dlist as well as in the DONORS.TXT file)
   
    public void inputDonor(String name, int age , String sex ,  long contactno, String city , String user_id, String password,String bloodgroup) throws Exception
    {
           
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
       LocalDateTime now = LocalDateTime.now();  
    	   System.out.println(dtf.format(now)); 
	   dlist.insert(new Donor(name , age ,sex , contactno, city , user_id, password ,bloodgroup,dtf.format(now))); 
	   
	   FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Donors.txt");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		Node<Donor> pos = dlist.getFirst();
		
		while(pos!=null)
		{
			o.writeObject(pos.getData());
			pos = pos.getNext();
		}
		
		o.close();
	    f.close();  
   }
    
 @Override
   public String toString()
   {
       return "\nName is :" + name + "\nUser ID:" + user_id  + "\nAge is :" + age + "\nSex is :" + sex +"\nContact Number is :" + contactno + "\nCity is:" + city +"\nBloodgroup:" + bloodgroup;
   }
  
 
   //FUNCTION TO DISPLAY THE DONOR DETAILS
   public void Displaydonorlist()
   {
       System.out.println("List of Donors is :");
       System.out.println(dlist.toString());
   }
   
   
   //FUNCTION TO WRITE THE CONTENTS OF LINKED LIST TO THE FILE - Donors.txt file
   
   public void dlistToFile() throws IOException
   {
	   FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Donors.txt");
	   ObjectOutputStream o = new ObjectOutputStream(f);
		
		Node<Donor> pos = dlist.getFirst();
		
		while(pos!=null)
		{
			o.writeObject(pos.getData());
			pos = pos.getNext();
		}
		
		o.close();
	    f.close();
   }
   
}

//======================  UPDATION =======================

//TO CHANGE THE CONTACT
/* public void changeContact(String id,String pass,long newno) throws IOException
{
		//Scanner sc = new Scanner(System.in);
		Node<Donor> pos = dlist.getFirst();
		
		while(pos!=null)
		{
			if(pos.getData().user_id.equals(id) && pos.getData().password.equals(pass))
			{
				pos.getData().contactno = newno;
			}
			pos = pos.getNext();
		}
		
		dlistToFile();
}

//TO CHANGE THE PASSWORD
public void changePassword(String id,String pass,String newpass) throws IOException
{
	   Node<Donor> pos = dlist.getFirst();
		
		while(pos!=null)
		{
			if(pos.getData().user_id.equals(id) && pos.getData().password.equals(pass))
			{
				pos.getData().password = newpass;
			}
			pos = pos.getNext();
		}
		
		dlistToFile();
}*/
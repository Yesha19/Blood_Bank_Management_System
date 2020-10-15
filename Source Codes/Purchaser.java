package BloodBankManagment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PURCHASER CLASS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
 * CONTAINS ATTRIBUTES of User class (as it extends it) and contains bloodgroup, plist (Purchaser Linked List)
 * 
 * CONTAINS FUNCTIONS:
 * 1. CONSTRUCTORS : To read the objects stored in file and insert that into dlist
 * 2. inputDonor() : inputting the details of Purchaser and storing that into file and dlist
 * 3. displayPurchaserList() : displaying Purchaser list
 * 4. changeContact() and changePassword() : changing the contact and password of that Purchaser
 * 5. plistToFile() : Storing the contents of plist to file
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Purchaser extends User 
{
    private String purpose;
    private String wantedbloodgroup;
    String date;
    LinkedList<Purchaser> plist;
    private static final long serialVersionUID = -3408929878503674916L;
    int p;
    
    //DEFAULT CONSTRUCTOR  (It takes the Purchaser objects stored in the PURCHASERS.TXT file and store it in the plist)
    
    public Purchaser() throws Exception
    {
        plist= new LinkedList<>();
        File f1 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Purchasers.txt");
		if(f1.exists())
		{
		   FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Purchasers.txt");
		   BufferedInputStream bis = new BufferedInputStream(file);
		   bis.mark(0);
		   bis.reset();
	       ObjectInputStream obj = new ObjectInputStream(file);
	       
	       //inserting each object from the list into the plist
	       Purchaser c1 = null;
	       while(bis.available()>0)
	       {
	    	   c1=(Purchaser) obj.readObject();
	    	   plist.insert(c1);
	       }
	       
	       obj.close();
	       file.close();
		}    
    }

    //PARAMETERIZED CONSTRUCTOR
    public Purchaser(String name,int age, String sex , long contactno , String city , String user_id , String password , String purpose, String wantedbloodgroup, String date) throws Exception
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.user_id = user_id;
        this.password = password;
        this.purpose = purpose;
        this.contactno = contactno;
        this.city = city;
        this.wantedbloodgroup = wantedbloodgroup;
        this.date = date;
    }
    
    //GETTERS AND SETTERS
    public String getPurposeOfPurchasing()
    {
        return purpose;
    }
    
    public void setPurposeOfPurchasing(String purpose)
    {
        this.purpose = purpose;
    }
    
    
  //INPUTTING THE DETAILS OF PURCHASER (it inserts the new Purchaser object in the plist as well as in the PURCHASERS.TXT file)
    
  public void inputPurchasers(String name, int age , String sex , long contactno , String city , String user_id, String password,String purpose , String wantedbloodgroup) throws Exception
  {      
	  //inserting the new object into the plist
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
      LocalDateTime now = LocalDateTime.now();  
   	   System.out.println(dtf.format(now)); 
   	   
	   plist.insert(new Purchaser(name,age,sex,contactno,city,user_id,password, purpose, wantedbloodgroup,dtf.format(now)));
	   
	   FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Purchasers.txt");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		//reading each object from the plist and writing it into the file
		Node<Purchaser> pos = plist.getFirst();
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
    	 return "\nName is :" + name + "\nUser ID:" + user_id  + "\nAge is :" + age + "\nSex is :" + sex +"\nContact Number is :" + contactno + "\nCity is:" + city + " Bloodgroup:" + wantedbloodgroup;
     }

     //DISPLAYING THE DETAILS OF PURCHASERS 
      public void Displaypurchaserslist()
      {
	       System.out.println("List of Purchasers is :");
	       System.out.println(plist.toString());
      }

	 public String getWantedBloodGroup() 
	 {
  		 return wantedbloodgroup;
	 }
	 
	 
	 //FUNCTION TO WRITE THE CONTENTS OF LINKED LIST INTO THE FILE - Purchasers.txt file
	 
	 public void plistToFile() throws IOException, ClassNotFoundException
	 {
		 FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Purchasers.txt");
		   ObjectOutputStream o = new ObjectOutputStream(f);
			
			Node<Purchaser> pos = plist.getFirst();
			
			while(pos!=null)
			{
				o.writeObject(pos.getData());
				pos = pos.getNext();
			}
			
			o.close();
		    f.close();
	 }
}
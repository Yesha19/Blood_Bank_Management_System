package BloodBankManagment;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  CLASS USER  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/*
 * Has attributes :-  NAME , AGE , CONTACTNO , USER ID, PASSWORD , CITY , GENDER , ULIST
 * 
 * Contains Functions :-
 * 
 * 1. CONSTRUCTORS - initialize ulist with the objects stored in the file 'UserDetails.txt'
 * 2. InputUser() - Takes input of the User and insert it into linked list and writes the linked list into the file
 * 3. UseridCheck() - returns 1 if the id is found and 0 if the id is not found in the Users.txt file
 * 4. UserCheck() - If id and password matches, it logs in into that account
 * 5. userUpdate() - Ask the user about the new fields and calls admin's Update functions 
 * 6. ulistToFile() - Function to write the objects in the linked list into the file
 * 
 */
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class User implements Serializable
{
    String name;
    int age;
    long contactno;
    String user_id;
    String password;
    String city;
    String sex;
    LinkedList<User> ulist;
    static final long serialVersionUID = 8791051550284411389L; 
   
    //CONSTRUCTOR
    
	public User() throws IOException, ClassNotFoundException
	{
		ulist = new LinkedList<>();
		
		File f1 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\UsersDetails.txt");
		if(f1.exists())
		{
		   FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\UsersDetails.txt");
		   BufferedInputStream bis = new BufferedInputStream(f);
		   bis.mark(0);
		   bis.reset();
		   ObjectInputStream o = new ObjectInputStream(bis);
	       
	       User c1 = null;
	       while(bis.available()>0)
	       {
	    	   c1=(User) o.readObject();
	    	   ulist.insert(c1);
	       }
	       
	       o.close();
	       bis.close();
	       f.close();
		}    
	}
	
	public User(String name , int age , String sex , long contactno, String city , String user_id,String password)
	{
	    this.name = name;
	    this.age = age;
	    this.sex = sex;
	    this.contactno = contactno;
	    this.city = city;
	    this.user_id = user_id;
	    this.password = password;
	}
	
	public void inputUser(String name, int age, String sex, long contactno ,String city , String user_id , String password) throws IOException
	{
		//inserting new User in ulist
		ulist.insert(new User(name,age,sex,contactno,city,user_id,password));
		
		//opening file in writing mode
		FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\UsersDetails.txt");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		//writing the updated linked list into the file
		Node<User> pos = ulist.getFirst();
		while(pos!=null)
		{
			o.writeObject(pos.getData());
			pos = pos.getNext();
		}
		
		//closing the file
		o.close();
	    f.close();
		
	    //updating the Users.txt file with addition of new registered Id and Password
		FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt",true);
		PrintWriter w = new PrintWriter(fw);
		
		w.write(user_id + " " + password);
		w.println();
		
		w.close();
		fw.close();
		
	}
	
	//FUNCTION TO RETURN 1 IF THE USERID ALREADY EXISTS
	public int userIdCheck(String id) throws IOException
	{
		String h;
		String[] w = new String[5];
		int temp = 0;
		
		File f1 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
		
		if(f1.exists())
		{
			FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
			InputStreamReader fin = new InputStreamReader(f);
			BufferedReader din  = new BufferedReader(fin);
			
			while((h=din.readLine())!=null)
			{
				w = h.split("\\s");
				if(w[0].equals(id))
				{
					temp = 1;
					break;
				}
			}
		}
		
		return temp;
	}
	
	//FUNCTION TO LOG IN WHEN THE USER ID AND PASSWORD IS REGISTERED
	
	public int userCheck(String id,String pass) throws IOException
	{
		String h;
		String[] w;
		int temp = 0;
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[0].equals(id) && w[1].equals(pass))
			{
				System.out.println("\n \n~~~~~~~~~~~~~  You are logged in! ~~~~~~~~~~~~~~~~");
				System.out.println("Hello " + id + "\n\n");
				temp = 1;
				break;
			}
		}
		
		din.close();
		fin.close();
		f.close();
		
		return temp;
	}
	
	//UPDATION OF THE RECORDS OF THE USER 
	public void userUpdate(String id,String pass,Donor d,Purchaser p,Admin a) throws IOException, ClassNotFoundException
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n WHAT DO YOU WANT TO CHANGE ? \n");
		System.out.println("1. Contact Number");
		System.out.println("2. Password");
		System.out.println("3. Both");
		choice = sc.nextInt();
		
		switch(choice)
		{
			case 1:
			{
				long newno;
				System.out.println("\n\nEnter new Contact Number:");
				newno = sc.nextLong();
				a.changeContact(id,pass,newno,this,d,p);
				break;
			}
			
			case 2:
			{
				String newpass;
				System.out.println("\n\nEnter new Password:");
				newpass = sc.next();
				a.changePassword(id,pass,newpass,this,d,p);
				break;
			}
			
			case 3:
			{
				long newno;
				String newpass;

				System.out.println("\n\nEnter new Contact Number:");
				newno = sc.nextLong();
				
				System.out.println("\n\nEnter new Password:");
				newpass = sc.next();
				
				a.changeContact(id,pass,newno,this,d,p);
				a.changePassword(id,pass,newpass,this,d,p);
				break;
			}
		}
		
	}
	
	//FUNCTION TO WRITE THE CONTENTS OF ulist INTO FILE
	public void ulistToFile() throws IOException
	{
		FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\UsersDetails.txt");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		Node<User> pos = ulist.getFirst();
		while(pos!=null)
		{
			o.writeObject(pos.getData());
			pos = pos.getNext();
		}
		
		o.close();
	    f.close();
	}
}

